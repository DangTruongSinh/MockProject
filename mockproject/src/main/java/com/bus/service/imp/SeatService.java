package com.bus.service.imp;

import java.util.List;

import com.bus.dao.impl.BusDAO;
import com.bus.dao.impl.SeatDAO;
import com.bus.model.BusModel;
import com.bus.model.PageModel;
import com.bus.model.SeatModel;
import com.bus.service.ISeatService;

public class SeatService implements ISeatService{

	SeatDAO seatDao;
	BusDAO busDAO;
	public SeatService()
	{
		seatDao = new SeatDAO();
		busDAO=new BusDAO();
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
		return setBusforSeat(seatDao.findAllbyIDBus(id));
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
	@Override
	public int getTotalSeat() {
		return seatDao.getTotalSeat();
	}
	@Override
	public List<SeatModel> findlimit(PageModel page) {
		int start = (page.getCurentPage()-1)*page.getMaxPageItem();
		int limit = page.getMaxPageItem();
		List<SeatModel> list=seatDao.findlimit(start, limit);
		return  setBusforSeat(list);
	}
	@Override
	public List<SeatModel> setBusforSeat(List<SeatModel> list)
	{
		
		for(SeatModel x:list)
		{
			BusModel busModel=busDAO.findOneByIdBus(x.getIdBus());
			x.setBus(busModel);
		}
		return list;
	}
	@Override
	public List<SeatModel> findAllbylicensePlate(String licensePlate) {
		BusModel busModel=busDAO.findOneByLicensePlate(licensePlate);
		List<SeatModel> list=setBusforSeat(seatDao.findAllbyIDBus(busModel.getIdBus()));		
		return setBusforSeat(list);
	}
	
	public List<SeatModel> findlimitforFilter(PageModel page,String licensePlate,String date,int type) {
		int start = (page.getCurentPage()-1)*page.getMaxPageItem();
		int limit = page.getMaxPageItem();
		BusModel bus = new BusDAO().findOneByLicensePlate(licensePlate);
		List<SeatModel> list2;
		if(type != -1)
			list2 = new SeatDAO().findlimitBus(start, limit, bus.getIdBus(),date,type);
		else
			list2 = new SeatDAO().findlimitBus(start, limit, bus.getIdBus(),date);
		return  setBusforSeat(list2);
	}
}
