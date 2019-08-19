package com.bus.service;

import java.util.List;

import com.bus.model.PageModel;
import com.bus.model.SeatModel;

public interface ISeatService {
	SeatModel updateSeatModel(SeatModel seatModel);
	List<SeatModel> findAllbyIDBus(int id);
	SeatModel findOneByIdSeat(int id);
	SeatModel insertSeatModel(SeatModel seatModel);
	boolean deleteSeatModel(int id);
	boolean setStatusSeat(int id,boolean value);
	int getTotalSeat();
	List<SeatModel> findlimit(PageModel page);
}
