package es.fdi.iw.model;

import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@NamedQueries({
    @NamedQuery(name="allUsers",
            query="select u from User u"),
    @NamedQuery(name="userByLogin",
        query="select u from User u where u.login = :loginParam"),
    @NamedQuery(name="delUser",
    	query="delete from User u where u.id= :idParam")
})
public class User {	
	
    private static BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
	
	// do not change these fields - all web applications with user authentication need them
	private long id;
	private String login;
	private String role;
	private String hashedAndSalted;
		
	// change fields below here to suit your application
	private List<Book> ownedBooks;

	public User() {}

	public static User createUser(String login, String pass, String role) {
		User u = new User();
		u.login = login;
		u.hashedAndSalted = generateHashedAndSalted(pass);
		u.role = role;
		return u;
	}
	
	public boolean isPassValid(String pass) {
		return bcryptEncoder.matches(pass, hashedAndSalted);		
	}
	
	/**
	 * Generate a hashed&salted hex-string from a user's pass and salt
	 * @param pass to use; no length-limit!
	 * @param salt to use
	 * @return a string to store in the BD that does not reveal the password even
	 * if the DB is compromised. Note that brute-force is possible, but it will
	 * have to be targeted (ie.: use the same salt)
	 */
	public static String generateHashedAndSalted(String pass) {
		/*
		Código viejo: sólo 1 iteración de SHA-1. bCrypt es mucho más seguro (itera 1024 veces...)
		
		Además, bcryptEncoder guarda la sal junto a la contraseña
		byte[] saltBytes = hexStringToByteArray(user.salt);
		byte[] passBytes = pass.getBytes();
		byte[] toHash = new byte[saltBytes.length + passBytes.length];
		System.arraycopy(passBytes, 0, toHash, 0, passBytes.length);
		System.arraycopy(saltBytes, 0, toHash, passBytes.length, saltBytes.length);
		return byteArrayToHexString(sha1hash(toHash));
		*/
		return bcryptEncoder.encode(pass);
	}	

	/**
	 * Converts a byte array to a hex string
	 * @param b converts a byte array to a hex string; nice for storing
	 * @return the corresponding hex string
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<b.length; i++) {
			sb.append(Integer.toString((b[i]&0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
	
	/**
	 * Converts a hex string to a byte array
	 * @param hex string to convert
	 * @return equivalent byte array
	 */
	public static byte[] hexStringToByteArray(String hex) {
		byte[] r = new byte[hex.length()/2];
		for (int i=0; i<r.length; i++) {
			String h = hex.substring(i*2, (i+1)*2);
			r[i] = (byte)Integer.parseInt(h, 16);
		}
		return r;
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(unique=true)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHashedAndSalted() {
		return hashedAndSalted;
	}

	public void setHashedAndSalted(String hashedAndSalted) {
		this.hashedAndSalted = hashedAndSalted;
	}

	@OneToMany(targetEntity=Book.class)
	@JoinColumn(name="owner") // <-- this avoids creating an extra User_Book table
	public List<Book> getOwnedBooks() {
		return ownedBooks;
	}

	public void setOwnedBooks(List<Book> ownedBooks) {
		this.ownedBooks = ownedBooks;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String toString() {
		return "" + id + " " + login + " " + hashedAndSalted;
	}
}
