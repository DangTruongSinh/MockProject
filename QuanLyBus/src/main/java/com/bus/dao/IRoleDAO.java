package com.bus.dao;

import java.util.List;

import com.bus.model.RoleModel;

public interface IRoleDAO extends IGenericDAO<RoleModel>{
	List<RoleModel> findAll();
	int updateTicketModel(RoleModel roleModel);

}
