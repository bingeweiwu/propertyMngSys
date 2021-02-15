package cn.edu.hezeu.pms.Dao;

import java.util.List;

import cn.edu.hezeu.pms.bean.Floor;
import cn.edu.hezeu.pms.bean.User;

public interface FloorDao {
	public List<Floor> getAllFloor();
	public int AddUser(User user,String houseNumber);
	public int removeUser(String id);
	
	
}
