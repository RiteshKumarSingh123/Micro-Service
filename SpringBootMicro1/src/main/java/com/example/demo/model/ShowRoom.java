package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class ShowRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long showRoomId;
private String showRoomName;
private String showRoomOwnerName;
private String totalEmployess;

public long getShowRoomId() {
	return showRoomId;
}
public void setShowRoomId(long showRoomId) {
	this.showRoomId = showRoomId;
}
public String getShowRoomName() {
	return showRoomName;
}
public void setShowRoomName(String showRoomName) {
	this.showRoomName = showRoomName;
}
public String getShowRoomOwnerName() {
	return showRoomOwnerName;
}
public void setShowRoomOwnerName(String showRoomOwnerName) {
	this.showRoomOwnerName = showRoomOwnerName;
}
public String getTotalEmployess() {
	return totalEmployess;
}
public void setTotalEmployess(String totalEmployess) {
	this.totalEmployess = totalEmployess;
}

@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinColumn(name="show_Room_Id_fk")
private List<Hero> heroList;
public List<Hero> getHeroList() {
	return heroList;
}
public void setHeroList(List<Hero> heroList) {
	this.heroList = heroList;
}

@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinColumn(name="show_Room_Id_fk")
private List<Bajaj> bajajList;
public List<Bajaj> getBajajList() {
	return bajajList;
}
public void setBajajList(List<Bajaj> bajajList) {
	this.bajajList = bajajList;
}

@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinColumn(name="show_Room_Id_fk")
private List<Honda> hondaList;
public List<Honda> getHondaList() {
	return hondaList;
}
public void setHondaList(List<Honda> hondaList) {
	this.hondaList = hondaList;
}

@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinColumn(name="show_Room_Id_fk")
private List<Kawasaki> kawasakiList;
public List<Kawasaki> getKawasakiList() {
	return kawasakiList;
}
public void setKawasakiList(List<Kawasaki> kawasakiList) {
	this.kawasakiList = kawasakiList;
}

@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinColumn(name="show_Room_Id_fk")
private List<Tvs> tvsList;
public List<Tvs> getTvsList() {
	return tvsList;
}
public void setTvsList(List<Tvs> tvsList) {
	this.tvsList = tvsList;
}

@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
 @JoinColumn(name="show_Room_Id_fk")
private List<Yamaha> yamahaList;
public List<Yamaha> getYamahaList() {
	return yamahaList;
}
public void setYamahaList(List<Yamaha> yamahaList) {
	this.yamahaList = yamahaList;
}


}
