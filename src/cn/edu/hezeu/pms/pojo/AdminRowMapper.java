package cn.edu.hezeu.pms.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.hezeu.pms.bean.Administrator;
import cn.edu.hezeu.pms.utils.RowMapper;

public class AdminRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		Administrator adm = new Administrator();
		try {
			adm.setName(rs.getString("name"));
			adm.setPassword(rs.getString("password"));
			adm.setDate(rs.getDate("date"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return adm;
	}

}
