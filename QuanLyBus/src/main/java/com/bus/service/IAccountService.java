package com.bus.service;

import java.util.List;

import com.bus.model.AccountModel;

public interface IAccountService {
	List<AccountModel> findAll();
	AccountModel insertAccountModel(AccountModel accModel);
	AccountModel updateAccountModel(AccountModel accModel);
	boolean deleteAccountModel(int id);
	List<AccountModel> findAllbyIDRole(int id);
	AccountModel findOneByUsernameAndPassword(String username, String password);
	AccountModel findOneByUsername(String username);
}
