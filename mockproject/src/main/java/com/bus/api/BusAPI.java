package com.bus.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.model.BusModel;
import com.bus.service.imp.BusService;
import com.bus.utils.HttpUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = "/api-bus")
public class BusAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		
	//	List<BusModel> list = busService.findAll();
	//	mapper.writeValue(resp.getOutputStream(), list);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		BusModel busModel = HttpUtil.of(req.getReader()).toModel(BusModel.class);
		BusService busService = new BusService();
		BusModel result = busService.insertBusModel(busModel);
		mapper.writeValue(resp.getOutputStream(), result);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		BusModel busModel = HttpUtil.of(req.getReader()).toModel(BusModel.class);
		BusService busService = new BusService();
		boolean result = busService.deleteBusModel(busModel.getIdBus());
		JsonNode actualObj  = mapper.readTree("{\"result\":"+result+"}");
		mapper.writeValue(resp.getOutputStream(), actualObj);;
	}
}
