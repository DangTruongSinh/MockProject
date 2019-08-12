package com.bus.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class AccountModel extends AbstractModel{
	private Integer idUser;
	private Integer idRole;
	private String userName;
	private String password;
	private String fullName;
	private String phone;
	private Timestamp dateBirth;
	private Timestamp lastTimeLogin;
	private RoleModel role = new RoleModel();
	public AccountModel()
	{
		
	}
	
	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Integer getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	public Timestamp getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Timestamp dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Timestamp getLastTimeLogin() {
		return lastTimeLogin;
	}
	public void setLastTimeLogin(Timestamp lastTimeLogin) {
		this.lastTimeLogin = lastTimeLogin;
	}
	public String getStringDateBirth()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(dateBirth);
	}
	@Override
	public String toString() {
		return idUser +"-"+idRole+"-"+userName+"-"+password+"-"+fullName+"-"+phone+"-"+dateBirth+"-"
				+lastTimeLogin+"-"+getRole().getName();
	}
}
