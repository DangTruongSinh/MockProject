package com.bus.model;

import java.sql.Timestamp;

public class AbstractModel {
	private Timestamp dateCreate;
	private Timestamp dateUpdate;
	private String userCreate;
	private String userUpdate;
	
	public AbstractModel() {
	}
	public Timestamp getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}
	public Timestamp getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(Timestamp dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	public String getUserCreate() {
		return userCreate;
	}
	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}
	public String getUserUpdate() {
		return userUpdate;
	}
	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}
	
	
}
