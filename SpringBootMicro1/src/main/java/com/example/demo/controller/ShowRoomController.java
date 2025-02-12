package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Common;
import com.example.demo.model.ShowRoom;
import com.example.demo.showRoomInterface.ShowRoomInterface;

@RestController
@RequestMapping("showRoom")
public class ShowRoomController {
	
	@Autowired
	private ShowRoomInterface showRoomInterface;

	@PostMapping("/saveShowRoom")
	public ShowRoom saveShowRoom(@RequestBody ShowRoom showRoom) {
		ShowRoom saveShowRoom = showRoomInterface.saveShowRoom(showRoom);
		return saveShowRoom;
	}
	
	@PostMapping("/updateShowRoom")
	public Map<String,String> updateShowRoom(@RequestBody ShowRoom showRoom) {
		Map<String,String> updateShowRoom = showRoomInterface.updateShowRoom(showRoom);
		return updateShowRoom;
	}
	
	
	@GetMapping("/getShowRoomList")
	public List<ShowRoom> getShowRoomList(){
		List<ShowRoom> showRoomListData = showRoomInterface.getShowRoomList();
		return showRoomListData;
	}
	
	@GetMapping("/getAllList")
	public List<Common> getAllList(){
		List<Common> allList = showRoomInterface.getAllList();
		return allList;
	}
	
	@GetMapping("/getShowRoomData")
	public Common getShowRoomData() {
		Common dataList = showRoomInterface.getShowRoomData();
		return dataList;
	}
	
	@GetMapping("/getShowRoomById")
	public ShowRoom getShowRoomById(@RequestParam("showRoomId") long showRoomId) {
		ShowRoom showRoomData = showRoomInterface.getShowRoomById(showRoomId);
		return showRoomData;
	}
	
	@GetMapping("/getAllBikesById")
	public Common getAllBikesById(@RequestParam("companyId") long companyId) {
		Common commonData = showRoomInterface.getAllBikesById(companyId);
		return commonData;
	}
	
	@GetMapping("/deleteShowRoomById")
	public Map<String,String> deleteShowRoom(@RequestParam("showRoomId") long showRoomId){
		Map<String,String> deletedResponse = showRoomInterface.deleteShowRoom(showRoomId);
		return deletedResponse;
	}
	
	@GetMapping("/deleteAllBikeById")
	public Map<String,String> deleteAllBikeById(@RequestParam("companyId") long companyId){
		Map<String,String> deletedResponse = showRoomInterface.deleteAllBikeById(companyId);
		return deletedResponse;
	}
	
	
}
