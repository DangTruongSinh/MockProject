package com.bus.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusModel extends AbstractModel{
	private Integer idBus;
	private String licensePlate;
	private Timestamp timeStart;
	private Timestamp timeEnd;
	private String placeStart;
	private String placeEnd;
	private List<SeatModel> listSeat;
	public BusModel()
	{
		
	}
	
	public List<SeatModel> getListSeat() {
		return listSeat;
	}

	public void setListSeat(List<SeatModel> listSeat) {
		this.listSeat = listSeat;
	}

	public String getDateKhoiHanh() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(timeStart !=null)
		{
			Date date = new  Date(timeStart.getTime());
			String result = format.format(date);
			return result;
		}
		return "";
	}


	public String getGioBatDau() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		if(timeStart !=null)
		{
			Date date = new  Date(timeStart.getTime());
			String result = format.format(date);
			return result;
		}
		return "";
		
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
	public int getNumberEmptySeat()
	{
		int result = 0;
		if(listSeat != null)
		{
			for(SeatModel x : listSeat)
			{
				if(!x.isStatus())
				{
					result++;
				}
			}
		}
		
		return result;
	}
	public List<Integer> getListIdSeat()
	{
		List<Integer> list = null;
		if(listSeat != null)
		{
			list = new ArrayList<Integer>();
			for(SeatModel x : listSeat)
				list.add(x.getIdSeat());
		}
		return list;
	}
	public List<Integer> getListBookedSeat()
	{
		List<Integer> list = null;
		if(listSeat != null)
		{
			list = new ArrayList<Integer>();
			for(SeatModel x : listSeat)
			{
				if(x.isStatus())
					list.add(x.getName());
			}
		}
		return list;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return 	getGioBatDau()+"-"+timeStart +":";
	}
}
