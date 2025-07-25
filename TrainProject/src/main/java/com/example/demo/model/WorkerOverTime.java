package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class WorkerOverTime {
	private String startDate;
	private String endDate;
	private String workerName;
	private long workerId;
	private String scheduleHours;
	private String overTimeHrs;
	private String pendingHours;
	private  List<WorkerOverTime>	workerOverTimeList;
	private  List<WorkerOverTime> otWorkersList;
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public long getWorkerId() {
		return workerId;
	}
	public void setWorkerId(long workerId) {
		this.workerId = workerId;
	}
	public String getScheduleHours() {
		return scheduleHours;
	}
	public void setScheduleHours(String scheduleHours) {
		this.scheduleHours = scheduleHours;
	}
	public String getOverTimeHrs() {
		return overTimeHrs;
	}
	public void setOverTimeHrs(String overTimeHrs) {
		this.overTimeHrs = overTimeHrs;
	}
	public String getPendingHours() {
		return pendingHours;
	}
	public void setPendingHours(String pendingHours) {
		this.pendingHours = pendingHours;
	}
	public List<WorkerOverTime> getWorkerOverTimeList() {
		return workerOverTimeList;
	}
	public void setWorkerOverTimeList(List<WorkerOverTime> workerOverTimeList) {
		this.workerOverTimeList = workerOverTimeList;
	}
	public List<WorkerOverTime> getOtWorkersList() {
		return otWorkersList;
	}
	public void setOtWorkersList(List<WorkerOverTime> otWorkersList) {
		this.otWorkersList = otWorkersList;
	}
	@Override
	public String toString() {
		return "WorkerOverTime [startDate=" + startDate + ", endDate=" + endDate + ", workerName=" + workerName
				+ ", workerId=" + workerId + ", scheduleHours=" + scheduleHours + ", overTimeHrs=" + overTimeHrs
				+ ", pendingHours=" + pendingHours + ", workerOverTimeList=" + workerOverTimeList + ", otWorkersList="
				+ otWorkersList + "]";
	}

	
}
