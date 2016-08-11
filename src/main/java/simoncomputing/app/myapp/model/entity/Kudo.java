package simoncomputing.app.myapp.model.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@Table(name = "KUDO")
public class Kudo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long kudoId;
	private User kudoer;
	private User kudee;
	private String comment;
	private Set<Vote> votes = new LinkedHashSet<>();
	private Set<Abuse> abuses = new LinkedHashSet<>();

	@Id
	@SequenceGenerator(name = "kudoSequence", sequenceName = "KUDO_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "kudoSequence", strategy = GenerationType.SEQUENCE)
	@Column(name = "KUDO_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getKudoId() {
		return kudoId;
	}

	public void setKudoId(Long kudoId) {
		this.kudoId = kudoId;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "KUDOER")
	public User getKudoer() {
		return kudoer;
	}

	public void setKudoer(User kudoer) {
		this.kudoer = kudoer;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "KUDEE")
	public User getKudee() {
		return kudee;
	}

	public void setKudee(User kudee) {
		this.kudee = kudee;
	}

	@Column(name = "CMNT", length = 500)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "kudo", orphanRemoval = true)
	@JsonManagedReference
	public Set<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "kudo", orphanRemoval = true)
	@JsonManagedReference
	public Set<Abuse> getAbuses() {
		return abuses;
	}

	public void setAbuses(Set<Abuse> abuses) {
		this.abuses = abuses;
	}

}
