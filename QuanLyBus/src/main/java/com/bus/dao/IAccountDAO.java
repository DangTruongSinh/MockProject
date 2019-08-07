package com.bus.dao;

import java.util.List;

import com.bus.model.AccountModel;

public interface IAccountDAO extends IGenericDAO<AccountModel> {
	List<AccountModel> findAll();
	int insertAccountModel(AccountModel accModel);
	int updateAccountModel(AccountModel accModel);
	int deleteAccountModel(AccountModel accModel);
	List<AccountModel> findbyIDRole(int x);
}
