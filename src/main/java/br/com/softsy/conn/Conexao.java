package br.com.softsy.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection conn = null;

	public static Connection conectarLyceum() throws ClassNotFoundException, SQLException {

		String connectionUrl = getUrlConnection("LYCEUM");
		connectionUrl = "jdbc:sqlserver://10.100.12.86:1433;databaseName=Lyceum;encrypt=true;trustServerCertificate=true;user=usr_lycweb;password=Ly!cAk2oT13euMW3b";

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			conn = DriverManager.getConnection(connectionUrl);
			
			

		} catch (SQLException e) {

			e.printStackTrace();
			throw e;

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			throw e;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return conn;

	}

	public static Connection conectarSumareIntegracoes() throws ClassNotFoundException, SQLException {

		String connectionUrl = getUrlConnection("SUMARE_INTEGRACOES");

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(connectionUrl);

		} catch (SQLException e) {

			e.printStackTrace();
			throw e;

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			throw e;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return conn;

	}

	public static String getUrlConnection(String bd) {
		return "jdbc:sqlserver://" + "10.100.12.86" + ":1433;" + "databaseName=" + bd + ";user="
				+ "usr_lycweb" + ";password=" + "Ly!cAk2oT13euMW3b"+";encrypt=false;trustServerCertificate=false;";
	}

	public static void desconectar() throws SQLException {
		conn.close();
	}

}