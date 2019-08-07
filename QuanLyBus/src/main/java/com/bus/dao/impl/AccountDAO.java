package com.bus.dao.impl;


import java.sql.Timestamp;
import java.util.List;

import com.bus.dao.IAccountDAO;
import com.bus.mapper.AccountMapper;
import com.bus.mapper.TicketMapper;
import com.bus.model.AccountModel;
import com.bus.model.TicketModel;
public class AccountDAO  extends AbstractDAO<AccountModel> implements IAccountDAO {

	public static void main(String[] args) {
		AccountDAO ac=new AccountDAO();
		for (AccountModel ds :ac.findAll()) {
			System.out.println(ds.getIdUser()+" - "+ ds.getUserName() + " - " +ds.getFullName() + " - "+ ds.getPassword());
		}

//			String text = "2011-10-02 18:48:05.123";
//			Timestamp ts = Timestamp.valueOf(text);
//		
//		AccountDAO ac = new AccountDAO();
//		AccountModel ds = new AccountModel();
////		ds.setIdRole(3);
//		ds.setIdUser(17);
////		ds.setPassword("123");
////		ds.setFullName("Nguyen Duy");
////		ds.setPhone("0101001010101");
////		ds.setDateBirth(ts);
////		ds.setUserUpdate("nhdlklk");
////		ds.setLastTimeLogin(ts);
//		ac.deleteAccountModel(ds);

	 
	}
	@Override
	public List<AccountModel> findAll() {
		String sql = "select * from account";
		return query(sql, new AccountMapper());
	}
	
	@Override
	public List<AccountModel> findbyIDRole(int x) {
		String sql = "Select* from account WHERE IDRole=?";
		return query(sql,new AccountMapper(),x);
	}
	
	@Override
	public int insertAccountModel(AccountModel accModel) {
		String sql = "INSERT INTO account(IDRole, UserName, Password, FullName, Phone, DateBirth, UserCreate,UserUpdate) VALUES (?,?,?,?,?,?,?,?)";
		return insert(sql,accModel.getIdRole(),accModel.getUserName(),accModel.getPassword(),accModel.getFullName(),accModel.getPhone(),
				accModel.getDateBirth(),accModel.getUserCreate(),accModel.getUserUpdate());
	}
	@Override
	public int updateAccountModel(AccountModel accModel) {
		String sql = "UPDATE account SET IDRole=?, `Password` =?, FullName=?, Phone=?,DateBirth=?,UserUpdate=?,LastTimeLogin=? WHERE IDUser = ?";
		return update(sql,accModel.getIdRole(),accModel.getPassword(),accModel.getFullName(),
				accModel.getPhone(),accModel.getDateBirth(),accModel.getUserUpdate(),accModel.getLastTimeLogin(),accModel.getIdUser());
	}
	@Override
	public int deleteAccountModel(AccountModel accModel) {
		String sql = "delete from account where IDUser = ?";
		return delete(sql, accModel.getIdUser());
	}
}
