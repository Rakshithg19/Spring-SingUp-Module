package raksh.login.form.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginDTO implements Serializable {
	private String uname;
	private String email;
	private String mobile;
	private String pswd;
	private String confirmpswd;

}
