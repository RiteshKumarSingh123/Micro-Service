package com.example.demo.showRoomInterface;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Common;
import com.example.demo.model.ShowRoom;

public interface ShowRoomInterface {
	
	public ShowRoom saveShowRoom(ShowRoom showRoom);
	
	public Map<String,String> updateShowRoom(ShowRoom showRoom);
	
	public List<ShowRoom> getShowRoomList(); 
	
	public List<Common> getAllList();
	
	public Common getShowRoomData();
	
    public ShowRoom getShowRoomById(long showRoomId);
    
    public Common getAllBikesById(long companyId); 
    
    public Map<String,String> deleteShowRoom(long showRoomId);
    
    public Map<String,String> deleteAllBikeById(long companyId);
}
