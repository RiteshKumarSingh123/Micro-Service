package com.example.demo.model;



import org.springframework.stereotype.Component;

@Component
public class PriorityDays {
	private long dayId;
	private String prirotyDate;
	private String comments;
	private String bgColorCode;
	private String fgColorCode;
	private String activeFlag;
	private int active;
	public long getDayId() {
		return dayId;
	}
	public void setDayId(long dayId) {
		this.dayId = dayId;
	}
	public String getPrirotyDate() {
		return prirotyDate;
	}
	public void setPrirotyDate(String prirotyDate) {
		this.prirotyDate = prirotyDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getBgColorCode() {
		return bgColorCode;
	}
	public void setBgColorCode(String bgColorCode) {
		this.bgColorCode = bgColorCode;
	}
	public String getFgColorCode() {
		return fgColorCode;
	}
	public void setFgColorCode(String fgColorCode) {
		this.fgColorCode = fgColorCode;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "PriorityDays [dayId=" + dayId + ", prirotyDate=" + prirotyDate + ", comments=" + comments
				+ ", bgColorCode=" + bgColorCode + ", fgColorCode=" + fgColorCode + ", activeFlag=" + activeFlag
				+ ", active=" + active + "]";
	}
	
	
	
}
