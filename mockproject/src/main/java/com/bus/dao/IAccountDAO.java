package com.bus.dao;

import java.sql.Timestamp;
import java.util.List;


import com.bus.model.AccountModel;

public interface IAccountDAO extends IGenericDAO<AccountModel> {
	List<AccountModel> findlimitByRole(int start,int limit,Object ...param);
	List<AccountModel> findAll();
	int insertAccountModel(AccountModel accModel);
	int updateAccountModel(AccountModel accModel);
	int deleteAccountModel(int id);
	List<AccountModel> findbyIDRole(int id);
	AccountModel findOneByUsernameAndPassword(String username, String password);
	AccountModel findOneByUsername(String username);
	AccountModel findOneByUsernameByRole(String username,int role);
	AccountModel findOneByIDModel(int id);
	int updateTimeLogin(Timestamp time, int idUser);
	int getTotalAccount(Object ...param);
}
