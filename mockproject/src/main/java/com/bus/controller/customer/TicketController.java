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
		}
		else if (action.equals("ticket")) {
			String request = req.getParameter("request");
			if (request.equals("listbus")) {
				String start = req.getParameter("start-input");
				String end = req.getParameter("end-input");
				String date = req.getParameter("date");
				List<BusModel> listBus = new BusService().findAllBusByPlace(start, end,date);
				if(listBus!=null)
					{
						req.setAttribute("buss", listBus);
						req.setAttribute("date", date);
					}
				RequestDispatcher rq = req.getRequestDispatcher("/view/customer-list-bus.jsp");
				rq.forward(req, resp);
			} else if (request.equals("listseat")) {
				RequestDispatcher rq = req.getRequestDispatcher("/view/customer-book-seat.jsp");
				int idBus = Integer.parseInt(req.getParameter("idbus"));
				String date = req.getParameter("date");
				int soluong = new TicketService().getTotalBookedTicketByIdUserAndIdBusAndDate(account.getIdUser(),idBus,date);
				String startPlace = req.getParameter("startPlace");
				String stopPlace = req.getParameter("stopPlace");
				String timeStart = req.getParameter("timeStart");
				String timeEnd = req.getParameter("timeEnd");
				BusModel bus = new BusService().findOneByIdBus(idBus,startPlace,stopPlace,date);
				req.setAttribute("bus", bus);
				req.setAttribute("date", date);
				req.setAttribute("slvedadat", soluong);
				req.setAttribute("idbus", idBus);
				req.setAttribute("startPlace",startPlace);
				req.setAttribute("stopPlace",stopPlace);
				req.setAttribute("timeStart",timeStart);
				req.setAttribute("timeEnd",timeEnd);
				rq.forward(req, resp);
			} else if (request.equals("book")) {
				int idBus = Integer.parseInt(req.getParameter("idbus"));
				String strListBookedSeat = req.getParameter("listBookedSeat");
				String departDate = req.getParameter("date");
				String arrListBookedSeat[] = strListBookedSeat.split(",");
				String price = req.getParameter("price");
				if (arrListBookedSeat.length > 0	) {
					for (String x : arrListBookedSeat) {
						TicketModel ticketModel = new TicketModel();
						ticketModel.setIdBus(idBus);
						ticketModel.setIdSeat(Integer.parseInt(x));
						ticketModel.setIdUser(account.getIdUser());
						ticketModel.setStatus(false);
						ticketModel.setPrice(price);
						ticketModel.setDateCreate(new Timestamp(System.currentTimeMillis()));
						ticketModel.setUserCreate(account.getUserName());
						ticketModel.setDepartDate(departDate);
						new TicketService().insertTicketModel(ticketModel);
					}
					resp.sendRedirect("/mockproject/customer-ticket?action=viewTicked");
				}
			}
		}
	}

}
