package dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbConnection.DBConnection;
import model.User;
import model.UserException;
import util.Encrypter;



public class UserDAO {

	private static final String INSERT_USER_SQL = "INSERT INTO users VALUES (null, ?, md5(?),?,?,?,?)";
	private static final String CHECK_FOR_USER = "SELECT user_id FROM users WHERE user_email = ?";
	private static final String SELECT_USER_SQL = "SELECT user_id FROM users WHERE user_email = ? AND user_password = md5(?)";

	public String registerUser(User user) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();
		if (checkIfUserExists(user) == 1) {
			try {
				PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getUserName());
				ps.setString(2, Encrypter.encrypt(user.getPassword()));
				ps.setString(3, user.getEmail());
				ps.setString(4, user.getFirstName());
				ps.setString(5, user.getLastName());
				ps.setString(6, user.getPictureURL());

				ps.executeUpdate();

//				ResultSet rs = ps.getGeneratedKeys();
//				if(rs.next() == false) {
//					return "FAIL";
//				}
				return "SUCCESS";

			} catch (SQLException e) {
				throw new UserException("User cannot be registered now, please try again later!", e);
			}
		}
//		} else {
//			return "FAIL";
//		}
			return "FAIL";
	}

	
	
	
//	public String registerUser(User user) throws UserException {
//		Connection connection = DBConnection.getInstance().getConnection();
//
//		if (checkIfUserExists(user) == 1) {
//			try {
//				PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
//				ps.setString(1, user.getUserName());
//				ps.setString(2, user.getPassword());
//				ps.setString(3, user.getEmail());
//				ps.setString(4, user.getFirstName());
//				ps.setString(5, user.getLastName());
//				ps.setString(6, user.getPictureURL());
//
//				int i = ps.executeUpdate();
//
//				if (i != 0) {// Just to ensure data has been inserted into the database
//					return "SUCCESS";
//				}
//
//				else {
//					return "Oops.. Something went wrong there..!"; // On failure, send a message from here.
//				}
//
//				// ps.executeUpdate();
//				//
//				// ResultSet rs = ps.getGeneratedKeys();
//				// rs.next();
//				// return rs.getInt(1);
//
//			} catch (SQLException e) {
//				throw new UserException("User cannot be registered now, please try again later!", e);
//			}
//		} else {
//			throw new UserException("A user with this email has already been registered!");
//
//		}
//
//	}

//	public int loginUser(User user) throws UserException {
//		Connection connection = DBConnection.getInstance().getConnection();
//
//		try {
//			PreparedStatement ps = connection.prepareStatement(SELECT_USER_SQL);
//			ps.setString(1, user.getEmail());
//			ps.setString(2, user.getPassword());
//
//			ResultSet rs = ps.executeQuery();
//			if (rs.next() == false) {
//				throw new UserException("Wrong password or email! Please try again!.");
//			}
//			return rs.getInt(1);
//		} catch (SQLException e) {
//			throw new UserException("User cannot be logged right now!", e);
//		}
//	}
//
//	public int loginUser(LoginBean loginBean) throws UserException {
//		Connection connection = DBConnection.getInstance().getConnection();
//
//		try {
//			PreparedStatement ps = connection.prepareStatement(SELECT_USER_SQL);
//			ps.setString(1, loginBean.getUser_email());
//			ps.setString(2, loginBean.getUser_password());
//
//			ResultSet rs = ps.executeQuery();
//			if (rs.next() == false) {
//			//	throw new UserException("Wrong password or email! Please try again!.");
//				return 0;
//			}
//			return rs.getInt(1);
//		} catch (SQLException e) {
//			throw new UserException("User cannot be logged right now!", e);
//		}
//	}

	
	
	
	public int checkIfUserExists(User user) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(CHECK_FOR_USER);
			ps.setString(1, user.getEmail());

			ResultSet rs = ps.executeQuery();

			if (rs.next() == true) {
				// if such a user exists throw an exception
//				throw new UserException("A user with this email has already been registered!");
				return 0;
			}
			//If there is no such user
			return 1;
		} catch (SQLException e) {
			throw new UserException("User cannot be registered right now!", e);
		}
	}
	
	
	

//	public int checkIfUserExists(RegisterBean registerBean) throws UserException {
//		Connection connection = DBConnection.getInstance().getConnection();
//
//		try {
//			PreparedStatement ps = connection.prepareStatement(CHECK_FOR_USER);
//			ps.setString(1, registerBean.getUser_email());
//
//			ResultSet rs = ps.executeQuery();
//
//			if (rs.next() == true) {
//				// if such a user exists throw an exception
//				throw new UserException("A user with this email has already been registered!");
//			}
//			return 1;
//		} catch (SQLException e) {
//			throw new UserException("User cannot be registered right now!", e);
//		}
//	}

	// public int registerUser(User user) throws UserException {
	// Connection connection = DBConnection.getInstance().getConnection();
	//
	// try {
	// //checking if the user exists if not we add her to the DB
	// //if yes we call the loginUser method
	// if(loginUser(user) == 0) {
	// PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL,
	// Statement.RETURN_GENERATED_KEYS);
	// ps.setString(1, user.getUserName());
	// ps.setString(2, user.getPassword());
	// ps.setString(3, user.getEmail());
	// ps.setString(4, user.getFirstName());
	// ps.setString(5, user.getLastName());
	// ps.executeUpdate();
	//
	// ResultSet rs = ps.getGeneratedKeys();
	// rs.next();
	// return rs.getInt(1);
	// } else {
	// throw new UserException("A user with this email has already been
	// registered!");
	// //return loginUser(user);
	// }
	// } catch (SQLException e) {
	// throw new UserException("User cannot be registered now, please try again
	// later!", e);
	// }
	// }

	public int loginUser(User user) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_USER_SQL);
			ps.setString(1, user.getEmail());
			ps.setString(2, Encrypter.encrypt(user.getPassword()));
			ps.executeQuery();

			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
//				throw new UserException("Wrong password or email! Please try again!");
				return 0;
			}
		} catch (SQLException e) {
			throw new UserException("User cannot be logged right now!", e);
		}
		return 1;
	}
	
	
	
	public void addImage() {
		
	}

}