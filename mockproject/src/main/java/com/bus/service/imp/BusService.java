package com.bus.service.imp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bus.dao.impl.BusDAO;
import com.bus.dao.impl.BusPlaceDAO;
import com.bus.dao.impl.PlaceDAO;
import com.bus.dao.impl.SeatDAO;
import com.bus.model.BusModel;
import com.bus.model.PlaceModel;
import com.bus.model.SeatModel;
import com.bus.service.IBusService;

public class BusService implements IBusService {
	BusDAO busDao;

	public BusService() {
		busDao = new BusDAO();
	}

	@Override
	public List<BusModel> findAllByDate(String date) {
		List<BusModel> list = busDao.findAll();
		SeatDAO seatDao = new SeatDAO();
		if (list != null) {
			for (BusModel x : list) {
				List<SeatModel> listSeat = seatDao.findAllbyIDBus(x.getIdBus());
				List<SeatModel> resultSeat = new ArrayList<SeatModel>();
				for (SeatModel seat : listSeat) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					String date2 = format.format(seat.getDateStart());
					if (date.equals(date2))
						resultSeat.add(seat);
				}
				x.setListSeats(resultSeat);
			}
		}
		return list;
	}

	@Override
	public BusModel insertBusModel(BusModel busModel) {
		//
		busModel.setUserCreate("userHienTai");
		busModel.setUserUpdate("userHienTai");
		/*
		 * int id = busDao.insertBusModel(busModel); if(id != -1) { return
		 * busDao.findOneByIdBus(id); }
		 */
		return null;
	}

	@Override
	public BusModel updateBusModel(BusModel busModel) {
		busModel.setUserUpdate("userHienTai");
		// int result = busDao.updateBusModel(busModel);
		// if(result != -1)
		// return busDao.findOneByIdBus(busModel.getIdBus());
		return null;
	}

	@Override
	public boolean deleteBusModel(int id) {
		return busDao.deleteBusModel(id) == 1 ? true : false;
	}

	@Override
	public BusModel findOneByLicensePlate(String licensePlace) {
		return busDao.findOneByLicensePlate(licensePlace);
	}

	@Override
	public List<BusModel> findAllByPlaceStartToEnd(String start, String end) {
		return busDao.findAllByPlaceStartToEnd(start, end);
	}

	@Override
	public BusModel findOneByIdBus(int id,String start,String end, String date) {
		List<BusModel> list = findAllBusByPlace(start, end, date);
		for(BusModel x : list)
		{
			if(x.getIdBus()  == id)
				return x;
		}
		return null;
	}

	@Override
	public List<BusModel> findAllBusByPlace(String start, String end, String date) {
		PlaceModel place = new PlaceDAO().findPlaceByPlace(start, end);
		if(place != null)
		{
			List<Integer> listIdBus = new BusPlaceDAO().findAllIDBusByIdPlace(place.getIdPlace());
			List<BusModel> listResult = new ArrayList<BusModel>();
			for(Integer x : listIdBus)
			{
				BusModel bus = new BusDAO().findOneByIdBus(x);
				List<SeatModel> listSeat = new SeatDAO().findAllbyIDBusAndIDPlaceAndDate(x, place.getIdPlace(), date);
				if(listSeat.size() > 0)
				{
					bus.setListSeats(listSeat);
					bus.setPlace(place);
					listResult.add(bus);
				}
				
			}
			return listResult;
		}
		
		return null;
	}
	
}
