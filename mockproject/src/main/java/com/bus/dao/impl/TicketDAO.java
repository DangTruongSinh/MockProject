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
	public List<TicketModel> findlimitForFilter(int start,int limit,int idBus,int status, String date,int idUser){
		String sql = "select * from ticket where IDBus = ? and DepartDate = ? ";
		List<TicketModel>list;
		if(status == -1 && idUser == -1)	
		{
			System.out.println("-1 -1");
			sql = sql + "limit ?,?";
			list =query(sql, new TicketMapper(),idBus, date,start,limit);
		}
		else if(status == -1)
		{
			System.out.println("2");
			sql = sql + "and IDUser = ? limit ?,?";
			list =query(sql, new TicketMapper(),idBus, date , idUser ,start,limit);
		}
		else if(idUser == -1)
		{
			System.out.println("3");
			sql = sql + "and Status = ? limit ?,?";
			list =query(sql, new TicketMapper(),idBus, date , status ,start,limit);
		}
		else
		{
			System.out.println("4");
			sql = sql + "and Status = ? and IDUser = ? limit ?,?";
			
			list =query(sql, new TicketMapper(),idBus, date , status , idUser , start,limit);
		}
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
		String sql = "INSERT INTO ticket(IDBus, IDSeat, IDUser, Status, Price, UserCreate, UserUpdate,DateCreate,DepartDate) VALUES (?,?,?,?,?,?,?,?,?)";
		
		return insert(sql,tickModel.getIdBus(),tickModel.getIdSeat(),tickModel.getIdUser(),tickModel.isStatus(),
				tickModel.getPrice(),tickModel.getUserCreate(),tickModel.getUserUpdate(),tickModel.getDateCreate(),tickModel.getDepartDate());
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
	@Override
	public int getTotalBookedTicketByIdUserAndIdBusAndDate(int idUser,int idBus,String date) {
		String sql = "select count(*) from ticket where IDUser = ? and IDBus = ? and DepartDate = ?"; 
		return getTotalItem(sql, idUser,idBus,date);
	}
	@Override
	public int updateStatusTicket(int id) {
		String sql = "update ticket set Status = true where IDTicket = ?";
		return update(sql, id);
	}
	@Override
	public int deleteTicketModelByIdSeat(int idSeat) {
		String sql = "delete from ticket where IDSeat = ?";
		return delete(sql, idSeat);
	}
	@Override
	public List<TicketModel> findlimit(int start, int limit) {
		String sql = "select * from ticket limit ?,?";
		return query(sql, new TicketMapper(), start, limit);
	}
}
