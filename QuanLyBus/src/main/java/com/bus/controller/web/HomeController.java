package com.bus.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.service.imp.BusService;
@WebServlet(urlPatterns = "/home-web")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<String> list = new BusService().findAllPlace();
		req.setAttribute("place", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/home-web.jsp");
		dispatcher.forward(req, resp);
	}
}
