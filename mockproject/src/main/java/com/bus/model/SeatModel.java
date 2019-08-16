package com.bus.model;

import java.sql.Date;

public class SeatModel extends AbstractModel {
	private Integer idSeat;
	private Integer idBus;
	private String name;
	private boolean status;
	private Date dateStart;
	private int idPlace;
	public SeatModel()
	{
		
	}
	
	public Integer getIdSeat() {
		return idSeat;
	}

	public void setIdSeat(int idSeat) {
		this.idSeat = idSeat;
	}

	public Integer getIdBus() {
		return idBus;
	}
	public void setIdBus(int idBus) {
		this.idBus = idBus;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public int getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(int idPlace) {
		this.idPlace = idPlace;
	}
	
}
