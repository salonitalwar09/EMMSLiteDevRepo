package com.wipro.iaf.emms.emmsLite.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="login")
public class LoginEntity implements Serializable{

	/**
	 *Entity for Login module 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String userid;
	@Column(name="password")
	private String password;
	@Column(name="answer_one",nullable=true)
	private String answerOne;
	@Column(name="answer_two",nullable=true)
	private String answerTwo;
	@Column(name="answer_three",nullable=true)
	private String answerThree;
	@Column(name="block_count")
	private int blockCount;
	@Column(name="change_pass_time")
	private LocalDateTime changePassTime;
	/*
	 * @Column(name="user_role") private String userRole;
	 */
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

	/*
	 * public String getUserRole() { return userRole; } public void
	 * setUserRole(String userRole) { this.userRole = userRole; }
	 */
	@Override
	public String toString() {
		return "LoginEntity [userid=" + userid + ", password=" + password + ", answerOne=" + answerOne + ", answerTwo="
				+ answerTwo + ", answerThree=" + answerThree + ", blockCount=" + blockCount + ", changePassTime="
				+ changePassTime + ", updatePassword=" + updatePassword + "]";
	}
	public LoginEntity() {
	}	
}
