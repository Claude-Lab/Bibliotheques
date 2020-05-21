package fr.lusseau.claude.bibliotheques.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.lusseau.claude.bibliotheques.dal.Settings;

public class JdbcTools {

	private static String url;
	private static String username;
	private static String password;

	static {

		try {
			Class.forName(Settings.getPropery("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		url = Settings.getPropery("url");
		username = Settings.getPropery("username");
		password = Settings.getPropery("password");
		System.out.println("url=" + url + "username=" + username + "password=" + password);
	}

	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

}
