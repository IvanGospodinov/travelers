package dbConnection;

import model.Post;

public class PostDAO {

	Post post = new Post();
	
	public void add() {
		post.addImagesToSet();
	}
	
}
