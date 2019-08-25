package com.bus.dao;

import java.util.List;

import com.bus.model.SeatModel;

public interface ISeatDAO extends IGenericDAO<SeatModel> {
	int updateSeatModel(SeatModel seatModel);
	List<SeatModel> findAllbyIDBus(int id);
	List<SeatModel> findlimit(int start,int limit);
	SeatModel findOneByIdSeat(int id);
	int insertSeatModel(SeatModel seatModel);
	int deleteSeatModel(int id);
	int setStatusSeat(int id,boolean value);
	List<SeatModel> findAllbyIDBusAndDate(int id,String date);
	List<SeatModel> findAllbyIDBusAndIDPlaceAndDate(int idBus,int idPlace,String date);
	List<SeatModel> findAllByIDPlace(int idPlace);
	int getTotalSeat();
	List<SeatModel> findlimitBus(int start, int limit, int IDBus,String date,Object ...param);
	SeatModel findSeatByNumberAndType(String number,Object ...param);
}
