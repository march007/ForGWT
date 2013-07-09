package ru.vrn.com.access.internet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ru.vrn.com.datamodel.AccessInternet;
import ru.vrn.com.datamodel.UsersAD;

/**
 * Предназначен для взаимодействия с базой данных MySql, в которой храняться
 * данные о доступе к Интернету пользователей Active Directory
 * 
 * 
 * @author marchenko
 * 
 * @create 17.06.2013
 */
public class Mysql {
	public Mysql() {
	}

	/**
	 * Предназначена для проверки доступа к Интернету пользователей Active
	 * Directory.
	 * 
	 * @param list
	 *            - список пользователей Active Directory
	 * @param time
	 *            - Дата и время на данный момент.
	 * 
	 * @return List<AccessInternet> - список классов, предоставляющий информацию
	 *         о доступе пользователей Active Directory к интернету.
	 *         
	 * @see ru.vrn.com.datamodel.AccessInternet
	 */
	public List<AccessInternet> checkUserInternet(List<UsersAD> list,
			Timestamp time) {

		List<AccessInternet> listUsersInternet = new ArrayList<AccessInternet>();
		Connection conn = getConnection();

		StringBuilder builder = new StringBuilder();
		builder.append("SELECT user.nick, groups.nick as access FROM "
				+ "squidctrl.squidusers as user left join "
				+ "squidctrl.groups as groups on user.group = groups.name"
				+ " where user.nick = '");

		System.out.println("list " + list);
		boolean bool = true;
		for (UsersAD string : list) {
			if (bool) {
				builder.append(string.getAccount());
				builder.append("'");
				bool = false;
			} else {

				builder.append(" or ");
				builder.append("user.nick = ");
				builder.append("'");
				builder.append(string.getAccount());
				builder.append("'");
			}
		}

		try {

			String userQuery = builder.toString();

			Statement stmt;
			ResultSet result = null;

			stmt = conn.createStatement();

			result = stmt.executeQuery(userQuery);

			while (result.next()) {
				String str = result.getString("nick");

				String str1 = result.getString("access");

				if (!str1.equals("Offline")) {

					for (UsersAD usersAD : list) {
						if (usersAD.getAccount().equals(str)) {
							AccessInternet accessInternet = new AccessInternet();
							accessInternet.setDateLastMofification(time);
							accessInternet.setHomeAddress(usersAD);
							listUsersInternet.add(accessInternet);
							break;
						}
					}

				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listUsersInternet;
	}

	/**
	 * Предназначена для подключения к базе данных MySql, где содержиться
	 * информация о доступе к ИНтернету пользователей Acticve Directory.
	 * 
	 * @return Connection - соединение с базой данных, подготовленное для
	 *         взимодействия.
	 *         
	 * @see java.sql.Connection
	 */
	private Connection getConnection() {

		try {

			String userName = "root";
			String password = "*********";
			String url = "jdbc:mysql://10.10.2.3/squidctrl";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(url, userName,
					password);

			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
