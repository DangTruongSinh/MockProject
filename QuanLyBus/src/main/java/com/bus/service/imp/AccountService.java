package com.bus.service.imp;

import java.util.List;

import com.bus.dao.impl.AccountDAO;
import com.bus.dao.impl.RoleDAO;
import com.bus.model.AccountModel;
import com.bus.model.RoleModel;
import com.bus.service.IAccountService;

public class AccountService implements IAccountService{
	AccountDAO accountDao;
	public AccountService()
	{
		accountDao =  new AccountDAO();
	}
	@Override
	public List<AccountModel> findAll() {
		List<AccountModel> list = accountDao.findAll();
		return setRoleForListAccount(list);
	}
	@Override
	public AccountModel insertAccountModel(AccountModel accModel) {
		AccountModel accModel2 = findOneByUsername(accModel.getUserName());
		if(accModel2 == null)
		{
			int id = accountDao.insertAccountModel(accModel);
			if(id != -1)
				return accountDao.findOneByIDModel(id);
		}
		return null;
	}

	@Override
	public AccountModel updateAccountModel(AccountModel accModel) {
		accModel.setUserUpdate("userHienTai");
		int result = accountDao.updateAccountModel(accModel);
		if(result != -1)
			return accountDao.findOneByIDModel(accModel.getIdUser());
		return null;
	}

	@Override
	public boolean deleteAccountModel(int id) {
		return accountDao.deleteAccountModel(id) == 1 ? true : false;
	}

	@Override
	public List<AccountModel> findAllbyIDRole(int id) {
		List<AccountModel> list = accountDao.findbyIDRole(id);
		return setRoleForListAccount(list);
	}

	@Override
	public AccountModel findOneByUsernameAndPassword(String username, String password) {
		AccountModel accModel = accountDao.findOneByUsernameAndPassword(username, password);
		return setRoleForAAcount(accModel);
	}

	@Override
	public AccountModel findOneByUsername(String username) {
		AccountModel accModel = accountDao.findOneByUsername(username);
		return setRoleForAAcount(accModel);
	}
	private AccountModel setRoleForAAcount(AccountModel accModel)
	{
		if(accModel != null)
		{
			RoleDAO roleDao = new RoleDAO();
			RoleModel roleModel = roleDao.findOneById(accModel.getIdRole());
			accModel.setRole(roleModel);
			return accModel;
		}
		return null;
	}
	private List<AccountModel> setRoleForListAccount(List<AccountModel> list)
	{
		RoleDAO roleDao = new RoleDAO();
		if(list != null)
		{
			for(AccountModel x : list)
			{
				RoleModel roleModel = roleDao.findOneById(x.getIdRole());
				x.setRole(roleModel);
			}
		}
		return list;
	}
}
