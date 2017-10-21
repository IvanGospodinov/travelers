package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dbConnection.UserDAO;
import model.User;
import model.UserException;

public class UserTest {

	private UserDAO userDao = new UserDAO();
	private User testUser = new User("Te11sdf2st", "Tessdf112tTest", "Tes1sdf12tTest", "Tessdft1T12est", "T12estsdfTest","Tesdfst12Test");
	
	@Test
	public void testRegisterUser() throws UserException {
		String id = userDao.registerUser(testUser);
		
		assertNotEquals(id, "FAIL");
		
		int id2 = userDao.loginUser(testUser);
		System.out.println("ID after login " + id2);
		
		//assertEquals(id, id2);
		
		testUser.setUserID(id2);
	}


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
//	
//	int id2;
//	try {
//		id2 = userDao.loginUser(testUser);
//		assertEquals(id, id2);
//	} catch (UserException e) {
//		e.getMessage();
//	}

//}	

}
