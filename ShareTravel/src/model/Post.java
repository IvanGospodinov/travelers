package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import dbConnection.DBConnection;
import util.Encrypter;

public class Post {

	private static final String SELECT_USER_SQL = "SELECT user_pictureURL FROM users WHERE user_id = ?";
	
	public Set<String> images = new HashSet<String>();
	
	public void addImagesToSet() {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < 5; i++) {
				int user = new Random().nextInt(26)+15;
				ps.setInt(1, user);
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				images.add(rs.getString(1));
			}

		} catch (SQLException e) {
			
		}
	}
}
