package raksh.login.form.service;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raksh.login.form.dao.LoginDAO;
import raksh.login.form.dto.LoginDTO;
import raksh.login.form.entity.LoginEntity;
@Service
public class LoginServiceDAOImpl implements LoginServiceDAO{
	@Autowired
	private LoginDAO dao;

	public LoginServiceDAOImpl() {
		System.out.println("invoked"+this.getClass().getSimpleName());
	}

	public boolean validateAndSave(LoginDTO dto) {
		boolean valid = false;
		try {
			System.out.println("save invoked " +dto);

			if(Objects.nonNull(dto)) {
				System.out.println("starting validation for " +dto);
				String Username = dto.getUname();
				if (Username !=null && !Username.isEmpty() && Username.length() >=5) {
				System.out.println("Username is valid");
				valid = true;
				} else {
					System.out.println("Username is invalid");
					if(Username == null) {
						System.out.println("Username is null");
					}
					if(Username !=null && Username.length() <5) {
						System.out.println("name length is less than 5");
					}
					valid = false;
				}
		
				String Email = dto.getEmail();
				if (Email !=null && !Email.isEmpty() && Email.length() >=5) {
					System.out.println("Email is valid");
					valid = true;	
			} else {
				if(valid) {
					System.out.println("Email is invalid");
					valid = false;
					
				}
			}
			
				String Password = dto.getPswd();
				if (Password !=null && !Password.isEmpty() && Password.length() >=5) {
					System.out.println("Password is valid");
					valid = true;	
			} else {
				if(valid) {
					System.out.println("Password is invalid");
					valid = false;
					
				}
			}
			
				String ConformPassword = dto.getConfirmpswd();
				if (ConformPassword !=null && !ConformPassword.isEmpty() && ConformPassword.length() >=5) {
					System.out.println("ConformPassword is valid");
					valid = true;	
			} else {
				if(valid) {
					System.out.println("ConformPassword is invalid");
					valid = false;
				}		
		}
			}
			//return valid;
			
			if(valid) {
				System.out.println("Data is valid ,will convert  to entity");
				
				LoginEntity entity = new LoginEntity();
				
				BeanUtils.copyProperties(dto, entity);
				
				System.out.println("entity is ready \t "+ entity);
				dao.save(entity);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
		
	}