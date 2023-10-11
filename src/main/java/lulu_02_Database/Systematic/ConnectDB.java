package lulu_02_Database.Systematic;

	import java.sql.Connection;

	import java.sql.DriverManager;

	public class ConnectDB {

		//Logic for connections to be ready and available

		//username, passwor, url for third party tool

		static Connection connection;

		public static Connection setupConnection() {

			try {

				 Class.forName("com.mysql.cj.jdbc.Driver");//drive support sets up

		         connection = DriverManager.getConnection("path",

		            "root", "");

			}

			catch(Exception E) {


			}

			return connection;

		}

	}

