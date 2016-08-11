package simoncomputing.app.myapp.model.entity.reference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@Table(name = "REF_ROLE")
public class RefRole extends BaseRefEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String code;
	private String description;

	public RefRole() {

	}

	public RefRole(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@Id
	@Column(name = "CODE", unique = true, nullable = false, length = 3)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "DSC", length = 50)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
