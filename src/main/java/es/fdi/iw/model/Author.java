package es.fdi.iw.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name="allAuthors",
            query="select a from Author a")
})
public class Author {
	private long id;
	private String familyName;
	private String lastName;
	private List<Book> writings;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@ManyToMany(targetEntity=Book.class, fetch=FetchType.EAGER)
	public List<Book> getWritings() {
		return writings;
	}
	public void setWritings(List<Book> writings) {
		this.writings = writings;
	}
}
