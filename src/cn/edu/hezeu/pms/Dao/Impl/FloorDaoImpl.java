package cn.edu.hezeu.pms.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hezeu.pms.Dao.FloorDao;
import cn.edu.hezeu.pms.bean.Floor;
import cn.edu.hezeu.pms.bean.User;
import cn.edu.hezeu.pms.pojo.FloorRowMapper;
import cn.edu.hezeu.pms.utils.JdbcUtil;

public class FloorDaoImpl implements FloorDao {

	@Override
	public List<Floor> getAllFloor() {
		// TODO Auto-generated method stub
		String sql = "select * from floor where ID is null ";
		// String sql = "select * from ProManSys_User ";

		List<Object> obList = JdbcUtil.getObjects(sql, null,
				new FloorRowMapper());
		List<Floor> floorList = new ArrayList();

		for (Object obj : obList) {
			floorList.add((Floor) obj);
		}
		return floorList;
	}

	@Override
	public int AddUser(User user, String houseNumber) {
		// TODO Auto-generated method stub

		String sql = "update floor set ID= ? where houseNumber =? ";

		Object[] obj = { user.getID(), houseNumber };
		return JdbcUtil.executeUpdate(sql, obj);
	}

	@Override
	public int removeUser(String id) {
		// TODO Auto-generated method stub
		
		String sql = "update floor set ID= ? where ID =? ";

		Object[] obj = { null,id };
		return JdbcUtil.executeUpdate(sql, obj);
	}

}
