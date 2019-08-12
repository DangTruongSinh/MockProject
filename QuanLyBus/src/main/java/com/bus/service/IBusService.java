package com.bus.service;

import java.util.List;

import com.bus.model.BusModel;

public interface IBusService {
	List<BusModel> findAll();
	BusModel insertBusModel(BusModel busModel);
	BusModel updateBusModel(BusModel busModel);
	boolean deleteBusModel(int id);
	BusModel findOneByLicensePlate(String licensePlace);
	List<BusModel> findAllByPlaceStartToEnd(String start,String end);
	BusModel findOneByIdBus(int id);
}
