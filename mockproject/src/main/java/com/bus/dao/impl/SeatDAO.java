package com.bus.dao.impl;

import java.util.List;

import com.bus.dao.ISeatDAO;

import com.bus.mapper.SeatMapper;

import com.bus.model.SeatModel;

public class SeatDAO extends AbstractDAO<SeatModel> implements ISeatDAO {
	@Override
	public int updateSeatModel(SeatModel seatModel) {
		String sql = "UPDATE role SET Name = ? , Status = ? , UserUpdate= ? WHERE IDSeat=?";
		return update(sql,seatModel.getName(),seatModel.isStatus(),seatModel.getUserUpdate(),seatModel.getIdSeat());
	}
	@Override
	public List<SeatModel> findAllbyIDBus(int x) {
		String sql = "Select * from seat WHERE IDBus=?";
		List<SeatModel> list = query(sql,new SeatMapper(),x);
		return list.size() == 0 ? null : list;
	}
	@Override
	public SeatModel findOneByIdSeat(int id) {
		String sql = "Select * from seat WHERE IDSeat=?";
		List<SeatModel> list = query(sql, new SeatMapper(), id);
		return list.size() == 0 ? null : list.get(0);
	}
	@Override
	public int insertSeatModel(SeatModel seatModel) {
		String sql = "insert into seat(IDBus,Name,Status,UserCreate,UserUpdate) "
				+ "values(?,?,?,?,?)";
		return insert(sql, seatModel.getIdBus(),seatModel.getName(),seatModel.isStatus(),
				seatModel.getUserCreate(),seatModel.getDateUpdate());
	}
	@Override
	public int deleteSeatModel(int id) {
		String sql = "delete from seat where IDSeat = ?";
		return delete(sql, id);
	}
	@Override
	public int setStatusSeat(int id, boolean value) {
		String sql = "UPDATE seat SET Status = ? WHERE IDSeat=?";
		return update(sql, value,id);
	}
	@Override
	public List<SeatModel> findAllbyIDBusAndDate(int id, String date) {
		String sql = "select * from seat where IDBus = ? and DateStart = ?";
		return query(sql, new SeatMapper(), id, date);
	}
	@Override
	public List<SeatModel> findAllbyIDBusAndIDPlaceAndDate(int idBus, int idPlace, String date) {
		String sql = "select * from seat where IDBus = ? and IDPlace = ? and DateStart = ?";
		return query(sql, new SeatMapper(), idBus,idPlace,date);
	}
	@Override
	public List<SeatModel> findAllByIDPlace(int idPlace) {
		String sql = "select * from seat where IDPlace = ?";
		
		return query(sql, new SeatMapper(), idPlace);
	}
	@Override
	public List<SeatModel> findlimit(int start, int limit) {
		String sql = "select * from seat limit ?,?";
		List<SeatModel> list= query(sql,new SeatMapper(),start,limit);
		return list.size() == 0 ? null : list;
	}
	@Override
	public int getTotalSeat() {
		String sql = "select count(*) from seat";
		return getTotalItem(sql);
	}
	
}
