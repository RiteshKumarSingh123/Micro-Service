package com.example.demo.repo;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.ShowRoom;

public interface ShowRoomRepo extends CrudRepository<ShowRoom, Serializable> {
	



}
