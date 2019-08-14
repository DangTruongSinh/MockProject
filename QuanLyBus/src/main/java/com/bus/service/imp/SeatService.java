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
	public boolean setStatusSeat(int id, boolean value) {
		// TODO Auto-generated method stub
		return seatDao.setStatusSeat(id, value) == 1 ? true : false;
	}

}
