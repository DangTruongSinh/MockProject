package com.bus.service;

import java.util.List;

import com.bus.model.PageModel;
import com.bus.model.TicketModel;

public interface ITicketService {
	List<TicketModel> findAll();
	List<TicketModel> findlimit(PageModel page);
	TicketModel insertTicketModel(TicketModel tickModel);
	TicketModel updateTicketModel(TicketModel tickModel);
	boolean deleteTicketModel(int idTicket);
	boolean deleteTicketModelByIdSeat(int idSeat);
	List<TicketModel> findAllbyIDUser(int id);
	TicketModel findOneByIDTicket(int id);
	List<TicketModel> findAllbyIDBus(int id);
	TicketModel findOneByIDSeat(int id);
	int getTotalTicket();
	int getTotalBookedTicketByIdUserAndIdBusAndDate(int idUser,int idBus,String date);
	boolean updateStatusTicket(int id);
}
