package cn.edu.hezeu.pms.Service.Impl;

import java.util.List;

import cn.edu.hezeu.pms.Dao.UserDao;
import cn.edu.hezeu.pms.Dao.Impl.UserDaoImpl;
import cn.edu.hezeu.pms.Service.UserService;
import cn.edu.hezeu.pms.bean.User;

public class UserServiceImpl implements UserService {
	UserDao ud = new UserDaoImpl();

	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return ud.checkUser(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		
		return ud.getAllUser();
	}

	@Override
	public User getOneUser(String id) {
		// TODO Auto-generated method stub
		return ud.getOneUser(id);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		
		
		return ud.updateUser(user);
	}

	@Override
	public int deleteUser(String id) {
		// TODO Auto-generated method stub
		return ud.deleteUser(id);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return ud.addUser(user);
	}

	@Override
	public int resetPassword(String id) {
		// TODO Auto-generated method stub
		return ud.resetPassword(id);
	}

	@Override
	public int charging(User user,int day) {
		// TODO Auto-generated method stub
		return ud.charging(user,day);
	}

	@Override
	public int PersonalOperation(User user, int pay) {
		// TODO Auto-generated method stub
		return ud.PersonalOperation(user, pay);
	}

	@Override
	public int backup(User user) {
		// TODO Auto-generated method stub
		
		return ud.backup(user);
	}

	@Override
	public List<User> getAllRecycle() {
		// TODO Auto-generated method stub
		return ud.getAllRecycle();
	}

	

}
