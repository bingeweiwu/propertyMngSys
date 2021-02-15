package cn.edu.hezeu.pms.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.hezeu.pms.bean.User;
import cn.edu.hezeu.pms.utils.RowMapper;

public class UserRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			user.setID(rs.getString("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setTelephone(rs.getLong("telephone"));
//			propertyFee  Default
			user.setPropertyFee(rs.getInt("propertyFee"));
			user.setViolation(rs.getInt("violation"));
			user.setHouseNumber(rs.getString("housenumber"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
