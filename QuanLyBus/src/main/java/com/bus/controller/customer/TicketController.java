package com.bus.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bus.model.AccountModel;
import com.bus.model.TicketModel;
import com.bus.service.imp.TicketService;

@WebServlet(urlPatterns = "/customer-ticket")
public class TicketController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		TicketService ticketService = new TicketService();
		HttpSession session = req.getSession();
		AccountModel account = (AccountModel) session.getAttribute("account");
		if(action.equals("viewTicked"))
		{
			List<TicketModel> list = ticketService.findAllbyIDUser(account.getIdUser());
			System.out.println(list.size());
			System.out.println("idBus:"+list.get(0).getIdBus());
			System.out.println(list.get(0).getBus().getLicensePlate());
			System.out.println(list.get(0).getSeat().getName());
			req.setAttribute("tickets", list);
			RequestDispatcher rq = req.getRequestDispatcher("/view/customer-list-ticket.jsp");
			rq.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
