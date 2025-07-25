package com.example.demo.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.demo.model.Personnel;
import com.example.demo.model.PriorityDays;
import com.example.demo.model.Schedule;
import com.example.demo.model.Train;
import com.example.demo.model.Worker;
import com.example.demo.model.WorkerOverTime;


@Service
public interface TrainService {

	public Map<String,String> saveTrain(Train train);
	
	public List<Train> getAllDetailsList(Train train);
	
	public Map<String,String> insertTrain(Train train);
	
	public Map<String,String> updateTrain(Train train);
	
	public Map<String,String> deleteTrain(Train train);
	
	public Train getTrainById(long id);
	
	public List<PriorityDays> getPriorityDays();
	
	public Personnel getWorkerResourcesList(Schedule schedule);
	
	public WorkerOverTime getWorkerOverTimeList(Schedule schedule);

	public Map<String,String> saveWorkerNotes(Worker worker);
}
