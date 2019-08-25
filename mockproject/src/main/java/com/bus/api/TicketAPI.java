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
import com.bus.model.PageModel;
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
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String action = req.getParameter("action");
		ObjectMapper mapper = new ObjectMapper();
		TicketService ticketService = new TicketService();
		System.out.println("ticket-api:"+action);
		if(action.equals("getAll"))
		{
			PageModel page = HttpUtil.of(req.getReader()).toModel(PageModel.class);
			String curentPage = req.getParameter("curentPage");
			if (curentPage != null)
				page.setCurentPage(Integer.parseInt(curentPage));
			
			String licensePlate = req.getParameter("licensePlate");
			System.out.println("ticket-api::"+licensePlate);
			String date = req.getParameter("date");
			System.out.println("ticket-api::"+date);
			String type = req.getParameter("type");
			System.out.println("ticket-api::"+type);
			String userName = req.getParameter("userName");
			if(userName == null)
				System.out.println("bang null");
			System.out.println("userName:"+userName);
			if(type.equals("All"))
				mapper.writeValue(resp.getOutputStream(), ticketService.findlimitForFilter(page, licensePlate,date,-1,userName));
			else if(type.equals("UnPay"))
				mapper.writeValue(resp.getOutputStream(), ticketService.findlimitForFilter(page, licensePlate,date,0,userName));
			else if(type.equals("Payed"))
				mapper.writeValue(resp.getOutputStream(), ticketService.findlimitForFilter(page, licensePlate,date,1,userName));
		}
		
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		TicketModel ticket = HttpUtil.of(req.getReader()).toModel(TicketModel.class);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("doput of ticketapi");
		boolean result = new TicketService().updateStatusTicket(ticket.getIdTicket());
		if(result == false)
			mapper.writeValue(resp.getOutputStream(),"0");
		else
			mapper.writeValue(resp.getOutputStream(),"1");

	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		System.out.println("delete from api-ticket");
		TicketModel ticket = HttpUtil.of(req.getReader()).toModel(TicketModel.class);
		System.out.println("idTicket:"+ticket.getIdTicket());
		ObjectMapper mapper = new ObjectMapper();
		boolean x = new TicketService().deleteTicketModel(ticket.getIdTicket());
		System.out.println(x);
		if (x)
			mapper.writeValue(resp.getOutputStream(), "1");
		else
			mapper.writeValue(resp.getOutputStream(), "0");
	}
}
