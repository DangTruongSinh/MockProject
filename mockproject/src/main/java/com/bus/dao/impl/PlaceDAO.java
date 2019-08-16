package com.bus.dao.impl;

import java.util.List;

import com.bus.dao.IPlaceDAO;
import com.bus.mapper.PlaceMapper;
import com.bus.model.PlaceModel;

public class PlaceDAO extends AbstractDAO<PlaceModel> implements IPlaceDAO {
	@Override
	public List<PlaceModel> findAll() {
		String sql ="select * from place";
		return query(sql, new PlaceMapper());
	}
	@Override
	public PlaceModel findPlaceModel(int id) {
		String sql = "select * from place where IdPlace = ?";
		return query(sql, new PlaceMapper(), id).get(0);
	}
	@Override
	public PlaceModel findPlaceByPlace(String start, String end) {
		String sql = "select * from place where StartPlace = ? and StopPlace = ?";
		return query(sql, new PlaceMapper(), start, end).get(0);
	}
	
}
