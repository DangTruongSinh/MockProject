package com.bus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bus.model.BusModel;

public class BusMapper implements IRowMapper<BusModel>{

	@Override
	public BusModel mapRow(ResultSet resultSet) { 
		BusModel busModel = new BusModel();
		try {
			busModel.setIdBus(resultSet.getInt("IDBus"));
			busModel.setDateCreate(resultSet.getTimestamp("DateCreate"));
			busModel.setDateUpdate(resultSet.getTimestamp("DateUpdate"));
			busModel.setLicensePlate(resultSet.getString("LicensePlate"));
			busModel.setUserCreate(resultSet.getString("UserCreate"));
			busModel.setUserUpdate(resultSet.getString("UserUpdate"));
			busModel.setIdUser(resultSet.getInt("IdUser"));
			return busModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
