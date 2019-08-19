package com.bus.service;

import java.util.List;
import java.util.Set;

import com.bus.model.PlaceModel;

public interface IPlaceService {
	List<PlaceModel> findAllPlace();
	Set<String> findAllPlaceStart();
	Set<String> findAllPlaceEnd();
	Set<String> findEndPlaceByStartPlace(String start);
}
