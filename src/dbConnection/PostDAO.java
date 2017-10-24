package dbConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.Post;
import model.UserException;



public class PostDAO {
	
	
	private static PostDAO instance;
	
	public PostDAO(){}
	
	public static synchronized PostDAO getInstance(){
		if(instance==null){
			instance=new PostDAO();
		}
		return instance;
	}
	
	
	private static final String INSERT_POST_SQL = "INSERT INTO posts VALUES (null,?,?,?,?,?,?,?)";
	
	public int createPost(Post post) throws UserException {
	
		Connection connection = DBConnection.getInstance().getConnection();
		
			try {
				PreparedStatement ps = connection.prepareStatement(INSERT_POST_SQL, Statement.RETURN_GENERATED_KEYS);
			
				ps.setString(1, post.getTitle());
				ps.setString(2, post.getDescription());
				ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
				ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
				ps.setInt(5, 1);
				ps.setInt(6, 1);
				ps.setString(7, "sofia");

				
//				ps.setString(1, post.getCategory());
//				ps.setString(2, post.getLocation());
				ps.executeUpdate();

				ResultSet rs = ps.getGeneratedKeys();
				
				
				rs.next();
				post.setPostId(rs.getInt(1));
				return post.getPostId();
			} catch (SQLException e) {
				throw new UserException("post cannot be registered now, please try again later!", e);
			}

	}
}
