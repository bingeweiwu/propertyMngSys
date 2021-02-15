package cn.edu.hezeu.pms.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hezeu.pms.Dao.UserDao;
import cn.edu.hezeu.pms.Service.UserService;
import cn.edu.hezeu.pms.Service.Impl.UserServiceImpl;
import cn.edu.hezeu.pms.bean.User;
import cn.edu.hezeu.pms.pojo.UserRowMapper;
import cn.edu.hezeu.pms.utils.JdbcUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User checkUser(User user) {
		// �ж��û��Ƿ����
		String sql = "select * from promansys_user where ID=? and password=?";
		Object[] obj = { user.getID(), user.getPassword() };
		Object result = JdbcUtil.getOneObject(sql, obj, new UserRowMapper());
		User ret = (User) result;
		return ret;
	}

	@Override
	public List<User> getAllUser() {
		// ��ȡ�����û����ݣ�����List������ʽ����
		String sql = "select * from promansys_user ";
		// String sql = "select * from ProManSys_User ";
		List<Object> obList = JdbcUtil.getObjects(sql, null,
				new UserRowMapper());
		List<User> userList = new ArrayList();

		for (Object obj : obList) {
			userList.add((User) obj);
		}
		return userList;

	}

	@Override
	public User getOneUser(String id) {
		// ����id��ȡһ���û���Ϣ�����Ż�һ��User����
		String sql = "select * from promansys_user where ID=?";
		Object[] obj = { id };
		Object result = JdbcUtil.getOneObject(sql, obj, new UserRowMapper());
		User user = (User) result;
		// System.out.println("*******************************"+user);
		return user;
	}

	@Override
	public int updateUser(User user) {
		// �����û���Ϣ�����ظ��µ�����

		// System.out.println("Impl�е�ˮ��� �� ="+user.getWater()+"��� = "+user.getElectric());

		String sql = "update promansys_user set username=?,password=?,telephone=?,propertyFee=?,violation=? where ID =? ";
		Object[] obj = { user.getUsername(), user.getPassword(),
				user.getTelephone(), user.getPropertyFee(),
				user.getViolation(), user.getID() };
		return JdbcUtil.executeUpdate(sql, obj);

	}

	@Override
	public int deleteUser(String id) {
		// �����û�IDɾ������
		String sql = "delete from promansys_user where ID = ?";
		Object[] obj = { id };
		return JdbcUtil.executeUpdate(sql, obj);
	}

	@Override
	public int addUser(User user) {
		String sql = "insert into promansys_user (ID,username,password,telephone,propertyFee,violation,houseNumber) values (?,?,?,?,?,?,?)";
		System.out.println("#################");
		System.out.println(user.getUsername());
		Object[] obj = { user.getID(), user.getUsername(), user.getPassword(),
				user.getTelephone(), 0, 0, user.getHouseNumber() };
		return JdbcUtil.executeUpdate(sql, obj);
	}

	@Override
	public int resetPassword(String id) {
		// TODO Auto-generated method stub
		String sql = "update promansys_user set password=? where ID =? ";

		Object[] obj = { String.valueOf(id).substring(12), id };
		return JdbcUtil.executeUpdate(sql, obj);
	}

	@Override
	public int charging(User user, int day) {
		// TODO Auto-generated method stub

		// ������û����,���Ҽ���ʱ���������շ�,�ٸ������ݿ��е�����

		String sql = "update promansys_user set propertyFee=? where ID =? ";
		// Violation violation
		Object[] obj = { user.getPropertyFee() + day, user.getID() };
		return JdbcUtil.executeUpdate(sql, obj);

	}

	@Override
	public int PersonalOperation(User user, int pay) {// propertyFee
		// TODO Auto-generated method stub
		String sql = "update promansys_user set  propertyFee=?,telephone=?,password=? where ID =? ";
		int money = 0;
		if (pay - user.getPropertyFee() >= 0) {
			money = pay;
		}

		
		Object[] obj = { user.getPropertyFee()-money,user.getTelephone(),user.getPassword(), user.getID() };

		return JdbcUtil.executeUpdate(sql, obj);
	}

	@Override
	public int backup(User user) {
		// TODO Auto-generated method stub
		
		System.out.println("##########################");
		System.out.println(user.getUsername());
		
		
		String sql = "insert into backup (ID,username,password,telephone,propertyFee,violation,housenumber) values (?,?,?,?,?,?,?)";
		Object[] obj = { user.getID(), user.getUsername(), user.getPassword(),
				user.getTelephone(), 0, 0, user.getHouseNumber() };
		return JdbcUtil.executeUpdate(sql, obj);
	}

	@Override
	public List<User> getAllRecycle() {
		String sql = "select * from backup ";
		// String sql = "select * from ProManSys_User ";
		List<Object> obList = JdbcUtil.getObjects(sql, null,
				new UserRowMapper());
		List<User> userList = new ArrayList();

		for (Object obj : obList) {
			userList.add((User) obj);
		}
		return userList;
	}

	/*
	 * public static void main(String[] args) { UserDao ud = new UserDaoImpl();
	 * User u = new User(); u.setUsername(1); u.setPassword("1");
	 * ud.checkUser(u); }
	 */

}
