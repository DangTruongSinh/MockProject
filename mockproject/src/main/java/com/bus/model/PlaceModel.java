package com.bus.model;

import java.sql.Time;

public class PlaceModel  extends AbstractModel{
	private Integer idPlace;
	private String startPlace;
	private String stopPlace;
	private Time TimeStart;
	private Time TimeEnd;
	private String price;
	public Integer getIdPlace() {
		return idPlace;
	}
	public void setIdPlace(Integer idPlace) {
		this.idPlace = idPlace;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	public String getStopPlace() {
		return stopPlace;
	}
	public void setStopPlace(String stopPlace) {
		this.stopPlace = stopPlace;
	}
	public String getTimeStart() {
		return TimeStart.toString();
	}
	public void setTimeStart(Time timeStart) {
		TimeStart = timeStart;
	}
	public String getTimeEnd() {
		return TimeEnd.toString();
	}
	public void setTimeEnd(Time timeEnd) {
		TimeEnd = timeEnd;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}	
