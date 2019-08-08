package com.bus.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.model.AccountModel;
import com.bus.service.imp.AccountService;
import com.bus.utils.HttpUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-account"})
public class AccountAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String acction = req.getParameter("action");
		AccountService accountService = new AccountService();
		if(acction.equals("getAll"))
		{
			List<AccountModel> list = accountService.findAll();
			mapper.writeValue(resp.getOutputStream(), list);
		}
		else if(acction.equals("login"))
		{
			AccountModel accountModel = HttpUtil.of(req.getReader()).toModel(AccountModel.class);
			AccountModel accModel = accountService.findOneByUsernameAndPassword(accountModel.getUserName()
					, accountModel.getPassword());
			if(accModel != null)
				mapper.writeValue(resp.getOutputStream(), accModel);
			else
				{
					mapper.writeValue(resp.getOutputStream(), "{}");
				}
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		AccountModel accountModel = HttpUtil.of(req.getReader()).toModel(AccountModel.class);
		AccountService accountService = new AccountService();
		AccountModel result = accountService.insertAccountModel(accountModel);
		mapper.writeValue(resp.getOutputStream(), result);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
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
