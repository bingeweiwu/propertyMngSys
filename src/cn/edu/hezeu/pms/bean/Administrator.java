package cn.edu.hezeu.pms.bean;

import java.util.Date;

public class Administrator {
	public String name;
	public String password;
	public Date date;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate() {
		
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
		
	}
	

}
