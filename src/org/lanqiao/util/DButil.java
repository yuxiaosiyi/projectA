package org.lanqiao.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	private static String classname="oracle.jdbc.driver.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:ORCL";
	private static String user="scott";
	private static String password="tiger";
	private static Connection conn;
	public static Connection getconnection(){
		try {
			Class.forName(classname);
			try {
				conn=DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
