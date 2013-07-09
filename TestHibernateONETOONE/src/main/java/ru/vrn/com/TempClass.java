package ru.vrn.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ru.vrn.com.datamodel.ListOfMonitoring;

public class TempClass {
	
	private List<ListOfMonitoring>  list = new ArrayList<ListOfMonitoring>();
	private List<String>  listAccounts = new ArrayList<String>();
	
	public List<String> getListAccounts() {
		return listAccounts;
	}



	public void setListAccounts(List<String> listAccounts) {
		this.listAccounts = listAccounts;
	}

	public TempClass() {
		System.out.println("aaa");
		Connection conn = getConnection();
		
		Statement stmt;
		ResultSet result = null;

		try {
			stmt = conn.createStatement();
			
			result = stmt.executeQuery("SELECT * FROM LIST_OF_MONITORING a");
			
			
			while(result.next()){
				ListOfMonitoring monitoring = new ListOfMonitoring();
				
				String version = result.getString("version");
				String domain = result.getString("domain");
				String host = result.getString("host");
				String host_pass = "Marchello2010";
				String host_user = result.getString("HOST_USER");
				String path = result.getString("path");
				String PROGRAMM_1C_PASSWORD = result.getString("PROGRAMM_1C_PASSWORD");
				String ref = result.getString("REF");
				String sqlactive = result.getString("SQLACTIVE");
				String sqlServer = result.getString("SERVER");
				String PROGRAMM_USER = result.getString("PROGRAMM_USER");
				
				
				monitoring.setVersion(version);
				monitoring.setDomain(domain);
				monitoring.setHost(host);
				monitoring.setHostPassword(host_pass);
				monitoring.setHostUser(host_user);
				monitoring.setPath(path);
				monitoring.setProgram1cPassword(PROGRAMM_1C_PASSWORD);
				monitoring.setRef(ref);
				monitoring.setSrv(sqlServer);
				monitoring.setUser(PROGRAMM_USER);
				monitoring.setSqlActive(true);
				
				System.out.println("monitoring " + monitoring);
				list.add(monitoring);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		System.out.println("userQuery  " + userQuery);
		
		
		
	/*	Connection conn1 = getConnection();
		
		Statement stmt1;
		ResultSet result1 = null;

		try {
			stmt1 = conn.createStatement();
			
			result1 = stmt1.executeQuery("SELECT * FROM USERS_AD a");
			while(result1.next()){
				String version = result.getString("account");
				
				listAccounts.add(version);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
	

	private Connection getConnection() {
		try {

			String userName = "sysdba";
			String password = "masterkey";
//			String url1 ="jdbc:firebirdsql://localhost:3050/C:/FirebirdDB/EMPLOYEEDB.fdb", 
			String url = "jdbc:firebirdsql://localhost:3050/D:/dbs/MONITORINGDB.FDB";
			Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
			Connection conn = DriverManager.getConnection(url, userName,
					password);

			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<ListOfMonitoring> getList() {
		return list;
	}

	public void setList(List<ListOfMonitoring> list) {
		this.list = list;
	}
}
