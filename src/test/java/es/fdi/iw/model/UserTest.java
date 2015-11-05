package es.fdi.iw.model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.fdi.iw.SpringBootLauncher;

/**
 * Tests logic in User.java
 * 
 * @author mfreire
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringBootLauncher.class)
public class UserTest {	
	
	@Autowired
	EntityManager entityManager;
	
    @Test
    @Transactional
    public void testNewUser() {
            User user = new User();
            user.setLogin("bob");
            entityManager.persist(user);
            entityManager.flush();
            // see that the ID of the user was set by Hibernate
            System.out.println("user=" + user + ", user.id=" + user.getId());
            User foundUser = entityManager.find(User.class, user.getId());
            System.out.println("foundUser=" + foundUser);
            assertEquals("Same name", user.getLogin(), foundUser.getLogin());
    }
	
	@Test
	public void testHexStringConversion() {
		assertArrayEquals(new byte[] {0x00, (byte) 0xff}, User.hexStringToByteArray("00ff"));
		assertArrayEquals(new byte[] {(byte) 0xff, 0x42}, User.hexStringToByteArray("ff42"));

		String example = "aabb1234deadbeef";
		assertEquals(User.byteArrayToHexString(User.hexStringToByteArray(example)), example);
	}
}
