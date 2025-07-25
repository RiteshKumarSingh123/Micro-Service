package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Personnel;
import com.example.demo.model.PriorityDays;
import com.example.demo.model.Schedule;
import com.example.demo.model.Train;
import com.example.demo.model.Worker;
import com.example.demo.model.WorkerOverTime;
import com.example.demo.service.TrainService;

@RestController
@RequestMapping("train")
public class TrainController {
	
	@Autowired
	private TrainService service;

	@PostMapping("saveTrain")
	public Map<String,String> saveTrain(@RequestBody Train train){
		Map<String,String> mapData = service.saveTrain(train);
		return mapData;
	}
	
	@PostMapping("getAllDetailsList")
	public List<Train> getAllDetailsList(@RequestBody Train train){
		List<Train> mapList = service.getAllDetailsList(train);
		return mapList;
	}
	
	@PostMapping("insertTrain")
	public Map<String,String> insertTrain(@RequestBody Train train){
		Map<String,String> mapData = service.insertTrain(train);
		return mapData;
	}
	
	@PostMapping("updateTrain")
	public Map<String,String> updateTrain(@RequestBody Train train){
		Map<String,String> mapData = service.updateTrain(train);
		return mapData;
	}
	
	@GetMapping("deleteTrain")
	public Map<String,String> deleteTrain(@ModelAttribute Train train){
		Map<String,String> mapData = service.deleteTrain(train);
		return mapData;
	}
	
	@GetMapping("getTrainById")
	public Train getTrainById(@RequestParam long id){
		Train trainDataById = service.getTrainById(id);
		return trainDataById;
	}
	
	@GetMapping("/getPriorityDays")
	public ResponseEntity<List<PriorityDays>> getPriorityDays(){
	 
	 return new ResponseEntity<List<PriorityDays>>(service.getPriorityDays(), HttpStatus.OK);
	}
	
	@GetMapping("/getWorkerResourcesList")
	public Personnel getWorkerResourcesList(@ModelAttribute Schedule schedule){
		Personnel workersList = service.getWorkerResourcesList(schedule);
		return workersList;
	}
	
	@GetMapping("/getWorkerOverTimeList")
	public WorkerOverTime getWorkerOverTimeList(@ModelAttribute Schedule schedule){
		WorkerOverTime workersList = service.getWorkerOverTimeList(schedule);
		return workersList;
	}
	
	 @PostMapping("/saveWorkerNotes")
		public Map<String,String> saveWorkerNotes(@RequestBody Worker worker){
			Map<String,String> response = service.saveWorkerNotes(worker);
			return response;
		}
	
}
