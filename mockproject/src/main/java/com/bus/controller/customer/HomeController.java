package com.bus.controller.customer;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.model.AccountModel;
import com.bus.service.imp.PlaceService;
import com.bus.utils.AccountUtil;

@WebServlet(urlPatterns = "/customer-home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println(action);
		if (action != null) {
			if (action.equals("update")) {
				AccountModel account = (AccountModel) req.getSession().getAttribute("account");
				req.setAttribute("account", account);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/customer-updateprofile.jsp");
				dispatcher.forward(req, resp);
				return;
			}
		}
		// load data to home customer
		AccountModel account = (AccountModel) req.getSession().getAttribute("account");
		System.out.println(account.getIdUser() + " iduser");
		req.setAttribute("account", account);
		Set<String> startPlaces = new PlaceService().findAllPlaceStart();
		Set<String> endPlaces = new PlaceService().findAllPlaceEnd();
		req.setAttribute("startPlaces", startPlaces);
		req.setAttribute("endPlaces", endPlaces);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/customer-home.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println(action + " kaka");
		int idUser = Integer.parseInt(req.getParameter("idUser"));
		
		System.out.println(idUser + " ha");
		if (action.equals("update")) {
			AccountUtil.update(req, resp, 3);
		}	
	}
}