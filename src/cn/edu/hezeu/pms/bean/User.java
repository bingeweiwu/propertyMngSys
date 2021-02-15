package cn.edu.hezeu.pms.bean;

public class User {

	public String ID;
	public String username;
	public String password;
	public String houseNumber;
	public long telephone;
	public int propertyFee;
	public int violation;
//	propertyFee  Default

	public int getPropertyFee() {
		return propertyFee;
	}

	public int getViolation() {
		return violation;
	}



	public void setViolation(int violation) {
		this.violation = violation;
	}



	public void setPropertyFee(int propertyFee) {
		this.propertyFee = propertyFee;
	}

	

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

}
