package com.bus.dao.impl;

import java.util.List;

import com.bus.dao.ITicketDAO;
import com.bus.mapper.TicketMapper;
import com.bus.model.TicketModel;

public class TicketDAO extends AbstractDAO<TicketModel> implements ITicketDAO{
	
	@Override
	public List<TicketModel> findAll() {
		String sql = "select * from ticket";
		List<TicketModel> list = query(sql, new TicketMapper());
		return list.size() == 0 ? null : list;
	}
	@Override
	public List<TicketModel> findlimit(int start,int limit){
		String sql = "select * from ticket limit ?,?";
		List<TicketModel>list=query(sql, new TicketMapper(),start,limit);
		return list.size() == 0 ? null : list;
	}
	@Override
	public List<TicketModel> findAllbyIDUser(int x) {
		String sql = "Select * from ticket WHERE IDUser=?";
		List<TicketModel> list = query(sql,new TicketMapper(),x);
		return list.size() == 0 ? null : list;
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
	public int deleteTicketModel(int id) {
		String sql = "delete from ticket where IDTicket = ?";
		return delete(sql, id);
	}
	@Override
	public TicketModel findOneByIDTicket(int id) {
		String sql = "select * from ticket where IDTicket = ?";
		List<TicketModel> list = query(sql, new TicketMapper(), id);
		return list.size() == 0 ? null : list.get(0);
	}
	@Override
	public List<TicketModel> findAllbyIDBus(int id) {
		String sql = "select * from ticket where IDBus = ?";
		List<TicketModel> list = query(sql, new TicketMapper(), id);
		return list.size() == 0 ? null : list;
	}
	@Override
	public TicketModel findOneByIDSeat(int id) {
		String sql = "select * from ticket where IDSeat = ?";
		List<TicketModel> list = query(sql, new TicketMapper(), id);
		return list.size() == 0 ? null : list.get(0);
	}
	@Override 
	public int getTotalTicket() {
		String sql = "select count(*) from ticket";
		return getTotalItem(sql);
	}
}
