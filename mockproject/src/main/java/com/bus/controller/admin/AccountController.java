package com.bus.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.model.AccountModel;
import com.bus.model.PageModel;
import com.bus.model.RoleModel;
import com.bus.service.imp.AccountService;
import com.bus.service.imp.RoleService;
import com.bus.utils.AccountUtil;

@WebServlet(urlPatterns = "/admin-account")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String username = req.getParameter("username");
		req.setAttribute("myAccount", req.getSession().getAttribute("account"));
		AccountService accService = new AccountService();
		if (action == null || username.equals("")) {
			PageModel page = new PageModel();
			page.setTotalPage((int) Math.ceil((float) accService.getTotalAccount() / page.getMaxPageItem()));
			String curentPage = req.getParameter("curentPage");
			if (curentPage != null)
				page.setCurentPage(Integer.parseInt(curentPage));
			req.setAttribute("accounts", accService.findlimit(page));
			req.setAttribute("pageModel", page);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/view/admin-list-account.jsp");
			rDispatcher.forward(req, resp);
		}
		else if (action.equals("search")) {
			
			AccountModel account = accService.findOneByUsername(username);
			if (account != null) {
				List<AccountModel> list = new ArrayList<AccountModel>();
				list.add(account);
				req.setAttribute("accounts", list);
			}
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/view/admin-list-account.jsp");
			rDispatcher.forward(req, resp);
		}
		else if(action.equals("edit"))
		{
			AccountModel account = accService.findOneByUsername(username);
			List<RoleModel> listRole = new RoleService().findAll();
			req.setAttribute("roles", listRole);
			req.setAttribute("account", account);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/view/admin-update-account.jsp");
			rDispatcher.forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println("action:"+action);
		req.setAttribute("myAccount", req.getSession().getAttribute("account"));
		if(action.equals("update"))
		{
			AccountUtil.update(req, resp, 1);			
		}
		else if(action.equals("create"))
		{
			AccountModel admin = (AccountModel) req.getSession().getAttribute("account");
			AccountModel accModel = AccountUtil.register(req, new AccountService(),admin);
			System.out.println("account:"+accModel);
			if(accModel != null)
			{
				List<AccountModel> list = new ArrayList<AccountModel>();
				list.add(accModel);
				req.setAttribute("accounts", list);
			}
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/view/admin-list-account.jsp");
			rDispatcher.forward(req, resp);
		}
	}
}
