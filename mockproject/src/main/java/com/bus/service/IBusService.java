package com.bus.service;

import java.util.ArrayList;
import java.util.List;

import com.bus.model.BusModel;

public interface IBusService {
	List<BusModel> findAllByDate(String date);
	BusModel insertBusModel(BusModel busModel);
	BusModel updateBusModel(BusModel busModel);
	boolean deleteBusModel(int id);
	BusModel findOneByLicensePlate(String licensePlace);
	List<BusModel> findAllByPlaceStartToEnd(String start,String end);
	BusModel findOneByIdBus(int id,String start,String end, String date);
	List<BusModel> findAllBusByPlace(String start,String end,String date);
	List<String> findAllLicensePlate();
	ArrayList<String> findAllDateDepartByLicensePlate(String LicensePlate);
}
