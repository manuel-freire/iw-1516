/**
 * 
 */
package es.fdi.iw.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Tests logic in User.java
 * 
 * @author mfreire
 */
public class UserTest extends DbTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
    @Test
    public void testNewUser() {
            EntityManager entityManager = Persistence.createEntityManagerFactory("demoPU")
            		.createEntityManager();
            entityManager.getTransaction().begin();
            User user = new User();
            user.setLogin("bob");
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            // see that the ID of the user was set by Hibernate
            System.out.println("user=" + user + ", user.id=" + user.getId());
            User foundUser = entityManager.find(User.class, user.getId());
            // note that foundUser is the same instance as user and is a concrete
            // class (not a JDX proxy)
            System.out.println("foundUser=" + foundUser);
            assertEquals("Same name", user.getLogin(), foundUser.getLogin());
            entityManager.close();
    }
	
	@Test
	public void testHexStringConversion() {
		assertArrayEquals(new byte[] {0x00, (byte) 0xff}, User.hexStringToByteArray("00ff"));
		assertArrayEquals(new byte[] {(byte) 0xff, 0x42}, User.hexStringToByteArray("ff42"));

		String example = "aabb1234deadbeef";
		assertEquals(User.byteArrayToHexString(User.hexStringToByteArray(example)), example);
	}
	
	@Test
	public void testPasswordHashing() {
		User u1 = User.createUser("abc", "def", "admin");
		User u2 = User.createUser("xyz", "def", "admin");
		assertFalse("not same salt for 2 users", 
				u1.getSalt().equals(u2.getSalt()));
		assertFalse("therefore, not same hash for 2 users", 
				u1.getHashedAndSalted().equals(u2.getHashedAndSalted()));
		assertFalse("bad pass is bad", u1.isPassValid("bad"));
		assertTrue("good pass is good", u1.isPassValid("def"));
		assertTrue("good pass is good", u2.isPassValid("def"));
	}
}
