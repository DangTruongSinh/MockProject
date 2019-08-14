package com.bus.controller.customer;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bus.dao.impl.BusDAO;
import com.bus.dao.impl.TicketDAO;
import com.bus.model.AccountModel;
import com.bus.model.BusModel;
import com.bus.model.TicketModel;
import com.bus.service.imp.BusService;
import com.bus.service.imp.TicketService;

@WebServlet(urlPatterns = "/customer-ticket")
public class TicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println(action);
		TicketService ticketService = new TicketService();
		HttpSession session = req.getSession();
		AccountModel account = (AccountModel) session.getAttribute("account");
		if (action.equals("viewTicked")) {
			List<TicketModel> list = ticketService.findAllbyIDUser(account.getIdUser());
			req.setAttribute("tickets", list);
			RequestDispatcher rq = req.getRequestDispatcher("/view/customer-list-ticket.jsp");
			rq.forward(req, resp);
		} else if (action.equals("delete")) {
			int id = Integer.parseInt(req.getParameter("idTicket"));
			if (ticketService.deleteTicketModel(id))
				resp.sendRedirect("/QuanLyBus/customer-ticket?action=viewTicked");
		} else if (action.equals("ticket")) {
			String request = req.getParameter("request");
			if (request.equals("listbus")) {
				String start = req.getParameter("startPlace");
				String end = req.getParameter("endPlace");
				String date = req.getParameter("date");
				List<BusModel> list = new BusService().findAllBusByPlaceAndDate(start, end, date);
				System.out.println("so ghe trong:" + list.get(0).getListBookedSeat().size());
				req.setAttribute("buss", list);
				RequestDispatcher rq = req.getRequestDispatcher("/view/customer-list-bus.jsp");
				rq.forward(req, resp);
			} else if (request.equals("listseat")) {
				RequestDispatcher rq = req.getRequestDispatcher("/view/customer-book-seat.jsp");
				int idBus = Integer.parseInt(req.getParameter("idbus"));
				BusModel bus = new BusService().findOneByIdBus(idBus);
				int soluong = new TicketService().getTotalBookedTicketByIdUser(account.getIdUser());
				System.out.println(soluong);
				req.setAttribute("slvedadat", soluong);
				req.setAttribute("bus", bus);
				rq.forward(req, resp);
			} else if (request.equals("book")) {
				int idBus = Integer.parseInt(req.getParameter("idbus"));
				String strListBookedSeat = req.getParameter("listBookedSeat");
				String arrListBookedSeat[] = strListBookedSeat.split(",");
				if (arrListBookedSeat.length > 0) {
					for (String x : arrListBookedSeat) {
						TicketModel ticketModel = new TicketModel();
						ticketModel.setIdBus(idBus);
						ticketModel.setIdSeat(Integer.parseInt(x));
						ticketModel.setIdUser(account.getIdUser());
						ticketModel.setStatus(false);
						ticketModel.setPrice("10.000");
						ticketModel.setDateCreate(new Timestamp(System.currentTimeMillis()));
						ticketModel.setUserCreate(account.getUserName());
						new TicketService().insertTicketModel(ticketModel);
					}
					resp.sendRedirect("/QuanLyBus/customer-ticket?action=viewTicked");
				}
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println(action);
	}
}
