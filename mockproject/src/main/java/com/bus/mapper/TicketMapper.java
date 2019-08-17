package com.bus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.bus.model.TicketModel;

public class TicketMapper implements IRowMapper<TicketModel>{

	@Override
	public TicketModel mapRow(ResultSet resultSet) { 
		TicketModel tickModel = new TicketModel();
		try {
			
			tickModel.setIdTicket(resultSet.getInt("IDTicket"));
			tickModel.setIdBus(resultSet.getInt("IDBus"));
			tickModel.setIdSeat(resultSet.getInt("IDSeat"));
			tickModel.setIdUser(resultSet.getInt("IDUser"));
			tickModel.setStatus(resultSet.getBoolean("Status"));
			tickModel.setPrice(resultSet.getString("Price"));
			tickModel.setDateCreate(resultSet.getTimestamp("DateCreate"));
			tickModel.setDateUpdate(resultSet.getTimestamp("DateUpdate"));
			tickModel.setUserCreate(resultSet.getString("UserCreate"));
			tickModel.setUserUpdate(resultSet.getString("UserUpdate"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			tickModel.setDepartDate(format.format(resultSet.getDate("DepartDate")));
		
			return tickModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
