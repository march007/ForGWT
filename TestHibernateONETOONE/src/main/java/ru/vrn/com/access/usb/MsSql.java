package ru.vrn.com.access.usb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Предназначен для взаимодействия с базой данных MsSql, в которой храняться
 * данные о доступе к usb портам пользователей Active Directory, а также
 * соответстивия имени компьютера и пользователя.
 * 
 * 
 * @author marchenko
 * 
 * @create 17.06.2013
 */
public class MsSql {

	private List<String> list;

	public MsSql(List<String> list) {
		this.list = list;
	}

	public MsSql() {
	}

	/**
	 * Предназначена для проверки доступа к usb портам пользователей Active
	 * Directory.
	 * 
	 * @param string
	 *            - список имени акааунтов Active Directory
	 * 
	 * @return List<String> - список строк, предоставляющий информацию о доступе
	 *         пользователей Active Directory к usb портам, а также
	 *         соответстивия имени компьютера и пользователя. Строка
	 *         представляет собой имя компьютера и имя пользователя из Active
	 *         Directory, у которого есть доступ к usb портм, разделенных
	 *         символом ":", для последдующего удобства разбиения.
	 */
	public List<String> checkUserUsb(List<String> string) {

		List<String> listUsersUsb = new ArrayList<String>();

		StringBuilder builder = new StringBuilder();

		String queryForUsers = "SELECT  distinct([strWinHostName]) as host, "
				+ "[nGroup] as groupId, "
				+ "users.wstrSamAccountName as account FROM [KAV].[dbo].[Hosts] as host "
				+ "left join [KAV].[dbo].[hst_user_visited] as visit "
				+ "on host.nId = nHost left join [KAV].[dbo].[ak_users] as users "
				+ "on visit.nUser = users.nId where";

		builder.append(queryForUsers);
		builder.append(" (");
		System.out.println("string " + string);
		boolean bool = true;
		for (String it : string) {
			if (bool) {
				builder.append("users.wstrSamAccountName = ");
				builder.append("'");
				builder.append(it);
				builder.append("'");
				bool = false;
			} else {
				builder.append(" or ");
				builder.append("users.wstrSamAccountName = ");
				builder.append("'");
				builder.append(it);
				builder.append("'");
			}
		}

		builder.append(" ) and not visit.nHost in (SELECT [nId] "
				+ "FROM [KAV].[dbo].[Hosts] where strWinHostName like 'vrn%')");

		try {

			Connection conn = getConnection();
			Statement stmt;
			ResultSet result = null;

			System.out.println("builder.toString()  " + builder.toString());
			stmt = conn.createStatement();
			result = stmt.executeQuery(builder.toString());

			bool = false;
			int count = 0;
			String name = "";
			String previosName = "";
			while (result.next()) {

				name = result.getString("account");
				count++;

				if (!previosName.equals(name)) {
					count++;
					String host = result.getString("host");

					String group = result.getString("groupId");

					if (group.equals("53"))
						listUsersUsb.add(name + ":" + host);
				}

				previosName = name;

			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}

		return listUsersUsb;
	}

	/**
	 * Предназначена для подключения к базе данных MsSql, где содержиться
	 * информация о доступе к usb портам пользователей Active Directory, а также
	 * соответстивия имени компьютера и пользователя.
	 * 
	 * @return Connection - соединение с базой данных, подготовленное для
	 *         взимодействия.
	 * 
	 * @see java.sql.Connection
	 */
	private Connection getConnection() {

		try {
			String userName = "sa";
			String password = "************";
			String url = "jdbc:sqlserver://vrn-m1\\SQLExpress;databaseName=KAV";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
					.newInstance();
			Connection conn = DriverManager.getConnection(url, userName,
					password);

			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
