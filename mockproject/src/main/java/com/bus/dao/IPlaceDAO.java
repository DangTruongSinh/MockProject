package com.bus.dao;

import java.util.List;

import com.bus.model.PlaceModel;

public interface IPlaceDAO extends IGenericDAO<PlaceModel> {
	List<PlaceModel> findAll();
	PlaceModel findPlaceModel(int id);
	PlaceModel findPlaceByPlace(String start,String end);
	List<PlaceModel> findAllEndPlaceByStartPlace(String start);
}
