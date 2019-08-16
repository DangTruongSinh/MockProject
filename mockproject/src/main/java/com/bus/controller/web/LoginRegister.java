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
import com.bus.utils.AccountUtil;
@WebServlet(urlPatterns = "/dang-nhap")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountService acService = new AccountService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountModel account = (AccountModel) session.getAttribute("account");
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals("logout")) {
				session.invalidate();
				resp.sendRedirect("/mockproject/view/login.jsp");
				return;
			}
		}
		if (account == null)
			resp.sendRedirect("/mockproject/view/login.jsp");
		else
			phantrang(account, resp,req);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if(action.equalsIgnoreCase("login"))
		{
			String username = req.getParameter("userName");
			String password = req.getParameter("password");
			AccountModel account = acService.checkLogin(username, password);
			if (account != null) {
				HttpSession session = req.getSession();
				session.setAttribute("account", account);
				phantrang(account, resp,req);
			} else
				{
					req.setAttribute("alert", "warning");
					req.setAttribute("message", "Account not correct");
					req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
				}
		}
		else if(action.equalsIgnoreCase("register"))
		{
			AccountModel accModel = AccountUtil.register(req, acService,null);
			if(accModel != null)
			{
				req.setAttribute("alert", "success");
				req.setAttribute("message", "Success");
			}
			else
			{
				req.setAttribute("alert", "warning");
				req.setAttribute("message", "Fail,Username has used!");
			}
			req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
		}

	}

	private void phantrang(AccountModel account, HttpServletResponse resp,HttpServletRequest req) {
		String role = account.getRole().getName();
		try {
			if (role.equalsIgnoreCase("customer"))
				resp.sendRedirect("/mockproject/customer-home");
			else if (role.equalsIgnoreCase("admin"))
				resp.sendRedirect("/mockproject/admin-home");
			else
				resp.sendRedirect("/mockproject/employee-home");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
