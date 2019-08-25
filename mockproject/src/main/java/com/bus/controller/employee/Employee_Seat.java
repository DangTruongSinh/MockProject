package com.bus.controller.employee;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.model.PageModel;
import com.bus.model.SeatModel;
import com.bus.service.imp.BusService;
import com.bus.service.imp.SeatService;

@WebServlet(urlPatterns = "/employee-seat")
public class Employee_Seat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println("action:"+action);
		String DATESTART=req.getParameter("DATESTART");
		String SEATNUMBER=req.getParameter("SEATNUMBER");
		String licensePlate=req.getParameter("licensePlate");
		SeatService seatService =new SeatService();
		req.setAttribute("search", 0);
		if (action == null || licensePlate.equals("")) {
			PageModel page = new PageModel();
			page.setTotalPage((int) Math.ceil((float) seatService.getTotalSeat()/ page.getMaxPageItem()));
			String curentPage = req.getParameter("curentPage");
			if (curentPage != null)
				page.setCurentPage(Integer.parseInt(curentPage));
			BusService busService = new BusService();
			List<String> listLicese =busService.findAllLicensePlate();
			req.setAttribute("dateDeparts", busService.findAllDateDepartByLicensePlate(listLicese.get(0)));
			req.setAttribute("licensePlates", listLicese);
			req.setAttribute("seats", seatService.findlimit(page));
			req.setAttribute("pageModel", page);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/view/employee-seat.jsp");
			rDispatcher.forward(req, resp);
			
		}
		

		else if(action.equals("redirect2SeatURL"))
		{
			List<SeatModel> list=seatService.findAllbylicensePlate(licensePlate);
			List<SeatModel> list2=new ArrayList<SeatModel>();
			for(SeatModel x:list)
			{ 
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String date = format.format(x.getDateStart());
				if(x.getName().equals(SEATNUMBER)&&date.equals(DATESTART))
				{
					list2.add(x);
				}
			}
			req.setAttribute("seats",list2);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/view/employee-seat.jsp");
			rDispatcher.forward(req, resp);
		}
	}
}
