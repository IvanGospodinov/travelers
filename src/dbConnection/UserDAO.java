package dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import dbConnection.DBConnection;
import model.User;
import model.UserException;
import util.Encrypter;



public class UserDAO {

	private static final String INSERT_USER_SQL = "INSERT INTO users VALUES (null, ?, ?,?,?,?,?)";
	private static final String CHECK_FOR_USER = "SELECT user_id FROM users WHERE user_email = ?";
	private static final String SELECT_USER_SQL = "SELECT user_id FROM users WHERE user_email = ? AND user_password = ?";
	private static final String GET_USER_FROM_SQL = "SELECT user_id, uname, user_password, user_firstname, user_lastname, user_pictureURL FROM users WHERE user_email = ?";

	public void registerUser(User user) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setString(2, Encrypter.encrypt(user.getPassword()));
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setString(6, user.getPictureURL());
			System.out.println(user.getPictureURL());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			user.setUserID(rs.getInt(1));

		} catch (SQLException e) {
			throw new UserException("User cannot be registered now, please try again later!", e);
		}

	}

	public boolean loginUser(String email, String password) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(CHECK_FOR_USER);
			ps.setString(1, email);
			//ps.setString(2, Encrypter.encrypt(password));
			rs = ps.executeQuery();
			rs.next();
			System.out.println(rs.getInt(1) > 0);
			return rs.getInt(1) > 0;
		} catch (SQLException e) {
			throw new UserException("There is no such user in our system!", e);
		}
	}			

	public User getUser(String userEmail) throws SQLException{
		Connection con = DBConnection.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement(GET_USER_FROM_SQL);
		ps.setString(1, userEmail);
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		User user = new User(
				rs.getInt("user_id"), 
				rs.getString("uname"), 
				rs.getString("user_password"), 
				rs.getString("user_firstname"),
				rs.getString("user_lastname"),
				rs.getString("user_pictureURL"));

		return user;
	}


	//	public boolean checkIfUserExists(String email, String password) throws UserException {
	//		Connection connection = DBConnection.getInstance().getConnection();
	//
	//		try {
	//			PreparedStatement ps = connection.prepareStatement(CHECK_FOR_USER);
	//			ps.setString(1, user.getEmail());
	//
	//			ResultSet rs = ps.executeQuery();
	//
	//			if (rs.next() == true) {
	//				// if such a user exists throw an exception
	//				//				throw new UserException("A user with this email has already been registered!");
	//				throw new UserException("There is a user with that email registered!");
	//			}
	//			//If there is no such user
	//			return true;
	//		} catch (SQLException e) {
	//			throw new UserException("User cannot be registered right now!", e);
	//		}
	//	}


	//		try {
	//			PreparedStatement ps = connection.prepareStatement(SELECT_USER_SQL);
	//			ps.setString(1, user.getEmail());
	//			ps.setString(2, Encrypter.encrypt(user.getPassword()));
	//			ps.executeQuery();
	//
	//			ResultSet rs = ps.executeQuery();
	//			if (rs.next() == false) {
	//				//throw new UserException("Wrong password or email! Please try again!");
	//				return false;
	//			}
	//		} catch (SQLException e) {
	//			throw new UserException("User cannot be logged right now!", e);
	//		}
	//		return true;

}