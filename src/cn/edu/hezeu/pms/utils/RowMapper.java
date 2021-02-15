package cn.edu.hezeu.pms.utils;

import java.sql.ResultSet;

public interface RowMapper {
	public Object mapRow(ResultSet rs);
}
