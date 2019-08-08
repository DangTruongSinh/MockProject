package com.bus.service.imp;

import java.util.List;

import com.bus.dao.impl.TicketDAO;
import com.bus.model.TicketModel;
import com.bus.service.ITicketService;

public class TicketService implements ITicketService{
	TicketDAO ticketDao;
	public TicketService()
	{
		ticketDao = new TicketDAO();
	}
	@Override
	public List<TicketModel> findAll() {
		return ticketDao.findAll();
	}

	@Override
	public TicketModel insertTicketModel(TicketModel tickModel) {
		tickModel.setUserCreate("userHienTai");
		tickModel.setUserUpdate("userHienTai");
		int id = ticketDao.insertTicketModel(tickModel);
		if(id != -1)
		{
			return ticketDao.findOneByIDTicket(id);
		}
		return null;
	}

	@Override
	public TicketModel updateTicketModel(TicketModel tickModel) {
		tickModel.setUserUpdate("userHienTai");
		int result = ticketDao.updateTicketModel(tickModel);
		if(result != -1)
			return ticketDao.findOneByIDSeat(tickModel.getIdTicket());
		return null;
	}

	@Override
	public boolean deleteTicketModel(TicketModel tickModel) {
		return ticketDao.deleteTicketModel(tickModel) == 1 ? true : false;
	}

	@Override
	public List<TicketModel> findAllbyIDUser(int id) {
		return ticketDao.findAllbyIDUser(id);
	}

	@Override
	public TicketModel findOneByIDTicket(int id) {
		return ticketDao.findOneByIDTicket(id);
	}

	@Override
	public List<TicketModel> findAllbyIDBus(int id) {
		return ticketDao.findAllbyIDBus(id);
	}

	@Override
	public TicketModel findOneByIDSeat(int id) {
		return ticketDao.findOneByIDSeat(id);
	}


}
