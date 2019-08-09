package com.bus.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.bus.model.AccountModel;
import com.bus.service.imp.AccountService;

public class AccountUtil {
	public static AccountModel register(HttpServletRequest req,AccountService acService,AccountModel accountHienTai)
	{
		String userName =  req.getParameter("username");
		String password = req.getParameter("password");
		String fullName = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		String ngaySinh = req.getParameter("ngaysinh");
		SimpleDateFormat sdfFormat = new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date date = sdfFormat.parse(ngaySinh);
			AccountModel accModel = new AccountModel();
			accModel.setUserName(userName);
			accModel.setPassword(password);
			accModel.setFullName(fullName);
			accModel.setPhone(phone);
			accModel.setDateBirth(new Timestamp(date.getTime()));
			accModel.setIdRole(3);
			accModel.setUserCreate("");
			accModel.setUserUpdate("");
			if(accountHienTai != null)
				accModel.setUserCreate(accountHienTai.getUserName());
			return acService.insertAccountModel(accModel);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		return null;
	}

}
