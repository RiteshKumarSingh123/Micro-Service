package com.example.demo.consumer;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Common;
import com.example.demo.model.ShowRoom;

@FeignClient("SpringBootMicro1")
public interface ShowRoomConsumer {

	@GetMapping("/showRoom/getShowRoomData")
	public Common getShowRoomData();
	
	@PostMapping("/showRoom/saveShowRoom")
	public ShowRoom saveShowRoom( ShowRoom showRoom);
	
	@GetMapping("/showRoom/getAllBikesById")
	public Common getAllBikesById(@RequestParam("companyId") long companyId);
	
	@GetMapping("/showRoom/deleteShowRoomById")
	public Map<String,String> deleteShowRoom(@RequestParam("showRoomId") long showRoomId);
	
	@GetMapping("/showRoom/deleteAllBikeById")
	public Map<String,String> deleteAllBikeById(@RequestParam("companyId") long companyId);
	
	@PostMapping("/showRoom/updateShowRoom")
	public Map<String,String> updateShowRoom(ShowRoom showRoom);
}
