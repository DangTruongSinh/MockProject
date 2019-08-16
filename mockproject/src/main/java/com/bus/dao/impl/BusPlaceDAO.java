package com.bus.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bus.dao.IBusPlaceDAO;
import com.bus.mapper.BusPlaceMapper;
import com.bus.model.BusPlaceModel;

public class BusPlaceDAO extends AbstractDAO<BusPlaceModel> implements IBusPlaceDAO{

	@Override
	public List<Integer> findAllIDBusByIdPlace(int idPlace) {
		String sql = "select * from busplace where IdPlace = ?";
		List<BusPlaceModel> list = query(sql, new BusPlaceMapper(), idPlace);
		List<Integer> result = new ArrayList<Integer>();
		for(BusPlaceModel x : list)
		{
			result.add(x.getIdBus());
		}
		return result;
	}

}
