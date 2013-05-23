package com.iii.phonservice.model;

//-----------------Phone Model---------------------//
public class Phone {

	/*-----------fields--------------------------*/

	private String brandName;
	private String modelName;
	private String imei;
	private String create_date;
	private String update_date;
	private int status;
	private int flag;

	/*----------Constructor-------------------*/
	public Phone() {
	}	

	public Phone(String brandName, String modelName, String imei,
			String create_date, String update_date, int status, int flag) {
		super();
		this.brandName = brandName;
		this.modelName = modelName;
		this.imei = imei;
		this.create_date = create_date;
		this.update_date = update_date;
		this.status = status;
		this.flag = flag;
	}


	/*----------getter, setter-------------------*/

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
