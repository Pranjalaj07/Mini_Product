package lulu_02_Database.Systematic;

	import java.sql.Connection;

	import java.sql.PreparedStatement;

	import java.sql.ResultSet;

	import java.sql.SQLException;

	import java.sql.Statement;

	public class ProductLogic {

	void createData() throws SQLException {

		Connection connection = ConnectDB.setupConnection();

		String query ="INSERT INTO products10 ( prodid, prodname,proddesc , prodcost ) VALUES( ?, ?,?,?)";

//		String query = "insert values into employee(? ,? ,?)  ";

		PreparedStatement myStmt = connection.prepareStatement(query);

		myStmt.setInt(1,666 );

		myStmt.setString(2, "television");

		myStmt.setString(3, "tablet");
		
		myStmt.setInt(4,7665);

	 

	 

		int success = myStmt.executeUpdate();

		System.out.println("Added Successfully " + success);

	 

		}

		void readData() throws SQLException {

			Connection connection=ConnectDB.setupConnection();

			 Statement statement;

			 statement = connection.createStatement();

	        ResultSet resultSet;

	        resultSet = statement.executeQuery(

	            "select * from products10 where prodid>=001");

	        int prodid;

	        String prodname;

	        String proddesc;
	        
	        int prodcost;

	        while (resultSet.next()) {

	            prodid = resultSet.getInt("prodid");

	            prodname = resultSet.getString("prodname");

	            proddesc=resultSet.getString("proddesc");
	            
	            prodcost=resultSet.getInt("prodcost");
	            
	            

	            System.out.println("prodid : " + prodid

	                               + " prodname : " + prodname +"  proddesc:"+ prodcost +" prodcost : " + prodname );

	        }

	}
	}
		/*

		  void updateData() throws SQLException {

			Connection connection = ConnectDB.setupConnection();

			String query = "update products10 set prodname= ? where prodid = ? ";

			PreparedStatement myStmt = connection.prepareStatement(query);

			myStmt.setString(1, "computer");

			myStmt.setInt(2, 1111);

			boolean success = myStmt.execute();

			System.out.println("Updated Successfully " + success);

	 

		}
		  

		  void deleteData() throws SQLException {

			Connection connection = ConnectDB.setupConnection();

			String query = "delete from products10 where prodid = ? ";

			PreparedStatement myStmt = connection.prepareStatement(query);

			myStmt.setInt(001, 4000 );

			boolean success = myStmt.execute();

			System.out.println("Deleted Successfully " + success);

	 

		}
		
		  
	
		  void batchProcess() throws SQLException {

			Connection connection = ConnectDB.setupConnection();


			Statement stmt = connection.createStatement();


				stmt.addBatch("insert into products10 values(61 ,'mirror','A mirror is a flat smooth and reflective surface ',1000");

				stmt.addBatch("insert into products10 values(62 ,'piano','A piano is a versatile and iconic musical instrument ',20000");

				stmt.addBatch("insert into products10 values(63 ,'violin','The violin is a classical stringed musical instrument ',10000");

				stmt.executeBatch();//executing the batch

				System.out.println("Batch executed successfully!");


//				Submits a batch of commands to the database for execution and if all 

//				commands execute successfully, returns an array of update counts.

	 

		}
		  
		  
		  

		  void tryBatchMore() throws SQLException {

				Connection connection = ConnectDB.setupConnection();

				String SQL = "INSERT INTO products10 (prodid, prodname, proddesc, prodcost) " +

			             "VALUES(?, ?, ? , ?)";

			PreparedStatement pstmt = connection.prepareStatement(SQL);

			//Set auto-commit to false

			connection.setAutoCommit(false);

			// Set the variables

			pstmt.setInt( 20, 400 );

			pstmt.setString( 30, "abc" );

			pstmt.setString( 40, "xyz" );

			//pstmt.setInt( 4, 33 );

			// Add it to the batch

			pstmt.addBatch();

			// Set the variables

			pstmt.setInt( 50, 401 );

			pstmt.setString( 60, "vgf" );

			pstmt.setString( 70, "bhg" );

			//pstmt.setInt( 4, 31 );

			// Add it to the batch

			pstmt.addBatch();

			//add more batches

	 

			//Create an int[] to hold returned values

			int[] count = pstmt.executeBatch();

			//Explicitly commit statements to apply changes

			connection.commit();


			}
			

		  void StoredProceduresMore() throws SQLException {

	 

				Connection connection = ConnectDB.setupConnection();

				String query="call pull_products10 ()";

				java.sql.CallableStatement stmt = connection.prepareCall(query);

				//The interface used to execute SQL stored procedures

				ResultSet resultSet = stmt.executeQuery(query);

				//to display result sets//

	 

				int proid;

				String proname;

				String proddesc;
				
				int prodcost;

	 

				while (resultSet.next()) {

					int prodid = resultSet.getInt("prodid");

					String prodname = resultSet.getString("prodname");

					proddesc = resultSet.getString("proddesc");
					
					prodcost = resultSet.getInt("prodcost");
					
					

					System.out.println("prodid : " + prodid + " prodname : " + prodname + "  proddesc:" + proddesc+ "prodcost :"+prodcost);

				}

	 

		  }
	
		  

		  void TransactionsConcepts() throws SQLException {

				Connection connection = ConnectDB.setupConnection();

				String query = "INSERT INTO products10 ( prodid, prodname, proddesc , prodcost ) VALUES( ?, ?,?,?)";

//				String query = "insert values into employee(? ,? ,?)  ";

				PreparedStatement myStmt = connection.prepareStatement(query);

				connection.setAutoCommit(false);  //By default its always true 

				myStmt.setInt(010, 504);

				myStmt.setString(200, "nhg");

				myStmt.setString(300, "gdhjd");


				int success = myStmt.executeUpdate();

				connection.commit();

				//Makes all changes made since the previouscommit/rollback permanent and releases any database lockscurrently held by this Connection object.

				//This method should beused only when auto-commit mode has been disabled.

				connection.rollback();

				//Undoes all changes made in the current transactionand releases any database locks currently heldby this Connection object.

				//This method should beused only when auto-commit mode has been disabled.

				System.out.println("Added Successfully " + success);

			}


	}

*/