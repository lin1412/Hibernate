package simoncomputing.app.myapp.model.entity.reference;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class BaseRefEntity implements Comparable<BaseRefEntity>, Serializable {

	private static final long serialVersionUID = 1L;

	@Transient
	private String code;

	@Transient
	public abstract String getCode();
	public abstract void setCode(String code);

	@Transient
	public String getDescription() {
		return "n/a";
	}

	public int compareTo(BaseRefEntity entity) {
		return this.getCode().compareTo(entity.getCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		BaseRefEntity entity = (BaseRefEntity) obj;

		return this.getCode().equals(entity.getCode()) && this.getDescription().equals(entity.getDescription());
	}

}
