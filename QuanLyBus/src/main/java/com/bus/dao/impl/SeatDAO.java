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
	
}
