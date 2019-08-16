package com.bus.dao;

import java.util.List;

import com.bus.model.BusPlaceModel;

public interface IBusPlaceDAO  extends IGenericDAO<BusPlaceModel>{
	List<Integer> findAllIDBusByIdPlace(int idPlace);
}
