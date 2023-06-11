package com.nit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
	private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());
	private static Connection con = null;

	private DBConnection() {
	}

	static {
		try {
            Class.forName("oracle.jdbc.OracleDriver");
            LOGGER.log(Level.INFO, "Oracle JDBC driver loaded successfully");

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
            LOGGER.log(Level.INFO, "Connected to the Oracle database successfully");

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.log(Level.SEVERE, "Failed to establish database connection", e);
		}
	}

	public static Connection getConnection() {
		return con;
	}
}
