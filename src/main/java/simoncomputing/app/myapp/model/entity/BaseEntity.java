package simoncomputing.app.myapp.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@EntityListeners(AuditingEntityListener.class)
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@MappedSuperclass
public abstract class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@CreatedDate
	private Date entryDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENTRY_DTTM", nullable = false, updatable = false)
	public Date getEntryDateTime() {
		return entryDateTime;
	}

	public void setEntryDateTime(Date entryDateTime) {
		this.entryDateTime = entryDateTime;
	}

}
