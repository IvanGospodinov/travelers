package model.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.Post;
import model.UserException;



public class PostDAO {
	
	
	private static final String INSERT_POST_SQL = "INSERT INTO posts VALUES (null, ?,?,?)";
		
		
		
	public String createPost(Post post) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();
		
			try {
				PreparedStatement ps = connection.prepareStatement(INSERT_POST_SQL, Statement.RETURN_GENERATED_KEYS);
			//	ps.setString(1, post.getCategory());
				ps.setString(1, post.getTitle());
			//	ps.setString(2, post.getLocation());
				ps.setString(3, post.getDescription());
				

				ps.executeUpdate();

//				ResultSet rs = ps.getGeneratedKeys();
//				if(rs.next() == false) {
//					return "FAIL";
//				}
				return "SUCCESS";

			} catch (SQLException e) {
				throw new UserException("post cannot be registered now, please try again later!", e);
			}
		
//		} else {
//			return "FAIL";
//		}
			//return "FAIL";
	}


}
