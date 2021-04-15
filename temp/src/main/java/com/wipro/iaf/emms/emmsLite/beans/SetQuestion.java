package com.wipro.iaf.emms.emmsLite.beans;

import org.springframework.stereotype.Component;

@Component
public class SetQuestion {
	
	private String userid;
	private String password;
	private String answer_one;
	private String answer_two;
	private String answer_three;
	private String updatePassword;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAnswer_one() {
		return answer_one;
	}
	public void setAnswer_one(String answer_one) {
		this.answer_one = answer_one;
	}
	public String getAnswer_two() {
		return answer_two;
	}
	public void setAnswer_two(String answer_two) {
		this.answer_two = answer_two;
	}
	public String getAnswer_three() {
		return answer_three;
	}
	public void setAnswer_three(String answer_three) {
		this.answer_three = answer_three;
	}
	public String getUpdatePassword() {
		return updatePassword;
	}
	public void setUpdatePassword(String updatePassword) {
		this.updatePassword = updatePassword;
	}
	

}
