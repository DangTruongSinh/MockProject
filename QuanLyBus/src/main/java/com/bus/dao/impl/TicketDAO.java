package com.bus.dao.impl;

import java.util.List;

import com.bus.dao.ITicketDAO;
import com.bus.mapper.SeatMapper;
import com.bus.mapper.TicketMapper;
import com.bus.model.SeatModel;
import com.bus.model.TicketModel;

public class TicketDAO extends AbstractDAO<TicketModel> implements ITicketDAO{
	public static void main(String[] args) {
		TicketDAO ac=new TicketDAO();
	for (TicketModel ds :ac.findbyIDUser(2)) {
		System.out.println(ds.getIdTicket()+" - "+ds.getIdBus() + " - " +ds.getIdSeat() + " - "+ ds.getIdUser());
	}
	
		TicketModel tm = new TicketModel();
		TicketDAO da = new TicketDAO();
//		tm.setIdBus(1);
//		tm.setIdSeat(3);
//		tm.setIdUser(18);
//		tm.setPrice("220000");
//		tm.setIdTicket(8);
//		tm.setStatus(true);
//		tm.setUserUpdate("nhdlklk");
//		da.updateTicketModel(tm);
//		tm.setIdTicket(9);
//		da.deleteTicketModel(tm);
	}
	@Override
	public List<TicketModel> findAll() {
		String sql = "select * from ticket";
		return query(sql, new TicketMapper());
	}
	@Override
	public List<TicketModel> findbyIDUser(int x) {
		String sql = "Select* from ticket WHERE IDUser=?";
		return query(sql,new TicketMapper(),x);
	}
	
	@Override
	public int insertTicketModel(TicketModel tickModel) {
		String sql = "INSERT INTO `ticket`(`IDBus`, `IDSeat`, `IDUser`, `Status`, `Price`, `UserCreate`, `UserUpdate`) VALUES (?,?,?,?,?,?,?)";
		
		return insert(sql,tickModel.getIdBus(),tickModel.getIdSeat(),tickModel.getIdUser(),tickModel.isStatus(),
				tickModel.getPrice(),tickModel.getUserCreate(),tickModel.getUserUpdate());
	}
	@Override
	public int updateTicketModel(TicketModel tickModel) {
		String sql = "UPDATE ticket SET IDBus= ?, IDSeat=?,IDUser=?,Status=?,Price=?,UserUpdate=? WHERE IDTicket=?";
		return update(sql,tickModel.getIdBus(),tickModel.getIdSeat(),tickModel.getIdUser(),tickModel.isStatus(),
				tickModel.getPrice(),tickModel.getUserUpdate(),tickModel.getIdTicket());
	}
	@Override
	public int deleteTicketModel(TicketModel tickModel) {
		String sql = "delete from ticket where IDTicket = ?";
		return delete(sql, tickModel.getIdTicket());
	}
}
