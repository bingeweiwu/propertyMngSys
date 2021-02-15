package cn.edu.hezeu.pms.Dao.Impl;

import java.util.Date;

import cn.edu.hezeu.pms.Dao.AdmDao;
import cn.edu.hezeu.pms.bean.Administrator;
import cn.edu.hezeu.pms.pojo.AdminRowMapper;
import cn.edu.hezeu.pms.utils.JdbcUtil;

public class AdmDaoImpl implements AdmDao {

	@Override
	public Administrator checkAdm(Administrator Adm) {
		// TODO Auto-generated method stub
		String sql = "select * from administrator where name=? and password=?";
		Object[] obj = { Adm.getName(), Adm.getPassword() };
		Object result = JdbcUtil.getOneObject(sql, obj, new AdminRowMapper());
		Administrator ret = (Administrator) result;
		return ret;
	}

	@Override
	public Date getFrontDate() {
		// TODO Auto-generated method stub
		Date date = new Date();
		
		String sql = "select * from Administrator";
		Object result = JdbcUtil.getOneObject(sql, null, new AdminRowMapper());
		Administrator adm = (Administrator) result;
		// System.out.println("*******************************"+user);
		
		return adm.getDate();
	}
	
	

	@Override
	public int rightNow(String id) {
		// TODO Auto-generated method stub

		String sql = "update administrator set date=? where name =? ";

		Date date = new Date();
		Object[] obj = { date, id };
		return JdbcUtil.executeUpdate(sql, obj);
		
		
		
	}

	@Override
	public int changePwd(String name,String pwd) {
		// TODO Auto-generated method stub
		String sql = "update administrator set password=? where name =? ";
		Object[] obj = { pwd ,name };
		return JdbcUtil.executeUpdate(sql, obj);
		
	}

	@Override
	public String getPwd(String name) {
		// TODO Auto-generated method stub
		
		String sql = "select * from administrator where name = ?";
		Object[] obj = { name };
		Object result = JdbcUtil.getOneObject(sql, obj, new AdminRowMapper());
		
		Administrator adm = (Administrator) result;
		return adm.getPassword();
		
	}
}
