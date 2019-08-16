package com.bus.service.imp;

import java.util.List;

import com.bus.dao.impl.SeatDAO;
import com.bus.model.SeatModel;
import com.bus.service.ISeatService;

public class SeatService implements ISeatService{

	SeatDAO seatDao;
	public SeatService()
	{
		seatDao = new SeatDAO();
	}
	@Override
	public SeatModel updateSeatModel(SeatModel seatModel) {
		seatModel.setUserUpdate("userHienTai");
		int result = seatDao.updateSeatModel(seatModel);
		if(result != -1)
			return seatDao.findOneByIdSeat(seatModel.getIdSeat());
		return null;
	}

	@Override
	public List<SeatModel> findAllbyIDBus(int id) {
		return seatDao.findAllbyIDBus(id);
	}

	@Override
	public SeatModel findOneByIdSeat(int id) {
		return seatDao.findOneByIdSeat(id);
	}

	@Override
	public SeatModel insertSeatModel(SeatModel seatModel) {
		seatModel.setUserCreate("userHienTai");
		seatModel.setUserUpdate("userHienTai");
		int id = seatDao.insertSeatModel(seatModel);
		if(id != -1)
		{
			return seatDao.findOneByIdSeat(id);
		}
		return null;
	}

	@Override
	public boolean deleteSeatModel(int id) {
		return seatDao.deleteSeatModel(id) == 1 ? true : false;
	}

	@Override
	public int totalAvailableSeats (int idBus) {
		List<SeatModel> seatModel=seatDao.findAllbyIDBus(idBus);
		int Count=0;
		for(SeatModel x:seatModel)
		{
			if(!x.isStatus()) {
				Count++;
			}
		}
		return Count;
	}
	

	@Override
	public List<SeatModel> findAllAvailableSeatsByIdBus(int idBus) {
		List<SeatModel> seatModel=seatDao.findAllbyIDBus(idBus);
		List<SeatModel> AvailableSeats= new ArrayList<SeatModel>();
		for( SeatModel x:seatModel) {
			if(!x.isStatus()) {
				AvailableSeats.add(x);
			}
		}
		return AvailableSeats;
	}
	@Override
	public boolean updateSeatStatus(int idSeat) {
		SeatModel seatupdate = seatDao.findOneByIdSeat(idSeat);
		if(seatupdate.isStatus()) {
			seatupdate.setStatus(false);
			seatDao.updateSeatModel(seatupdate);
		}else {
			seatupdate.setStatus(true);
			seatDao.updateSeatModel(seatupdate);
		}
		return true;
	}
}
