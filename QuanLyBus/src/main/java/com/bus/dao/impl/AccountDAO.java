package com.bus.dao.impl;


import java.sql.Timestamp;
import java.util.List;

import com.bus.dao.IAccountDAO;
import com.bus.mapper.AccountMapper;
import com.bus.model.AccountModel;
public class AccountDAO  extends AbstractDAO<AccountModel> implements IAccountDAO {

	@Override
	public List<AccountModel> findlimit(int start,int limit) {
		String sql = "select * from account order by IDRole ASC limit ?,?";
		List<AccountModel> list = query(sql, new AccountMapper(),start,limit);
		return list.size() == 0 ? null : list;
	}
	
	@Override
	public List<AccountModel> findbyIDRole(int id) {
		String sql = "Select * from account WHERE IDRole=?";
		List<AccountModel> list = query(sql, new AccountMapper(),id);
		return list.size() == 0 ? null : list;
	}
	
	@Override
	public int insertAccountModel(AccountModel accModel) {
		String sql = "INSERT INTO account(IDRole, UserName, Password, FullName, Phone, DateBirth, UserCreate,UserUpdate) VALUES (?,?,?,?,?,?,?,?)";
		return insert(sql,accModel.getIdRole(),accModel.getUserName(),accModel.getPassword(),accModel.getFullName(),accModel.getPhone(),
				accModel.getDateBirth(),accModel.getUserCreate(),accModel.getUserUpdate());
	}
	@Override
	public int updateAccountModel(AccountModel accModel) {
		String sql = "UPDATE account SET IDRole=?, Password =?, FullName=?, Phone=?,DateBirth=?,UserUpdate=? WHERE IDUser = ?";
		return update(sql,accModel.getIdRole(),accModel.getPassword(),accModel.getFullName(),
				accModel.getPhone(),accModel.getDateBirth(),accModel.getUserUpdate(),accModel.getIdUser());
	}
	@Override
	public int deleteAccountModel(int id) {
		String sql = "delete from account where IDUser = ?";
		return delete(sql, id);
	}

	@Override
	public AccountModel findOneByUsernameAndPassword(String username, String password) {
		String sql = "select * from account where UserName = ? and Password = ?";
		List<AccountModel> list = query(sql, new AccountMapper(), username,password);
		return list.size() == 0 ? null : list.get(0);
	}

	@Override
	public AccountModel findOneByUsername(String username) {
		String sql = "select * from account where UserName = ?";
		List<AccountModel> list = query(sql, new AccountMapper(), username);
		return list.size() == 0 ? null : list.get(0);
	}

	@Override
	public AccountModel findOneByIDModel(int id) {
		String sql = "select * from account where IDUser = ?";
		List<AccountModel> list = query(sql, new AccountMapper(), id);
		return list.size() == 0 ? null : list.get(0);
	}

	@Override
	public int updateTimeLogin(Timestamp time, int idUser) {
		String sql = "update account set LastTimeLogin=? where IDUser = ?";
		return update(sql,time,idUser);
	}

	@Override
	public int getTotalAccount() {
		String sql = "select count(*) from account";
		return getTotalItem(sql);
	}

	@Override
	public List<AccountModel> findAll() {
		String sql ="select * from account";
		return query(sql, new AccountMapper());
	}

	
}
