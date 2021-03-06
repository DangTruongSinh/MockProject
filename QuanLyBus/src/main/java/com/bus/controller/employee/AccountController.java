package com.bus.controller.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bus.model.AccountModel;
import com.bus.model.PageModel;
import com.bus.model.TicketModel;
import com.bus.service.imp.AccountService;
import com.bus.service.imp.TicketService;

@WebServlet(urlPatterns = "/employee-account")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String username = req.getParameter("username");
		String IDTICKETUPDATE=req.getParameter("IDTICKETUPDATE");
		String IDTICKETCANCEL=req.getParameter("IDTICKETCANCEL");
		TicketService ticketService=new TicketService();
		AccountService accService=new AccountService();
		if (action == null || username.equals("")) {
			PageModel page = new PageModel();
			page.setTotalPage((int) Math.ceil((float) ticketService.getTotalTicket() / page.getMaxPageItem()));
			String curentPage = req.getParameter("curentPage");
			if (curentPage != null)
				page.setCurentPage(Integer.parseInt(curentPage));
			req.setAttribute("tickets", ticketService.findlimit(page));
			req.setAttribute("pageModel", page);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/view/employee-home.jsp");
			rDispatcher.forward(req, resp);
		}
		else if (action.equals("search")) {
			AccountModel accountModel = accService.findOneByUsername(username);
			if(accountModel!=null)
			{
				List<TicketModel> list=ticketService.findAllbyIDUser(accountModel.getIdUser());
				req.setAttribute("tickets", list);
			}
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/view/employee-home.jsp");
			rDispatcher.forward(req, resp);
		}
		else if(action.equals("updateStatus"))
		{
			System.out.println(IDTICKETUPDATE);
		}
		else if(action.equals("cancel"))
		{
			System.out.println(IDTICKETCANCEL);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String action = req.getParameter("action");
//		if(action.equals("update"))
//		{
//			AccountUtil.update(req, resp, 1);			
//		}
//		else
//		{
//			AccountModel admin = (AccountModel) req.getSession().getAttribute("account");
//			AccountModel accModel = AccountUtil.register(req, new AccountService(),admin);
//			if(accModel != null)
//			{
//				List<AccountModel> list = new ArrayList<AccountModel>();
//				list.add(accModel);
//				req.setAttribute("accounts", list);
//			}
//			RequestDispatcher rDispatcher = req.getRequestDispatcher("/view/admin-list-account.jsp");
//			rDispatcher.forward(req, resp);
//		}
	}
}
