package com.bus.model;

public class TicketModel extends AbstractModel{
	private Integer idTicket;
	private Integer idBus;
	private Integer idSeat;
	private Integer idUser;
	private boolean status;
	private String price;
	private BusModel bus;
	private SeatModel seat;
	public TicketModel()
	{
		
	}
	
	public SeatModel getSeat() {
		return seat;
	}

	public void setSeat(SeatModel seat) {
		this.seat = seat;
	}

	public BusModel getBus() {
		return bus;
	}

	public void setBus(BusModel bus) {
		this.bus = bus;
	}

	public Integer getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}
	public Integer getIdBus() {
		return idBus;
	}
	public void setIdBus(int idBus) {
		this.idBus = idBus;
	}
	public Integer getIdSeat() {
		return idSeat;
	}
	public void setIdSeat(int idSeat) {
		this.idSeat = idSeat;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
