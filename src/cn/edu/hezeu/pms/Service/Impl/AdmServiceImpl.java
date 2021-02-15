package cn.edu.hezeu.pms.Service.Impl;

import java.util.Date;

import cn.edu.hezeu.pms.Dao.AdmDao;
import cn.edu.hezeu.pms.Dao.Impl.AdmDaoImpl;
import cn.edu.hezeu.pms.Service.AdmService;
import cn.edu.hezeu.pms.bean.Administrator;

public class AdmServiceImpl implements AdmService {

	AdmDao ad = new AdmDaoImpl();;;
	
	@Override
	public Administrator checkAdm(Administrator Adm) {
		// TODO Auto-generated method stub
		return ad.checkAdm(Adm);
	}

	@Override
	public Date getFrontDate(){
		// TODO Auto-generated method stub
		return ad.getFrontDate();
	}

	@Override
	public int rightNow(String id) {
		// TODO Auto-generated method stub
		return ad.rightNow(id);
	}

	@Override
	public int changePwd(String name,String pwd) {
		// TODO Auto-generated method stub
		return ad.changePwd(name,pwd);
	}

	@Override
	public String getPwd(String name) {
		// TODO Auto-generated method stub
		return ad.getPwd(name);
	}

}
