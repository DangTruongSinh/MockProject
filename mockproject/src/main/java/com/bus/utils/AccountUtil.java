package com.bus.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.model.AccountModel;
import com.bus.service.imp.AccountService;

public class AccountUtil {
	public static AccountModel register(HttpServletRequest req, AccountService acService, AccountModel accountHeThong) {
		String userName = req.getParameter("username");
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
			if (accountHeThong != null)
				accModel.setUserCreate(accountHeThong.getUserName());
			return acService.insertAccountModel(accModel);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void update(HttpServletRequest req, HttpServletResponse resp, int idRole) {
		AccountModel userHeThong = (AccountModel) req.getSession().getAttribute("account");
		AccountModel account = new AccountModel();
		account.setIdUser(Integer.parseInt(req.getParameter("idUser")));
		if(idRole == 3)	
			account.setIdRole(idRole);
		else
			account.setIdRole(Integer.parseInt(req.getParameter("idRole")));
		account.setFullName(req.getParameter("fullName"));
		account.setPassword(req.getParameter("password"));
		account.setPhone(req.getParameter("phone"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		account.setUserUpdate(userHeThong.getUserName());
		Date date;
		try {
			date = format.parse(req.getParameter("dateBirth"));
			System.out.println("date:"+date);
			account.setDateBirth(new Timestamp(date.getTime()));
			AccountModel accountNew = new AccountService().updateAccountModel(account);
			if (accountNew != null) {
				if (userHeThong.getUserName().equals(accountNew.getUserName())
						&& !userHeThong.getPassword().equals(accountNew.getPassword())) {
					req.getSession().invalidate();
					resp.sendRedirect("/mockproject/view/login.jsp");
				} else {
					if(idRole == 1)
						resp.sendRedirect("/mockproject/admin-account?" + "action=search&username=" + accountNew.getUserName());
					else if(idRole == 3)
						{
							req.getSession().setAttribute("account", accountNew);
							resp.sendRedirect("/mockproject/view/customer-updateprofile.jsp");
						}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
