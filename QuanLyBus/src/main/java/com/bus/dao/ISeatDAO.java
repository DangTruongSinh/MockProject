package com.bus.dao;

import java.util.List;

import com.bus.model.SeatModel;

public interface ISeatDAO extends IGenericDAO<SeatModel> {
	List<SeatModel> findAll();
	int updateSeatModel(SeatModel seatModel);
	List<SeatModel> findbyIDBus(int x);
}
