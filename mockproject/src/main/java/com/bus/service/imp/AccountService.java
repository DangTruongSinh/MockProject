package com.bus.service.imp;

import java.sql.Timestamp;
import java.util.List;

import com.bus.dao.impl.AccountDAO;
import com.bus.dao.impl.RoleDAO;
import com.bus.model.AccountModel;
import com.bus.model.PageModel;
import com.bus.model.RoleModel;
import com.bus.service.IAccountService;

public class AccountService implements IAccountService{
	AccountDAO accountDao;
	public AccountService()
	{
		accountDao =  new AccountDAO();
	}
	@Override
	public List<AccountModel> findlimitByRole(PageModel page, Object ...param) {
		int start = (page.getCurentPage()-1)*page.getMaxPageItem();
		int limit = page.getMaxPageItem();
		List<AccountModel> list = accountDao.findlimitByRole(start, limit,param);
		return setRoleForListAccount(list);
	}
	@Override
	public AccountModel insertAccountModel(AccountModel accModel) {
		AccountModel accModel2 = findOneByUsername(accModel.getUserName());
		if(accModel2 == null)
		{
			int id = accountDao.insertAccountModel(accModel);
			if(id != -1)
				return setRoleForAAcount(accountDao.findOneByIDModel(id));
		}
		return null;
	}

	@Override
	public AccountModel updateAccountModel(AccountModel accModel) {
		int result = accountDao.updateAccountModel(accModel);
		if(result != -1)
			return setRoleForAAcount(accountDao.findOneByIDModel(accModel.getIdUser()));
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
	@Override
	public AccountModel checkLogin(String username, String password) {
		AccountModel account = accountDao.findOneByUsernameAndPassword(username, password);
		if(account != null)
		{
			accountDao.updateTimeLogin(new Timestamp(System.currentTimeMillis()), account.getIdUser());
			setRoleForAAcount(account);
		}
		return account;
	}
	@Override
	public int getTotalAccountByRole(Object ...param) {
			return accountDao.getTotalAccount(param);
	}
	@Override
	public List<AccountModel> findAll() {
		return accountDao.findAll();
	}
	@Override
	public AccountModel findOneByUsernameByRole(String username, Object... param) {
		if((int)param[0] == 0)
			return findOneByUsername(username);
		else
			return accountDao.findOneByUsernameByRole(username, (int)param[0]);
	}
}
