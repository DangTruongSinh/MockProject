package com.bus.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import com.bus.model.AccountModel;
import com.bus.model.TicketModel;
import com.bus.service.imp.TicketService;
import com.bus.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-ticket"})
public class TicketAPI extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountModel account = (AccountModel) session.getAttribute("account");
		List<TicketModel> list = new TicketService().findAllbyIDUser(account.getIdUser());
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), list);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		TicketModel ticket = HttpUtil.of(req.getReader()).toModel(TicketModel.class);
		ObjectMapper mapper = new ObjectMapper();
		boolean result = new TicketService().updateStatusTicket(ticket.getIdTicket());
		if(result == false)
			ticket.setIdTicket(-1);
		mapper.writeValue(resp.getOutputStream(),ticket);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		TicketModel ticket = HttpUtil.of(req.getReader()).toModel(TicketModel.class);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), ticket);
		if (new TicketService().deleteTicketModel(ticket.getIdTicket()))
			ticket.setIdTicket(-1);	
		mapper.writeValue(resp.getOutputStream(), ticket);	
	}
}
