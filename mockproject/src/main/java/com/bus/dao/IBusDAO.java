package com.bus.dao;

import java.util.List;

import com.bus.model.BusModel;

public interface IBusDAO extends IGenericDAO<BusModel>{
	List<BusModel> findAll();
	//int insertBusModel(BusModel busModel);
	//int updateBusModel(BusModel busModel);
	int deleteBusModel(int id);
	BusModel findOneByLicensePlate(String licensePlace);
	List<BusModel> findAllByPlaceStartToEnd(String start,String end);
	BusModel findOneByIdBus(int id);
	List<BusModel> findAllBus();
}
