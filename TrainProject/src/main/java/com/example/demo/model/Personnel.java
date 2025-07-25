package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Personnel {
	private long resourceId;
	private String resourceName;
	private long Count;
	private long recordCount;
	private List<Personnel>	workerNamesList;
	public long getResourceId() {
		return resourceId;
	}
	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public long getCount() {
		return Count;
	}
	public void setCount(long count) {
		Count = count;
	}
	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
	public List<Personnel> getWorkerNamesList() {
		return workerNamesList;
	}
	public void setWorkerNamesList(List<Personnel> workerNamesList) {
		this.workerNamesList = workerNamesList;
	}
	@Override
	public String toString() {
		return "Personnel [resourceId=" + resourceId + ", resourceName=" + resourceName + ", Count=" + Count
				+ ", recordCount=" + recordCount + ", workerNamesList=" + workerNamesList + "]";
	}

	
}
