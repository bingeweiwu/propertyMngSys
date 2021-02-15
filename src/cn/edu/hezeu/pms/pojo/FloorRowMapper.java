package cn.edu.hezeu.pms.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.hezeu.pms.bean.Floor;
import cn.edu.hezeu.pms.bean.User;
import cn.edu.hezeu.pms.utils.RowMapper;

public class FloorRowMapper  implements RowMapper {

	
	public Object mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		Floor floor = new Floor();
		try {
			floor.setID(rs.getLong("ID"));
			floor.setHouseNumber(rs.getString("houseNumber"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return floor;
	}
}
	

