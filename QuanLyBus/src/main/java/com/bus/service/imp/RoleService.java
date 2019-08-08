package com.bus.service.imp;

import java.util.List;

import com.bus.dao.impl.RoleDAO;
import com.bus.model.RoleModel;
import com.bus.service.IRoleService;

public class RoleService implements IRoleService{
	RoleDAO roleDao;
	public RoleService()
	{
		roleDao = new RoleDAO();
	}
	@Override
	public List<RoleModel> findAll() {
		return roleDao.findAll();
	}

	@Override
	public RoleModel updateRoleModel(RoleModel roleModel) {
		roleModel.setUserUpdate("userhientai");
		int resule = roleDao.updateRoleModel(roleModel);
		if(resule != -1)
		{
			return roleDao.findOneById(roleModel.getIdRole());
		}
		return null;
	}

	@Override
	public RoleModel findOneById(int id) {
		return roleDao.findOneById(id);
	}

	@Override
	public RoleModel insertRoleModel(RoleModel roleModel) {
		roleModel.setUserCreate("userhientai");
		roleModel.setUserUpdate("userhientai");
		int id = roleDao.insertRoleModel(roleModel);
		if(id != -1)
			return roleDao.findOneById(id);
		return null;
	}
}
