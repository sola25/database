package database;

import java.sql.Date;


public class Order {
	private String proName;
	private Integer proNum;
	private Integer ordId;
	private String ordName ;
	private Date ordTime;
	private String ordState;
	
	public Integer getOrdId() {
		return ordId;
	}
	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}
	public String getOrdName() {
		return ordName;
	}
	public void setOrdName(String ordName) {
		this.ordName = ordName;
	}
	public Date getOrdTime() {
		return ordTime;
	}
	public void setOrdTime(Date ordTime) {
		this.ordTime = ordTime;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Integer getProNum() {
		return proNum;
	}
	public void setProNum(Integer proNum) {
		this.proNum = proNum;
	}
	public String getOrdState() {
		return ordState;
	}
	public void setOrdState(String ordState) {
		this.ordState = ordState;
	}
}
