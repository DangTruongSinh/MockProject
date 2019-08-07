package com.bus.dao.impl;

import java.util.List;

import com.bus.dao.ISeatDAO;

import com.bus.mapper.SeatMapper;

import com.bus.model.SeatModel;

public class SeatDAO extends AbstractDAO<SeatModel> implements ISeatDAO {
	public static void main(String[] args) {
		SeatDAO ac=new SeatDAO();

		for (SeatModel ds :ac.findbyIDBus(2)) {
		
			{
			System.out.println(ds.getIdSeat()+" - "+ds.getIdBus() + " - " +ds.getName() + " - "+ ds.getUserCreate());
			}
		}
		
		
	}
	@Override
	public List<SeatModel> findAll()
	{
		String sql = "select * from seat";
		return query(sql, new SeatMapper());
	}
	
	@Override
	public int updateSeatModel(SeatModel seatModel) {
		String sql = "UPDATE role SET Name = ? , Status = ? , UserUpdate= ? WHERE IDSeat=?";
		return update(sql,seatModel.getName(),seatModel.isStatus(),seatModel.getUserUpdate(),seatModel.getIdSeat());
	}
	@Override
	public List<SeatModel> findbyIDBus(int x) {
		String sql = "Select* from seat WHERE IDBus=?";
		return query(sql,new SeatMapper(),x);
	}
	
}
