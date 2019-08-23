package com.bus.service.imp;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bus.dao.impl.PlaceDAO;
import com.bus.dao.impl.SeatDAO;
import com.bus.model.PlaceModel;
import com.bus.model.SeatModel;
import com.bus.service.IPlaceService;

public class PlaceService implements IPlaceService{
	PlaceDAO placeDao = new PlaceDAO();
	@Override
	public List<PlaceModel> findAllPlace() {
		return placeDao.findAll();
	}
	@Override
	public Set<String> findAllPlaceStart() {
		List<PlaceModel> places = findAllPlace();
		if(places != null)
		{
			HashSet<String> result = new HashSet<String>();
			for(int i = 0 ;i < places.size();i++)
			{
				String x = places.get(i).getStartPlace();
				result.add(x);
			}
			return result;
		}
		return null;
	}
	@Override
	public Set<String> findAllPlaceEnd() {
		List<PlaceModel> places = findAllPlace();
		if(places != null)
		{
			HashSet<String> result = new HashSet<String>();
			for(int i = 0 ;i < places.size();i++)
			{
				String x = places.get(i).getStopPlace();
				result.add(x);
			}
			return result;
		}
		return null;
	}
	@Override
	public Set<String> findEndPlaceByStartPlace(String start) {
		
		List<PlaceModel> places = placeDao.findAllEndPlaceByStartPlace(start);
		if(places != null)
		{
			Set<String> result = new HashSet<String>();
			for(int i = 0 ;i < places.size();i++)
			{
				String x = places.get(i).getStopPlace();
				result.add(x);
			}
			return result;
		}
		return null;
	}
	
	

	@Override
	public Set<String> findAllDateByPlace(String start,String end) {
		PlaceModel placeModel = placeDao.findPlaceByPlace(start, end);
		int idPlace = placeModel.getIdPlace();
		List<SeatModel> seats = new SeatDAO().findAllByIDPlace(idPlace);
		Set<String> sets =  new HashSet<String>();
		for(SeatModel x : seats)
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			sets.add(format.format(x.getDateStart()));
		}
		return sets;
	}
}
