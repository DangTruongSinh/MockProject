package com.bus.service;

import java.util.List;

import com.bus.model.AccountModel;
import com.bus.model.PageModel;

public interface IAccountService {
	List<AccountModel> findlimit(PageModel page);
	List<AccountModel> findAll();
	AccountModel insertAccountModel(AccountModel accModel);
	AccountModel updateAccountModel(AccountModel accModel);
	boolean deleteAccountModel(int id);
	List<AccountModel> findAllbyIDRole(int id);
	AccountModel findOneByUsername(String username);
	AccountModel checkLogin(String username,String password);
	int getTotalAccount();
}
