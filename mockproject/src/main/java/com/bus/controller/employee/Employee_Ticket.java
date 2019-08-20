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

@WebServlet(urlPatterns = "/employee-ticket")
public class Employee_Ticket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String username = req.getParameter("username");
		String date = req.getParameter("DATE");
		String IDTICKETCANCEL = req.getParameter("IDTICKETCANCEL");
		String IDTICKETUPDATE = req.getParameter("IDTICKETUPDATE");
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
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/view/employee-ticket.jsp");
			rDispatcher.forward(req, resp);
		}
		else if (action.equals("search")) {
			AccountModel accModel= accService.findOneByUsername(username);
			List<TicketModel> list=ticketService.findAllbyIDUser(accModel.getIdUser());
			req.setAttribute("tickets", list);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/view/employee-ticket.jsp");
			rDispatcher.forward(req, resp);
		}
		else if(action.equals("updateStatus"))
		{
			ticketService.updateStatusTicket(Integer.parseInt(IDTICKETUPDATE));
			PageModel page = new PageModel();
			page.setTotalPage((int) Math.ceil((float) ticketService.getTotalTicket() / page.getMaxPageItem()));
			String curentPage = req.getParameter("curentPage");
			if (curentPage != null)
				page.setCurentPage(Integer.parseInt(curentPage));
			req.setAttribute("tickets", ticketService.findlimit(page));
			req.setAttribute("pageModel", page);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/view/employee-ticket.jsp");
			rDispatcher.forward(req, resp);
		}
		else if(action.equals("cancel"))
		{
			ticketService.deleteTicketModel(Integer.parseInt(IDTICKETCANCEL));
//			PageModel page = new PageModel();
//			page.setTotalPage((int) Math.ceil((float) ticketService.getTotalTicket() / page.getMaxPageItem()));
//			String curentPage = req.getParameter("curentPage");
//			if (curentPage != null)
//				page.setCurentPage(Integer.parseInt(curentPage));
//			req.setAttribute("tickets", ticketService.findlimit(page));
//			req.setAttribute("pageModel", page);
//			RequestDispatcher rDispatcher = req.getRequestDispatcher("/view/employee-ticket.jsp");
//			rDispatcher.forward(req, resp);
			
			AccountModel accModel= accService.findOneByUsername(username);
			List<TicketModel> list=ticketService.findAllbyIDUser(accModel.getIdUser());
			req.setAttribute("tickets", list);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/view/employee-ticket.jsp");
			rDispatcher.forward(req, resp);
		}
	}
}
