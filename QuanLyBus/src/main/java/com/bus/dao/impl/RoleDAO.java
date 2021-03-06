package com.bus.dao.impl;

import java.util.List;

import com.bus.dao.IRoleDAO;
import com.bus.mapper.RoleMapper;
import com.bus.model.RoleModel;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO{
	
	@Override
	public List<RoleModel> findAll() {
		String sql = "select * from role";
		List<RoleModel> list = query(sql, new RoleMapper());
		return list.size() == 0 ? null : list;
	}
	
	@Override
	public int updateRoleModel(RoleModel roleModel) {
		String sql = "UPDATE role SET UserUpdate= ? WHERE IDRole=?";
		return update(sql,roleModel.getUserUpdate(),roleModel.getIdRole());
	}

	@Override
	public RoleModel findOneById(int id) {
		String sql = "select * from role where IDRole = ?";
		List<RoleModel> list = query(sql, new RoleMapper(),id);
		return list.size() == 0 ? null : list.get(0);
	}

	@Override
	public int insertRoleModel(RoleModel roleModel) {
		String sql = "insert into role(Name,UserCreate,UserUpdate) values(?,?,?)";
		return insert(sql, roleModel.getName(),roleModel.getUserCreate()
				,roleModel.getUserUpdate());
	}
}
