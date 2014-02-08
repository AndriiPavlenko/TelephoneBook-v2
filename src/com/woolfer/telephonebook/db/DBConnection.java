package com.woolfer.telephonebook.db;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	public static Connection getConnection() throws SQLException, IOException
	   {
	      Properties props = new Properties();
	      FileInputStream in = null;
	      try {
			in = new FileInputStream("C:\\JavaProjects\\TelephoneBook-v2\\src\\com\\woolfer\\telephonebook\\db\\database.properties");
			props.load(in);
		      in.close();
	      } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      String drivers = props.getProperty("jdbc.drivers");
	      if (drivers != null) System.setProperty("jdbc.drivers", drivers);
	      String url = props.getProperty("jdbc.url");
	      String username = props.getProperty("jdbc.username");
	      String password = props.getProperty("jdbc.password");
	      try {
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      return DriverManager.getConnection(url, username, password);
	   }
}
