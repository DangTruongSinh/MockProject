package com.bus.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.model.BusModel;
import com.bus.model.PageModel;
import com.bus.model.SeatModel;
import com.bus.service.imp.BusService;
import com.bus.service.imp.SeatService;
import com.bus.service.imp.TicketService;
import com.bus.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-seat"})
public class SeatAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String action = req.getParameter("action");
		System.out.println("api:"+action);
		ObjectMapper mapper = new ObjectMapper();
		SeatService accService = new SeatService();
		if(action.equals("getAll"))
		{
			PageModel page = HttpUtil.of(req.getReader()).toModel(PageModel.class);
			page.setTotalPage((int) Math.ceil((float) accService.getTotalSeat() / page.getMaxPageItem()));
			String curentPage = req.getParameter("curentPage");
			if (curentPage != null)
				page.setCurentPage(Integer.parseInt(curentPage));
			
			String licensePlate = req.getParameter("licensePlate");
			System.out.println("api-:"+licensePlate);
			String date = req.getParameter("date");
			System.out.println("api-:"+date);
			String type = req.getParameter("type");
			if(type.equals("All"))
				mapper.writeValue(resp.getOutputStream(), accService.findlimitforFilter(page, licensePlate,date,-1));
			else if(type.equals("Empty"))
				mapper.writeValue(resp.getOutputStream(), accService.findlimitforFilter(page, licensePlate,date,0));
			else if(type.equals("Booked"))
				mapper.writeValue(resp.getOutputStream(), accService.findlimitforFilter(page, licensePlate,date,1));
		}
		
		else if(action.equals("getDate"))
		{
			BusModel bus = HttpUtil.of(req.getReader()).toModel(BusModel.class);
			mapper.writeValue(resp.getOutputStream(), new BusService().findAllDateDepartByLicensePlate(bus.getLicensePlate()));
			
		}
		
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("doput");
		SeatModel seat = HttpUtil.of(req.getReader()).toModel(SeatModel.class);
		SeatService seatService = new SeatService();
		SeatModel seatFromDatabase = seatService.findOneByIdSeat(seat.getIdSeat());
		boolean result = new TicketService().deleteTicketModelByIdSeat(seatFromDatabase.getIdSeat());
		System.out.println(result);
		boolean x = seatService.setStatusSeat(seatFromDatabase.getIdSeat(), !seatFromDatabase.isStatus());
		if(x == true)
			mapper.writeValue(resp.getOutputStream(), "1");
		else
			mapper.writeValue(resp.getOutputStream(), "0");
	}	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete chay");
	}
}
