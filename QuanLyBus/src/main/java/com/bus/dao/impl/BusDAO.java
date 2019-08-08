package com.bus.dao.impl;

import java.util.List;

import com.bus.dao.IBusDAO;
import com.bus.mapper.BusMapper;
import com.bus.model.BusModel;

public class BusDAO extends AbstractDAO<BusModel> implements IBusDAO{
 
	@Override
	public List<BusModel> findAll() {
		String sql = "select * from bus";
		List<BusModel> list = query(sql, new BusMapper());
		return list.size() == 0 ? null : list;
	}
	@Override
	public int insertBusModel(BusModel busModel) {
		String sql = "insert into bus(LicensePlate,TimeStart,TimeEnd,PlaceStart,PlaceEnd,"
				+ "UserCreate,UserUpdate) values(?,?,?,?,?,?,?);";
		return 	insert(sql, busModel.getLicensePlate(),busModel.getTimeStart(),
				busModel.getTimeEnd(),busModel.getPlaceStart(),busModel.getPlaceEnd(),
				busModel.getUserCreate(),busModel.getUserUpdate());
	}
	@Override
	public int updateBusModel(BusModel busModel) {
		String sql = "update bus set LicensePlate = ?,TimeStart = ?,TimeEnd = ?,PlaceStart = ?, PlaceEnd= ?,"
				+ "UserUpdate = ? where IDBus = ?";
		return 	update(sql, busModel.getLicensePlate(),busModel.getTimeStart(),
				busModel.getTimeEnd(),busModel.getPlaceStart(),busModel.getPlaceEnd(),
				busModel.getUserUpdate(),busModel.getIdBus());
	}
	@Override
	public int deleteBusModel(int id) {
		String sql = "delete from bus where IDBus = ?";
		return delete(sql, id);
	}
	@Override
	public BusModel findOneByLicensePlate(String licensePlace) {
		String sql = "select * from bus where LicensePlate = ?";
		List<BusModel> list = query(sql, new BusMapper(), licensePlace);
		return list.size() == 0 ? null : list.get(0);
	}
	@Override
	public List<BusModel> findAllByPlaceStartToEnd(String start, String end) {
		String sql = "select * from bus where PlaceStart = ? and PlaceEnd = ?";
		List<BusModel> list = query(sql, new BusMapper(), start,end);
		return list.size() == 0 ? null : list;
	}
	@Override
	public BusModel findOneByIdBus(int id) {
		String sql = "select * from bus where IDBus = ?";
		List<BusModel> list = query(sql, new BusMapper(), id);
		return list.size() == 0 ? null : list.get(0);
	}
	
	
}
