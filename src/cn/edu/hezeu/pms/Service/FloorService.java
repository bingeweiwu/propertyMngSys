package cn.edu.hezeu.pms.Service;

import java.util.List;

import cn.edu.hezeu.pms.bean.Floor;
import cn.edu.hezeu.pms.bean.User;

public interface FloorService {
	
	public List<Floor> getAllFloor();
	public int AddUser(User user,String houseNumber);
	public int removeUser(String id);
	
	
}
