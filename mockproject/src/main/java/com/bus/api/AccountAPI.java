package com.bus.api;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bus.model.AccountModel;
import com.bus.model.PageModel;
import com.bus.service.imp.AccountService;
import com.bus.utils.HttpUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-account"})
public class AccountAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String action = req.getParameter("action");
		System.out.println(action);
		ObjectMapper mapper = new ObjectMapper();
		AccountService accService = new AccountService();
		
		if(action.equals("getAll"))
		{
			mapper.writeValue(resp.getOutputStream(), findListAccountByRole(req,resp,accService));
		}
		else if(action.equals("search"))
		{
			int role = Integer.parseInt(req.getParameter("filter"));
			AccountModel account = HttpUtil.of(req.getReader()).toModel(AccountModel.class);
			account = new AccountService().findOneByUsernameByRole(account.getUserName(),role);
			if (account != null) {
				mapper.writeValue(resp.getOutputStream(), account);
			}
		}
		else if(action.equals("getAdmin"))
		{
			mapper.writeValue(resp.getOutputStream(), findListAccountByRole(req,resp,accService,1));
		}
		else if(action.equals("getEmployee"))
		{
			mapper.writeValue(resp.getOutputStream(), findListAccountByRole(req,resp,accService,2));
		}
		else if(action.equals("getCustomer"))
		{
			mapper.writeValue(resp.getOutputStream(), findListAccountByRole(req,resp,accService,3));
		}
	}
	private List<AccountModel> findListAccountByRole(HttpServletRequest req, HttpServletResponse resp,
			AccountService accService, Object ...param)
	{
		try
		{
			PageModel page = HttpUtil.of(req.getReader()).toModel(PageModel.class);
			page.setTotalPage((int) Math.ceil((float) accService.getTotalAccountByRole(param) / page.getMaxPageItem()));
			String curentPage = req.getParameter("curentPage");
			if (curentPage != null)
				page.setCurentPage(Integer.parseInt(curentPage));
			List<AccountModel> list =accService.findlimitByRole(page,param);
			return list;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		AccountModel account = HttpUtil.of(req.getReader()).toModel(AccountModel.class);
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = req.getSession();
		AccountModel account2 = (AccountModel) session.getAttribute("account");
		account.setUserUpdate(account2.getUserName());
		account.setDateUpdate(new Timestamp(System.currentTimeMillis()));
		if(new AccountService().updateAccountModel(account) !=null)
			mapper.writeValue(resp.getOutputStream(), "1");
		else
			mapper.writeValue(resp.getOutputStream(), "0");
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		AccountModel accountModel = HttpUtil.of(req.getReader()).toModel(AccountModel.class);
		AccountService accountService = new AccountService();
		boolean result = accountService.deleteAccountModel(accountModel.getIdUser());
		JsonNode actualObj  = mapper.readTree("{\"result\":"+result+"}");
		mapper.writeValue(resp.getOutputStream(), actualObj);
	}
}
