package com.config;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.Application;
import com.dao.VilleDao;
import com.dao.VilleDaoImpl;
import  java.sql.Connection;

public class JDBCConfiguration {

	private String url;
	private String username;
	private String password;
	
	private static final String CONTEXTE = "contexte";

	JDBCConfiguration(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public static JDBCConfiguration getInstance() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Application.class);
			logger.log(null, CONTEXTE, e);
		}
		
		return new JDBCConfiguration("jdbc:mysql://localhost:3306/projetmaven", "root", "root");
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	} 

	// RÃ©cupÃ©ration du Dao
	public VilleDao getVilleDao() {
		return new VilleDaoImpl(this);
	}
}
