package com.bus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bus.model.SeatModel;

public class SeatMapper implements IRowMapper<SeatModel> {
	@Override
	public SeatModel mapRow(ResultSet resultSet) { 
		SeatModel seatModel = new SeatModel();
		try {
			
			seatModel.setIdSeat(resultSet.getInt("IDSeat"));
			seatModel.setIdBus(resultSet.getInt("IDBus"));
			seatModel.setName(resultSet.getInt("Name"));
			seatModel.setStatus(resultSet.getBoolean("Status"));
			seatModel.setDateCreate(resultSet.getTimestamp("DateCreate"));
			seatModel.setDateUpdate(resultSet.getTimestamp("DateUpdate"));
			seatModel.setUserCreate(resultSet.getString("UserCreate"));
			seatModel.setUserUpdate(resultSet.getString("UserUpdate"));
			
		
			return seatModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
