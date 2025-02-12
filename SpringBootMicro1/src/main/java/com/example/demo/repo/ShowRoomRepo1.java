package com.example.demo.repo;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ShowRoom;

public interface ShowRoomRepo1 extends JpaRepository<ShowRoom, Serializable> {
	
}
