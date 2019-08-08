package com.bus.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bus.model.AccountModel;
import com.bus.service.imp.AccountService;

@WebServlet(urlPatterns = "/dang-nhap")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountModel account = (AccountModel) session.getAttribute("account");
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals("logout")) {
				req.getSession().invalidate();
				resp.sendRedirect("/QuanLyBus/view/login.jsp");
			}
		}
		if (account == null)
			resp.sendRedirect("/QuanLyBus/view/login.jsp");
		else
			phantrang(account, resp,req);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("userName");
		String password = req.getParameter("password");
		AccountService acService = new AccountService();
		AccountModel account = acService.findOneByUsernameAndPassword(username, password);
		if (account != null) {
			HttpSession session = req.getSession();
			session.setAttribute("account", account);
			phantrang(account, resp,req);
		} else
			resp.sendRedirect("/QuanLyBus/view/login.jsp");

	}

	private void phantrang(AccountModel account, HttpServletResponse resp,HttpServletRequest req) {
		String role = account.getRole().getName();
		try {
			if (role.equalsIgnoreCase("customer"))
				resp.sendRedirect("/QuanLyBus/customer-home");
			else if (role.equalsIgnoreCase("admin"))
				resp.sendRedirect("/QuanLyBus/admin-home");
			else
				resp.sendRedirect("/QuanLyBus/employee-home");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
