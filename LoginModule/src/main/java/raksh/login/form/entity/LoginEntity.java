package raksh.login.form.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Entity
@Table(name = "login_details")

@Data
	
	public class LoginEntity implements Serializable {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private int id;
	@Column(name = "uname")
		private String uname;
		@Column(name = "email")
		private String email;
		@Column(name = "mobile")
		private String mobile;
		@Column(name = "pswd")
		private String pswd;
		@Column(name = "confirmpswd")
		private String confirmpswd;

	public LoginEntity() {
		System.out.println("created"+this.getClass().getName());
	}

	public LoginEntity(int id, String uname, String email, String mobile, String pswd, String confirmpswd) {
		super();
		this.id = id;
		this.uname = uname;
		this.email = email;
		this.mobile = mobile;
		this.pswd = pswd;
		this.confirmpswd = confirmpswd;
	}
}
