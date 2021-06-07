package com.wipro.iaf.emms.emmsLite.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Repository.LoginRepository;
import com.wipro.iaf.emms.emmsLite.beans.LoginResponse;
import com.wipro.iaf.emms.emmsLite.beans.SetQuestion;
import com.wipro.iaf.emms.emmsLite.entity.LoginEntity;

/**
 * @author Rachit
 *
 */

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepo;

	@Autowired
	LoginResponse loginResponse;

	@Autowired
	SetQuestion setQuestion;

	public LoginResponse checkUser(String userid) {
		loginResponse.reset();

		String userIdFromDb = loginRepo.checkUserId(userid);

		if(userIdFromDb!=null && userIdFromDb.equals(userid)){

			loginResponse.setCode(200);
			loginResponse.setLoginStatus("User is present in the system");
			String passwordFromDb =loginRepo.checkPassword(userid);
			if(passwordFromDb!=null){
				loginResponse.setCode(202);
				loginResponse.setPasswordStatus("Password is present in the system");
			}
			else{
				loginResponse.setCode(500);
				loginResponse.setPasswordStatus("Password is not present in the system, go to generate password");
			}

		}
		else{
			loginResponse.setCode(404);
			loginResponse.setLoginStatus("User is not present in the system");
			loginResponse.setPasswordStatus(null);
		}
		return loginResponse;
	}

	public LoginResponse LoginCheck(LoginEntity login){

		loginResponse.reset();
		Optional<LoginEntity> loginEntityFromDb= loginRepo.findById(login.getUserid());

		if(loginEntityFromDb.get().getBlockCount()>=5){
			loginEntityFromDb.get().setPassword("BLOCKED");
			loginRepo.save(loginEntityFromDb.get());
			System.out.println("set password --- "+loginEntityFromDb.get().getPassword());
			loginResponse.setCode(500);
			loginResponse.setLoginStatus("Userid- "+login.getUserid()+" is blocked.");
		}
		else{
			String passwordFromDb =loginRepo.checkPassword(login.getUserid());
			System.out.println("password entered --- "+login.getPassword());
			System.out.println("password returned--- "+passwordFromDb);
			
			if(passwordFromDb.equals("IAF@12345")){
				loginResponse.setCode(203);
				loginResponse.setLoginStatus("Password reset done by Admin, please change password again.");
			}
			else if(passwordFromDb.equals(login.getPassword())){
				System.out.println("User authenticated");
				loginEntityFromDb.get().setBlockCount(0);
				loginRepo.save(loginEntityFromDb.get());
//				loginResponse.setUserRole(loginEntityFromDb.get().getUserRole());
				loginResponse.setCode(200);
				loginResponse.setLoginStatus("User authenticated");
			}
			else{
				System.out.println("User not authenticated");
				int count= loginEntityFromDb.get().getBlockCount();
				loginEntityFromDb.get().setBlockCount(++count);
				loginRepo.save(loginEntityFromDb.get());
				loginResponse.setCode(401);
				loginResponse.setLoginStatus("User not authenticated");
			}
		}
		return loginResponse;
	}

	public LoginResponse setQuestions(LoginEntity login) {
		loginResponse.reset();

		System.out.println("Input object data ----"+login.toString());
		if(login.getUpdatePassword().isEmpty()){
			loginResponse.setCode(500);
			loginResponse.setStatus("Password has not been updated");
		}
		else{
			LocalDateTime changedTime = LocalDateTime.now(); 
			Optional<LoginEntity> loginEntityFromDb= loginRepo.findById(login.getUserid());
			System.out.println("login Entity from db--"+loginEntityFromDb.get().toString());

			loginEntityFromDb.get().setChangePassTime(changedTime);
			loginEntityFromDb.get().setUserid(login.getUserid());
			loginEntityFromDb.get().setAnswerOne(login.getAnswerOne());
			loginEntityFromDb.get().setAnswerTwo(login.getAnswerTwo());
			loginEntityFromDb.get().setAnswerThree(login.getAnswerThree());
			loginEntityFromDb.get().setPassword(login.getUpdatePassword());
			System.out.println("Input to be set in db ----"+loginEntityFromDb.get().toString());
			loginRepo.save(loginEntityFromDb.get());
			loginResponse.setCode(202);
			loginResponse.setStatus("Password has been updated");
		}
		return loginResponse;
	}

	public LoginResponse resetByAdmin(String userid) {
		loginResponse.reset();

		Optional<LoginEntity> loginEntityFromDb= loginRepo.findById(userid);
		System.out.println("login Entity from db--"+loginEntityFromDb.get().toString());

		if(loginEntityFromDb.get().getPassword().equals("BLOCKED")&& loginEntityFromDb.get().getBlockCount()==5){
			LocalDateTime changedTime = LocalDateTime.now(); 

			loginEntityFromDb.get().setPassword("IAF@12345");
			loginEntityFromDb.get().setBlockCount(0);
			loginEntityFromDb.get().setAnswerOne(null);
			loginEntityFromDb.get().setAnswerTwo(null);
			loginEntityFromDb.get().setAnswerTwo(null);
			loginEntityFromDb.get().setChangePassTime(changedTime);
			loginRepo.save(loginEntityFromDb.get());
			loginResponse.setCode(200);
			loginResponse.setStatus("default password is set");
		}
		else if(loginEntityFromDb.get().getPassword().equals(null)){
			loginResponse.setCode(203);
			loginResponse.setStatus("Password not present in system for user, cannot reset password.");
		}
		else{
			loginResponse.setCode(500);
			loginResponse.setStatus("Failed to set default password");
		}
		return loginResponse;
	}

	public LoginResponse validateQuestion(LoginEntity login) {
		int questionCounter=0;
		loginResponse.reset();
		Optional<LoginEntity> loginEntityFromDb= loginRepo.findById(login.getUserid());
		System.out.println("loginEntity input --"+login.toString());
		System.out.println("LoginEntity from DB-- "+loginEntityFromDb.get());
		if(login.getAnswerOne().equalsIgnoreCase(loginEntityFromDb.get().getAnswerOne())){
			questionCounter++;
		}
		if(login.getAnswerTwo().equalsIgnoreCase(loginEntityFromDb.get().getAnswerTwo())){
			questionCounter++;
		}
		if(login.getAnswerThree().equalsIgnoreCase(loginEntityFromDb.get().getAnswerThree())){
			questionCounter++;
		}
		System.out.println("Question counter --"+questionCounter);
		if(questionCounter>=2){
			loginResponse.setCode(200);
			loginResponse.setStatus("Questions validated successfully");
		}
		else{
			loginResponse.setCode(500);
			loginResponse.setStatus("Questions not validated");
		}
		return loginResponse;
	}

	public LoginResponse forgetPassword(LoginEntity login) {
		loginResponse.reset();

		Optional<LoginEntity> loginEntityFromDb= loginRepo.findById(login.getUserid());
		System.out.println("login Entity from db--"+loginEntityFromDb.get().toString());

		if(!login.getUpdatePassword().isEmpty()){
			LocalDateTime changedTime = LocalDateTime.now(); 

			loginEntityFromDb.get().setPassword(login.getUpdatePassword());
			loginEntityFromDb.get().setChangePassTime(changedTime);
			loginRepo.save(loginEntityFromDb.get());
			System.out.println("Update loginEntity --"+loginEntityFromDb.get());
			loginResponse.setCode(200);
			loginResponse.setPasswordStatus("Password updated successfully");
		}
		else{
			loginResponse.setCode(500);
			loginResponse.setPasswordStatus("Password not updated");
		}
		return loginResponse;
	}

	public LoginResponse changePassword(LoginEntity login) {
		loginResponse.reset();
		System.out.println("*****Reached here Userid="+login.getUserid());
		Optional<LoginEntity> loginEntityFromDb= loginRepo.findById(login.getUserid());		
		if (loginEntityFromDb != null ) {
			System.out.println("*****Reached here pwd from bean"+login.getUpdatePassword());
			System.out.println("*****Reached here pwd from db"+loginEntityFromDb.get().getPassword() );
			if (loginEntityFromDb.get().getPassword() != null
					&& login.getUpdatePassword() != null
					&& loginEntityFromDb.get().getPassword().equals(
							login.getPassword())) {
				System.out.println("*****Reached here--Passwords are matching ");
				loginEntityFromDb.get().setPassword(login.getUpdatePassword());
				loginRepo.save(loginEntityFromDb.get());
				loginResponse.setCode(202);
				loginResponse.setStatus("Password has been updated");
				loginResponse.setPasswordStatus("UPDATED");
			}else{
				loginResponse.setCode(203);
				loginResponse.setStatus("Password cannot be updated");
				loginResponse.setPasswordStatus("NOT UPDATED");
			}
		}
		return loginResponse;		
	}
}
