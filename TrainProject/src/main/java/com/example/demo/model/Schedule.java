package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Schedule {
	private long eventId;
	private String flag;
	private String filter;
	private long lowerBound;
	private long upperBound;
	private String sDate;
	private String eDate;
	private long workerId;
	private long flagSet;
	private String personalTypeId;
    private long userId;
    private Long copyEventId;
    private long resourceId;
    private long txtSchedId;
    private String resourceName;
    private String txtHours;
	private long txtPersTypeId;
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public long getLowerBound() {
		return lowerBound;
	}
	public void setLowerBound(long lowerBound) {
		this.lowerBound = lowerBound;
	}
	public long getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(long upperBound) {
		this.upperBound = upperBound;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public String geteDate() {
		return eDate;
	}
	public void seteDate(String eDate) {
		this.eDate = eDate;
	}
	public long getWorkerId() {
		return workerId;
	}
	public void setWorkerId(long workerId) {
		this.workerId = workerId;
	}
	public long getFlagSet() {
		return flagSet;
	}
	public void setFlagSet(long flagSet) {
		this.flagSet = flagSet;
	}
	public String getPersonalTypeId() {
		return personalTypeId;
	}
	public void setPersonalTypeId(String personalTypeId) {
		this.personalTypeId = personalTypeId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Long getCopyEventId() {
		return copyEventId;
	}
	public void setCopyEventId(Long copyEventId) {
		this.copyEventId = copyEventId;
	}
	public long getResourceId() {
		return resourceId;
	}
	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}
	public long getTxtSchedId() {
		return txtSchedId;
	}
	public void setTxtSchedId(long txtSchedId) {
		this.txtSchedId = txtSchedId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getTxtHours() {
		return txtHours;
	}
	public void setTxtHours(String txtHours) {
		this.txtHours = txtHours;
	}
	public long getTxtPersTypeId() {
		return txtPersTypeId;
	}
	public void setTxtPersTypeId(long txtPersTypeId) {
		this.txtPersTypeId = txtPersTypeId;
	}
	@Override
	public String toString() {
		return "Schedule [eventId=" + eventId + ", flag=" + flag + ", filter=" + filter + ", lowerBound=" + lowerBound
				+ ", upperBound=" + upperBound + ", sDate=" + sDate + ", eDate=" + eDate + ", workerId=" + workerId
				+ ", flagSet=" + flagSet + ", personalTypeId=" + personalTypeId + ", userId=" + userId
				+ ", copyEventId=" + copyEventId + ", resourceId=" + resourceId + ", txtSchedId=" + txtSchedId
				+ ", resourceName=" + resourceName + ", txtHours=" + txtHours + ", txtPersTypeId=" + txtPersTypeId
				+ "]";
	}
	
	
}
