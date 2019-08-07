package com.bus.dao;

import java.util.List;

import com.bus.model.TicketModel;

public interface ITicketDAO extends IGenericDAO<TicketModel>{
	List<TicketModel> findAll();
	int insertTicketModel(TicketModel tickModel);
	int updateTicketModel(TicketModel tickModel);
	int deleteTicketModel(TicketModel tickModel);
	List<TicketModel> findbyIDUser(int x);
}
