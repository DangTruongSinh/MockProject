package com.bus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bus.model.RoleModel;

public class RoleMapper implements IRowMapper<RoleModel> {

	@Override
	public RoleModel mapRow(ResultSet resultSet) { 
		RoleModel roleModel = new RoleModel();
		try {
			
			roleModel.setIdRole(resultSet.getInt("IDRole"));
			roleModel.setName(resultSet.getString("Name"));
			roleModel.setDateCreate(resultSet.getTimestamp("DateCreate"));
			roleModel.setDateUpdate(resultSet.getTimestamp("DateUpdate"));
			roleModel.setUserCreate(resultSet.getString("UserCreate"));
			roleModel.setUserUpdate(resultSet.getString("UserUpdate"));
			
		
			return roleModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
