package com.wipro.iaf.emms.emmsLite.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="login")
public class LoginEntity {

	@Id
	private String userid;
	@Column
	private String password;
	@Column(name="answer_one",nullable=true)
	String answerOne;
	@Column(name="answer_two",nullable=true)
	String answerTwo;
	@Column(name="answer_three",nullable=true)
	String answerThree;
	@Column(name="block_count")
	int blockCount;
	@Column
	private LocalDateTime changePassTime;
	@Transient
	String updatePassword; 
		
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
	
	public String getAnswerOne() {
		return answerOne;
	}
	public void setAnswerOne(String answerOne) {
		this.answerOne = answerOne;
	}
	public String getAnswerTwo() {
		return answerTwo;
	}
	public void setAnswerTwo(String answerTwo) {
		this.answerTwo = answerTwo;
	}
	public String getAnswerThree() {
		return answerThree;
	}
	public void setAnswerThree(String answerThree) {
		this.answerThree = answerThree;
	}
		public String getUpdatePassword() {
		return updatePassword;
	}
	public void setUpdatePassword(String updatePassword) {
		this.updatePassword = updatePassword;
	}
	public int getBlockCount() {
		return blockCount;
	}
	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}
	
	public LocalDateTime getChangePassTime() {
		return changePassTime;
	}
	public void setChangePassTime(LocalDateTime changePassTime) {
		this.changePassTime = changePassTime;
	}
	@Override
	public String toString() {
		return "LoginEntity [userid=" + userid + ", password=" + password
				+ ", answerOne=" + answerOne + ", answerTwo=" + answerTwo
				+ ", answerThree=" + answerThree + ", blockCount=" + blockCount
				+ ", changePassTime=" + changePassTime + ", updatePassword="
				+ updatePassword + "]";
	}
	public LoginEntity() {
	}
	
	
}
