package com.bus.controller.employee;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bus.model.PageModel;
import com.bus.model.TicketModel;
import com.bus.service.imp.TicketService;

import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/employee-ticket")
public class Employee_Ticket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String username = req.getParameter("username");
		TicketService ticketService=new TicketService();
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

		}
		else if(action.equals("updateStatus"))
		{
			
		}
		else if(action.equals("cancel"))
		{
			
		}
		else if(action.equals("redirect2SeatURL"))
		{
			
		}
		
	}
}
