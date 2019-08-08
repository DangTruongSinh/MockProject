package com.bus.service;

import java.util.List;

import com.bus.model.TicketModel;

public interface ITicketService {
	List<TicketModel> findAll();
	TicketModel insertTicketModel(TicketModel tickModel);
	TicketModel updateTicketModel(TicketModel tickModel);
	boolean deleteTicketModel(TicketModel tickModel);
	List<TicketModel> findAllbyIDUser(int id);
	TicketModel findOneByIDTicket(int id);
	List<TicketModel> findAllbyIDBus(int id);
	TicketModel findOneByIDSeat(int id);
}
