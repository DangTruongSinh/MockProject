package com.bus.model;

import java.util.ArrayList;
import java.util.List;

public class BusModel extends AbstractModel{
	private Integer idBus;
	private String licensePlate;
	private Integer idUser;
	private PlaceModel place;
	
	private List<SeatModel> listSeats = new ArrayList<SeatModel>();
	public BusModel()
	{
		
	}
	
	
	public List<SeatModel> getListSeats() {
		return listSeats;
	}


	public void setListSeats(List<SeatModel> listSeats) {
		this.listSeats = listSeats;
	}


	public PlaceModel getPlace() {
		return place;
	}


	public void setPlace(PlaceModel place) {
		this.place = place;
	}


	public Integer getIdUser() {
		return idUser;
	}


	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}


	public Integer getIdBus() {
		return idBus;
	}
	public void setIdBus(Integer idBus) {
		this.idBus = idBus;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public int getNumberEmptySeat()
	{
		int result = 0;
		for(SeatModel x : listSeats)
		{
			if(!x.isStatus())
				result++;
		}
		return result;
	}
	public List<Integer> getListIdSeat()
	{
		List<Integer> list = null;
		if(listSeats != null)
		{
			list = new ArrayList<Integer>();
			for(SeatModel x : listSeats)
				list.add(x.getIdSeat());
		}
		return list;
	}
	public List<String> getListBookedSeat()
	{
		List<String> list = null;
		if(listSeats != null)
		{
			list = new ArrayList<String>();
			for(SeatModel x : listSeats)
			{
				if(x.isStatus())
					list.add(x.getName());
			}
		}
		return list;
	}



	
}
