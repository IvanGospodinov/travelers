package model.dbConnection;

	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DBConnection {
		
		private static DBConnection instance;
	
		private  Connection con;
		
		
		
		
		
		private DBConnection() {
			
			try {
				
			//	Class.forName("com.mysql.cj.jdbc.Driver"); 
				Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception e) {
				System.out.println("Driver not found or failed to load. Check your libraries");
			}
			
			 final String DB_HOSTNAME = "127.0.0.1";
			 final String DB_PORT = "3306";
			 final String DATABASE = "travel-share";
			 final String DB_USER = "root";
			 final String DB_PASSWORD = "1qaz!QAZ";
			
			
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + 
						DB_HOSTNAME + ":" + 
						DB_PORT + "/" + DATABASE, 
						DB_USER, DB_PASSWORD);
			} catch (SQLException exc) {
				System.out.println("opa pak v Connection");
			}
			
		}
			
			
			
		
		public static synchronized DBConnection getInstance() {
			if (instance == null) {
				instance = new DBConnection();
			}
			return instance;
		}

		public Connection getConnection() {
			return con;
		}
		
		
	

}
