package com.bus.dao.impl;

import java.util.List;

import com.bus.dao.IRoleDAO;
import com.bus.mapper.RoleMapper;
import com.bus.model.RoleModel;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO{
	
	public static void main(String[] args) {
		RoleDAO ac=new RoleDAO();
//	for (RoleModel ds :ac.findAll()) {
//		System.out.println(ds.getIdRole()+" - "+ds.getName() + " - " +ds.getDateCreate() + " - "+ ds.getUserCreate());
//		}
		RoleModel rm=new RoleModel();
		rm.setUserUpdate("nhdlklk");
		rm.setIdRole(1);
		ac.updateTicketModel(rm);
	}
	@Override
	public List<RoleModel> findAll() {
		String sql = "select * from role";
		return query(sql, new RoleMapper());
	}
	
	@Override
	public int updateTicketModel(RoleModel roleModel) {
		String sql = "UPDATE role SET UserUpdate= ? WHERE IDRole=?";
		return update(sql,roleModel.getUserUpdate(),roleModel.getIdRole());
	}


}
