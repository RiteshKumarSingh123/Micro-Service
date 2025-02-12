package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Hero {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long companyId;
private String companyFrom;
private String managerName;
private String bestModel;
public long getCompanyId() {
	return companyId;
}
public void setCompanyId(long companyId) {
	this.companyId = companyId;
}
public String getCompanyFrom() {
	return companyFrom;
}
public void setCompanyFrom(String companyFrom) {
	this.companyFrom = companyFrom;
}
public String getManagerName() {
	return managerName;
}
public void setManagerName(String managerName) {
	this.managerName = managerName;
}
public String getBestModel() {
	return bestModel;
}
public void setBestModel(String bestModel) {
	this.bestModel = bestModel;
}

@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
private ShowRoom showRoom;
public ShowRoom getShowRoom() {
	return showRoom;
}
public void setShowRoom(ShowRoom showRoom) {
	this.showRoom = showRoom;
}

}
