package com.bus.dao;

import java.util.List;

import com.bus.model.AccountModel;

public interface IAccountDAO extends IGenericDAO<AccountModel> {
	List<AccountModel> findAll();
	int insertAccountModel(AccountModel accModel);
	int updateAccountModel(AccountModel accModel);
	int deleteAccountModel(int id);
	List<AccountModel> findbyIDRole(int id);
	AccountModel findOneByUsernameAndPassword(String username, String password);
	AccountModel findOneByUsername(String username);
	AccountModel findOneByIDModel(int id);
}
