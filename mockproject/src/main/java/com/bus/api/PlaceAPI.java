package com.bus.api;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.bus.model.Place;
import com.bus.service.imp.PlaceService;
import com.bus.utils.HttpUtil;

@WebServlet(urlPatterns = {"/home-place"})
public class PlaceAPI  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Place place = HttpUtil.of(req.getReader()).toModel(Place.class);
		ObjectMapper mapper = new ObjectMapper();
		Set<String> set = new PlaceService().findEndPlaceByStartPlace(place.getPlace());
		mapper.writeValue(resp.getOutputStream(), set);
		//System.out.println(place.getPlace());
	}
}
