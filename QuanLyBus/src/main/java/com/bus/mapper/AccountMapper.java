package com.bus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bus.model.AccountModel;

public class AccountMapper implements IRowMapper<AccountModel> {

	@Override
	public AccountModel mapRow(ResultSet resultSet) { 
		AccountModel accModel = new AccountModel();
		try {
			
			accModel.setIdUser(resultSet.getInt("IDUser"));
			accModel.setIdRole(resultSet.getInt("IDRole"));
			accModel.setUserName(resultSet.getString("UserName"));
			accModel.setPassword(resultSet.getString("Password"));
			accModel.setFullName(resultSet.getString("FullName"));
			accModel.setPhone(resultSet.getString("Phone"));
			accModel.setDateBirth(resultSet.getTimestamp("DateBirth"));
			accModel.setDateCreate(resultSet.getTimestamp("DateCreate"));
			accModel.setDateUpdate(resultSet.getTimestamp("DateUpdate"));
			accModel.setUserCreate(resultSet.getString("UserCreate"));
			accModel.setUserUpdate(resultSet.getString("UserUpdate"));
			accModel.setLastTimeLogin(resultSet.getTimestamp("LastTimeLogin"));
			
		
			return accModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
