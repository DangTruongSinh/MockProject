package com.bus.dao;

import java.util.List;

import com.bus.model.TicketModel;

public interface ITicketDAO extends IGenericDAO<TicketModel>{
	List<TicketModel> findAll();
	List<TicketModel>findlimit(int start,int limit);
	int insertTicketModel(TicketModel tickModel);
	int updateTicketModel(TicketModel tickModel);
	int deleteTicketModel(int id);
	List<TicketModel> findAllbyIDUser(int id);
	TicketModel findOneByIDTicket(int id);
	List<TicketModel> findAllbyIDBus(int id);
	TicketModel findOneByIDSeat(int id);
	int getTotalTicket();
	int getTotalBookedTicketByIdUserAndIdBusAndDate(int idUser,int idBus,String date);
	int updateStatusTicket(int id);
}
