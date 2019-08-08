package com.bus.dao.impl;

import java.util.List;

import com.bus.dao.ITicketDAO;
import com.bus.mapper.TicketMapper;
import com.bus.model.TicketModel;

public class TicketDAO extends AbstractDAO<TicketModel> implements ITicketDAO{
	
	@Override
	public List<TicketModel> findAll() {
		String sql = "select * from ticket";
		return query(sql, new TicketMapper());
	}
	@Override
	public List<TicketModel> findAllbyIDUser(int x) {
		String sql = "Select * from ticket WHERE IDUser=?";
		return query(sql,new TicketMapper(),x);
	}
	
	@Override
	public int insertTicketModel(TicketModel tickModel) {
		String sql = "INSERT INTO ticket(IDBus, IDSeat, IDUser, Status, Price, UserCreate, UserUpdate) VALUES (?,?,?,?,?,?,?)";
		
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
	@Override
	public TicketModel findOneByIDTicket(int id) {
		String sql = "select * from ticket where IDTicket = ?";
		return query(sql, new TicketMapper(), id).get(0);
	}
	@Override
	public List<TicketModel> findAllbyIDBus(int id) {
		String sql = "select * from ticket where IDBus = ?";
		return query(sql, new TicketMapper(), id);
	}
	@Override
	public TicketModel findOneByIDSeat(int id) {
		String sql = "select * from ticket where IDSeat = ?";
		return query(sql, new TicketMapper(), id).get(0);
	}
}
