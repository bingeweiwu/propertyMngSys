package cn.edu.hezeu.pms.Dao;

import java.util.List;

import cn.edu.hezeu.pms.bean.User;

public interface UserDao {
	
	public User checkUser(User user);
	public List<User> getAllUser();
	public List<User> getAllRecycle();
	public User getOneUser(String id);
	public int updateUser(User user);
	public int deleteUser(String id);
	public int addUser(User user);
	public int resetPassword(String id);
	public int charging(User user,int day);
	
	public int PersonalOperation(User user,int pay);
	public  int backup(User user);
}
