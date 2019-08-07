package com.bus.model;

import java.sql.Timestamp;

public class BusModel extends AbstractModel{
	private Integer idBus;
	private String licensePlate;
	private Timestamp timeStart;
	private Timestamp timeEnd;
	private String placeStart;
	private String placeEnd;
	
	public BusModel()
	{
		
	}
	public Integer getIdBus() {
		return idBus;
	}
	public void setIdBus(int idBus) {
		this.idBus = idBus;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public Timestamp getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Timestamp timeStart) {
		this.timeStart = timeStart;
	}
	public Timestamp getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Timestamp timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getPlaceStart() {
		return placeStart;
	}
	public void setPlaceStart(String placeStart) {
		this.placeStart = placeStart;
	}
	public String getPlaceEnd() {
		return placeEnd;
	}
	public void setPlaceEnd(String placeEnd) {
		this.placeEnd = placeEnd;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return 	idBus+"-"+licensePlate+"-"+timeStart+"-"+timeEnd+"-"+placeStart+"-"+placeEnd
				+"-"+getDateCreate() + "-"+getDateUpdate()+"-"+getUserCreate()+"-"+getUserUpdate();
	}
}
