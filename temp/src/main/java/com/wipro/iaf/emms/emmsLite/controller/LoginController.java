package com.wipro.iaf.emms.emmsLite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.iaf.emms.emmsLite.beans.LoginResponse;
import com.wipro.iaf.emms.emmsLite.entity.LoginEntity;
import com.wipro.iaf.emms.emmsLite.services.LoginService;

/**
 * @author Rachit
 *
 */

@RestController
@RequestMapping("/emmsLite")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private LoginResponse loginResponse;
	
	@PostMapping("/Login")
	public ResponseEntity<LoginResponse> loginMethod(@RequestBody LoginEntity login){
		return new ResponseEntity<>(loginService.LoginCheck(login),HttpStatus.OK);
	}
		
	@GetMapping("/checkUserId/{userid}")
	public ResponseEntity<LoginResponse> checkUserId(@PathVariable String userid ){
		return new ResponseEntity<>(loginService.checkUser(userid),HttpStatus.OK);		
	}
	
	@PostMapping("/generatePassword")
	public ResponseEntity<LoginResponse> setQuestions(@RequestBody LoginEntity login){
		return new ResponseEntity<>(loginService.setQuestions(login),HttpStatus.OK);
	}
	
	@PostMapping("/forgetPassword")
	public ResponseEntity<LoginResponse> forgetPassword(@RequestBody LoginEntity login){
		return new ResponseEntity<>(loginService.forgetPassword(login),HttpStatus.OK);
	}
	
	@PostMapping("/validateQuestion")
	public ResponseEntity<LoginResponse> validateQuestion(@RequestBody LoginEntity login){
		return new ResponseEntity<>(loginService.validateQuestion(login),HttpStatus.OK);
	}
	
	@GetMapping("/resetByAdmin/{userid}")
	public ResponseEntity<LoginResponse> resetByAdmin(@PathVariable String userid ){
		return new ResponseEntity<>(loginService.resetByAdmin(userid),HttpStatus.OK);
		}		
	@PutMapping("/changePassword")
	public ResponseEntity<LoginResponse> changePassword(@RequestBody LoginEntity login){
		return new ResponseEntity<>(loginService.changePassword(login),HttpStatus.OK);
	}
}

