package com.bus.service;

import java.util.List;

import com.bus.model.RoleModel;

public interface IRoleService {
	List<RoleModel> findAll();
	RoleModel updateRoleModel(RoleModel roleModel);
	RoleModel findOneById(int id);
	RoleModel insertRoleModel(RoleModel roleModel);
}
