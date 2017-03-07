package dataProcess.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userid")
public class UserID implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="USER_ID")
	private String userId;
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	

}
