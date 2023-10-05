package lulu_02_Database.Systematic;

	import java.sql.Connection;

	import java.sql.DriverManager;

	public class ConnectDB {

		//Logic for connections to be ready and available

		//username, password, url for third party tool

		static Connection connection;

		public static Connection setupConnection() {

			try {

				 Class.forName("com.mysql.cj.jdbc.Driver");//drive support sets up

		         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/product",

		            "root", "Pranj@8105153699");

			}

			catch(Exception E) {


			}

			return connection;

		}

	}

