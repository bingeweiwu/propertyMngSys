package cn.edu.hezeu.pms.Service.Impl;

import java.util.List;

import cn.edu.hezeu.pms.Dao.FloorDao;
import cn.edu.hezeu.pms.Dao.Impl.FloorDaoImpl;
import cn.edu.hezeu.pms.Service.FloorService;
import cn.edu.hezeu.pms.bean.Floor;
import cn.edu.hezeu.pms.bean.User;

public class FloorServiceImpl implements FloorService {

	FloorDao fd = new FloorDaoImpl();

	@Override
	public List<Floor> getAllFloor() {
		// TODO Auto-generated method stub
		return fd.getAllFloor();
	}

	@Override
	public int AddUser(User user, String houseNumber) {
		// TODO Auto-generated method stub
		return fd.AddUser(user, houseNumber);
	}

	@Override
	public int removeUser(String id) {
		// TODO Auto-generated method stub
		return fd.removeUser(id);
	}

}
