package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;

import org.junit.Test;

import dbConnection.PostDAO;
import model.Post;
import model.UserException;

public class PostTest {
	
	private PostDAO postDao = new PostDAO();
	private Post postTest = new Post("AAABBB","AAABBB", LocalDate.now(),  LocalDate.now(), 1,1,"sofia");

	@Test
	public void test() {
		
		int result = 0;
		try {
			result = postDao.createPost(postTest);
		} catch (UserException e) {
		System.out.println("v test bloka syso");
			e.printStackTrace();
		}
		assertNotEquals(result, 0);
		
		System.out.println("ID after post " + result);
	}
}

