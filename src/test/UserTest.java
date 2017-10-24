package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dbConnection.UserDAO;
import model.User;
import model.UserException;

public class UserTest {

	private UserDAO userDao = new UserDAO();
	private User testUser = new User("BAAACCC", "BAAACCC", "BAAACCC", "AAACCC", "CCC","CCC");
	
	
	// regitrirane na user
	@Test
	public void testRegisterUser() throws UserException {
		int id = userDao.registerUser(testUser);
		assertNotEquals(id, 0);
		System.out.println("ID after login " + id);
		testUser.setUserID(id);
	}

	
//	@Test
//	public void testRegisterUser() throws UserException {
//		userDao.registerUser(testUser);
//		
//		
//		boolean user2 = userDao.loginUser("Tessdf112tTest", "Tes1sdf12tTest");
//		
//		assertEquals(user2, true);
//		
//		//testUser.setUserID(user);
//	}
//
//
//@Test
//public void testRegisterUser2() {
//	int id= 0;;
//	try {
//		id = userDao.registerUser(testUser);
//		assertNotSame(id, 0);
//	} catch (UserException e) {
//		System.out.println(e.getMessage());;
//		//e.printStackTrace();
//	}
//	System.out.println(id);
	
//	int id2;
//	try {
//		id2 = userDao.loginUser(testUser);
//		assertEquals(id, id2);
//	} catch (UserException e) {
//		e.getMessage();
//	}

}	


