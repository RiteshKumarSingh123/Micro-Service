package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Train {
private long id;
private long count;
private String trainName;
private String trainStartsFrm;
private String noOfHaults;
private String trainEnds;
private String trainACCost;
private String trainSleeperCost;
private String locoUsed;
private String[] idsArr;
private String[] trainNameArr;
private String[] trainStartsFrmArr;
private String[] noOfHaultsArr;
private String[] trainEndsArr;
private String[] trainACCostArr;
private String[] trainSleeperCostArr;
private String[] locoUsedArr;
private long active;
private long stationId;
private String stationName;
private long stationPlatform;
private long totalTrainHaults;
private long numberOfExpress;
private long numberOfSuperFast;
private long numberOfLuxuryTrain;
private String staionConnectingWith;
private long upperBound;
private long lowerBound;


public long getCount() {
	return count;
}
public void setCount(long count) {
	this.count = count;
}
public String[] getIdsArr() {
	return idsArr;
}
public void setIdsArr(String[] idsArr) {
	this.idsArr = idsArr;
}
public String[] getTrainNameArr() {
	return trainNameArr;
}
public void setTrainNameArr(String[] trainNameArr) {
	this.trainNameArr = trainNameArr;
}
public String[] getTrainStartsFrmArr() {
	return trainStartsFrmArr;
}
public void setTrainStartsFrmArr(String[] trainStartsFrmArr) {
	this.trainStartsFrmArr = trainStartsFrmArr;
}
public String[] getNoOfHaultsArr() {
	return noOfHaultsArr;
}
public void setNoOfHaultsArr(String[] noOfHaultsArr) {
	this.noOfHaultsArr = noOfHaultsArr;
}
public String[] getTrainEndsArr() {
	return trainEndsArr;
}
public void setTrainEndsArr(String[] trainEndsArr) {
	this.trainEndsArr = trainEndsArr;
}
public String[] getTrainACCostArr() {
	return trainACCostArr;
}
public void setTrainACCostArr(String[] trainACCostArr) {
	this.trainACCostArr = trainACCostArr;
}
public String[] getTrainSleeperCostArr() {
	return trainSleeperCostArr;
}
public void setTrainSleeperCostArr(String[] trainSleeperCostArr) {
	this.trainSleeperCostArr = trainSleeperCostArr;
}
public String[] getLocoUsedArr() {
	return locoUsedArr;
}
public void setLocoUsedArr(String[] locoUsedArr) {
	this.locoUsedArr = locoUsedArr;
}
public long getStationId() {
	return stationId;
}
public void setStationId(long stationId) {
	this.stationId = stationId;
}
public long getUpperBound() {
	return upperBound;
}
public void setUpperBound(long upperBound) {
	this.upperBound = upperBound;
}
public long getLowerBound() {
	return lowerBound;
}
public void setLowerBound(long lowerBound) {
	this.lowerBound = lowerBound;
}
public String getStationName() {
	return stationName;
}
public void setStationName(String stationName) {
	this.stationName = stationName;
}
public long getStationPlatform() {
	return stationPlatform;
}
public void setStationPlatform(long stationPlatform) {
	this.stationPlatform = stationPlatform;
}
public long getTotalTrainHaults() {
	return totalTrainHaults;
}
public void setTotalTrainHaults(long totalTrainHaults) {
	this.totalTrainHaults = totalTrainHaults;
}
public long getNumberOfExpress() {
	return numberOfExpress;
}
public void setNumberOfExpress(long numberOfExpress) {
	this.numberOfExpress = numberOfExpress;
}
public long getNumberOfSuperFast() {
	return numberOfSuperFast;
}
public void setNumberOfSuperFast(long numberOfSuperFast) {
	this.numberOfSuperFast = numberOfSuperFast;
}
public long getNumberOfLuxuryTrain() {
	return numberOfLuxuryTrain;
}
public void setNumberOfLuxuryTrain(long numberOfLuxuryTrain) {
	this.numberOfLuxuryTrain = numberOfLuxuryTrain;
}
public String getStaionConnectingWith() {
	return staionConnectingWith;
}
public void setStaionConnectingWith(String staionConnectingWith) {
	this.staionConnectingWith = staionConnectingWith;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTrainName() {
	return trainName;
}
public void setTrainName(String trainName) {
	this.trainName = trainName;
}
public String getTrainStartsFrm() {
	return trainStartsFrm;
}
public void setTrainStartsFrm(String trainStartsFrm) {
	this.trainStartsFrm = trainStartsFrm;
}
public String getNoOfHaults() {
	return noOfHaults;
}
public void setNoOfHaults(String noOfHaults) {
	this.noOfHaults = noOfHaults;
}
public String getTrainEnds() {
	return trainEnds;
}
public void setTrainEnds(String trainEnds) {
	this.trainEnds = trainEnds;
}
public String getTrainACCost() {
	return trainACCost;
}
public void setTrainACCost(String trainACCost) {
	this.trainACCost = trainACCost;
}
public String getTrainSleeperCost() {
	return trainSleeperCost;
}
public void setTrainSleeperCost(String trainSleeperCost) {
	this.trainSleeperCost = trainSleeperCost;
}
public String getLocoUsed() {
	return locoUsed;
}
public void setLocoUsed(String locoUsed) {
	this.locoUsed = locoUsed;
}
public long getActive() {
	return active;
}
public void setActive(long active) {
	this.active = active;
}
@Override
public String toString() {
	return "Train [id=" + id + ", trainName=" + trainName + ", trainStartsFrm=" + trainStartsFrm + ", noOfHaults="
			+ noOfHaults + ", trainEnds=" + trainEnds + ", trainACCost=" + trainACCost + ", trainSleeperCost="
			+ trainSleeperCost + ", locoUsed=" + locoUsed + ", active=" + active + ", stationId=" + stationId
			+ ", stationName=" + stationName + ", stationPlatform=" + stationPlatform + ", totalTrainHaults="
			+ totalTrainHaults + ", numberOfExpress=" + numberOfExpress + ", numberOfSuperFast=" + numberOfSuperFast
			+ ", numberOfLuxuryTrain=" + numberOfLuxuryTrain + ", staionConnectingWith=" + staionConnectingWith
			+ ", upperBound=" + upperBound + ", lowerBound=" + lowerBound + "]";
}


}
