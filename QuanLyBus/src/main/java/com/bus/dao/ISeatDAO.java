package com.bus.dao;

import java.util.List;

import com.bus.model.SeatModel;

public interface ISeatDAO extends IGenericDAO<SeatModel> {
	int updateSeatModel(SeatModel seatModel);
	List<SeatModel> findAllbyIDBus(int id);
	SeatModel findOneByIdSeat(int id);
	int insertSeatModel(SeatModel seatModel);
	int deleteSeatModel(int id);
}
