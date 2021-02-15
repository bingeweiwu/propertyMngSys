package cn.edu.hezeu.pms.Dao;

import java.util.Date;

import cn.edu.hezeu.pms.bean.Administrator;

public interface AdmDao {
	public Administrator checkAdm(Administrator Adm);
	public Date getFrontDate(); 
	public int rightNow(String id);
	public int changePwd(String name,String pwd);
	public String getPwd(String name);
}
