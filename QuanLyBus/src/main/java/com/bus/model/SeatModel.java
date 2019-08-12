package com.bus.model;

public class SeatModel extends AbstractModel {
	private Integer idSeat;
	private Integer idBus;
	private int name;
	private boolean status;
	
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
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
