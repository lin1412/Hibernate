package simoncomputing.app.myapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import simoncomputing.app.myapp.model.entity.reference.RefRole;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@Table(name = "USER")
public class User extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private RefRole role;

	@Id
	@SequenceGenerator(name = "userSequence", sequenceName = "USER_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "userSequence", strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NM", unique = true, length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PSWRD", length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "FRST_NM", length = 50)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LST_NM", length = 50)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE")
	public RefRole getRole() {
		return role;
	}

	public void setRole(RefRole role) {
		this.role = role;
	}

}
