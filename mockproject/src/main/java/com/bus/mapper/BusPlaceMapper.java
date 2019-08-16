package com.bus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bus.model.BusPlaceModel;

public class BusPlaceMapper implements IRowMapper<BusPlaceModel> {
	
	@Override
	public BusPlaceModel mapRow(ResultSet resultSet) { 
		BusPlaceModel busplace = new BusPlaceModel();
		try {
			busplace.setIdBusPlace(resultSet.getInt("IdBusPlace"));
			busplace.setIdBus(resultSet.getInt("IdBus"));
			busplace.setIdPlace(resultSet.getInt("IdPlace"));
			return busplace;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
