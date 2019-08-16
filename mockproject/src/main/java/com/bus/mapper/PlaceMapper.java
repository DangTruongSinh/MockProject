package com.bus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bus.model.PlaceModel;

public class PlaceMapper implements IRowMapper<PlaceModel>{

	@Override
	public PlaceModel mapRow(ResultSet rs) {
		PlaceModel placeModel = new PlaceModel();
		try {
			
			placeModel.setIdPlace(rs.getInt("IdPlace"));
			placeModel.setStartPlace(rs.getString("StartPlace"));
			placeModel.setStopPlace(rs.getString("StopPlace"));
			placeModel.setTimeStart(rs.getTime("TimeStart"));
			placeModel.setTimeEnd(rs.getTime("TimeEnd"));
			placeModel.setDateCreate(rs.getTimestamp("DateCreate"));
			placeModel.setDateUpdate(rs.getTimestamp("DateUpdate"));
			placeModel.setUserCreate(rs.getString("UserCreate"));
			placeModel.setUserUpdate(rs.getString("UserUpdate"));
			placeModel.setPrice(rs.getString("price"));
			return placeModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
