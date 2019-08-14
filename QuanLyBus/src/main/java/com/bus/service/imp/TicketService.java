package com.bus.service.imp;

import java.util.List;

import com.bus.dao.impl.AccountDAO;
import com.bus.dao.impl.BusDAO;
import com.bus.dao.impl.SeatDAO;
import com.bus.dao.impl.TicketDAO;
import com.bus.model.AccountModel;
import com.bus.model.BusModel;
import com.bus.model.PageModel;
import com.bus.model.SeatModel;
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
	 public List<TicketModel> findlimit(PageModel page){
		int start = (page.getCurentPage()-1)*page.getMaxPageItem();
		int limit = page.getMaxPageItem();
		List<TicketModel>list=ticketDao.findlimit(start, limit);
		return setBusForListTicket(list);
	}
	@Override
	public TicketModel insertTicketModel(TicketModel tickModel) {
		SeatDAO seatDao = new SeatDAO();
		int id = tickModel.getIdSeat();
		SeatModel seat = seatDao.findOneByIdSeat(id);
		if(!seat.isStatus())
		{
			seatDao.setStatusSeat(id, true);
			int idTicket = ticketDao.insertTicketModel(tickModel);
			if(idTicket != -1)
				return ticketDao.findOneByIDTicket(idTicket);
			else
				seatDao.setStatusSeat(id, false);
			
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
	public boolean deleteTicketModel(int id) {
		TicketModel ticket = ticketDao.findOneByIDTicket(id);
		if(ticketDao.deleteTicketModel(id) == 1)
		{
			if(new SeatDAO().setStatusSeat(ticket.getIdSeat(), false) == 1)
				return true;
		}
		return false;
	}

	@Override
	public List<TicketModel> findAllbyIDUser(int id) {
		return setBusForListTicket(ticketDao.findAllbyIDUser(id));
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
	//De lam gi vay 
//	private TicketModel setBusForATicket(TicketModel ticketModel)
//	{
//		if(ticketModel != null)
//		{
//			BusDAO busDao = new BusDAO();
//			BusModel busModel = busDao.findOneByIdBus(ticketModel.getIdBus());
//			ticketModel.setBus(busModel);
//			return ticketModel;
//		}
//		return null;
//	}
	private List<TicketModel> setBusForListTicket(List<TicketModel> list)
	{
		BusDAO busDao = new BusDAO();
		SeatDAO seatDao = new SeatDAO();
		AccountDAO accDAO=new AccountDAO();
		if(list != null)
		{
			for(TicketModel x : list)
			{
				BusModel busModel = busDao.findOneByIdBus(x.getIdBus());
				SeatModel seatModel = seatDao.findOneByIdSeat(x.getIdSeat());
				AccountModel accModel=accDAO.findOneByIDModel(x.getIdUser());
				x.setSeat(seatModel);
				x.setBus(busModel);
				x.setAccModel(accModel);
			}
		}
		return list;
	}
	@Override
	public int getTotalTicket()
	{
		return ticketDao.getTotalTicket();
	}
	@Override
	public int getTotalBookedTicketByIdUser(int id) {
		return ticketDao.getTotalBookedTicketByIdUser(id);
	}
}
