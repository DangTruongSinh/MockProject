package com.bus.controller.web;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.service.imp.PlaceService;
@WebServlet(urlPatterns = "/home-web")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Set<String> startPlaces = new PlaceService().findAllPlaceStart();
		Set<String> endPlaces = new PlaceService().findAllPlaceEnd();
		req.setAttribute("startPlaces", startPlaces);
		req.setAttribute("endPlaces", endPlaces);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/home-web.jsp");
		dispatcher.forward(req, resp);
	}
}
