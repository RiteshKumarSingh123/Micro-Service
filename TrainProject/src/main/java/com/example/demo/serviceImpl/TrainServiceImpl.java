package com.example.demo.serviceImpl;

import java.net.URI;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.hibernate.Session;
import org.hibernate.dialect.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.Personnel;
import com.example.demo.model.PriorityDays;
import com.example.demo.model.Schedule;
import com.example.demo.model.Train;
import com.example.demo.model.Worker;
import com.example.demo.model.WorkerOverTime;
import com.example.demo.service.TrainService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TrainServiceImpl implements TrainService {

	@Autowired
	private EntityManager entity;
	
	@Autowired
    private WebClient webClient;
	
	@Override
	public Map<String, String> saveTrain(Train train) {
		
		StoredProcedureQuery query = entity.createStoredProcedureQuery("createtraindetails");
		query.registerStoredProcedureParameter("iTrainName", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iTrainStartsFrm", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iNoOfHaults", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iTrainEnds", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iTrainACCost", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iTrainSleeperCost", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iLocoUsed", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iActive", Integer.class, ParameterMode.IN);
		
		query.setParameter("iTrainName", train.getTrainName());
		query.setParameter("iTrainStartsFrm", train.getTrainStartsFrm());
		query.setParameter("iNoOfHaults", train.getNoOfHaults());
		query.setParameter("iTrainEnds", train.getTrainEnds());
		query.setParameter("iTrainACCost", train.getTrainACCost());
		query.setParameter("iTrainSleeperCost", train.getTrainSleeperCost());
		query.setParameter("iLocoUsed", train.getLocoUsed());
		query.setParameter("iActive", train.getActive());
		
		query.execute();
		
		Map<String, String> res = new HashMap<String,String>();
		res.put("status", "data saved");
		return res;
	}

	@Override
	public List<Train> getAllDetailsList(Train train) {
		
		StoredProcedureQuery query = entity.createStoredProcedureQuery("getAllDetailsList");
		query.registerStoredProcedureParameter("iStationName", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iTrainname", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iActive", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iHigherBound", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iLowerBound", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("oCursor", Void.class, ParameterMode.REF_CURSOR);
		
		query.setParameter("iStationName", train.getStationName());
		query.setParameter("iTrainname", train.getTrainName());
		query.setParameter("iActive", train.getActive());
		query.setParameter("iHigherBound", train.getUpperBound());
		query.setParameter("iLowerBound", train.getLowerBound());
		
		ResultSet rs = null;
		Train setTrain = new Train();
		List<Train> trainList = new ArrayList<Train>();
		rs = (ResultSet) query.getOutputParameterValue("oCursor");
		
		try {
			while(rs.next()) {
				setTrain.setId(rs.getLong("id"));
				setTrain.setCount(rs.getLong("count"));
				setTrain.setActive(rs.getLong("active"));
				setTrain.setStationName(rs.getString("stationname"));
				setTrain.setStationPlatform(rs.getLong("stationplatform"));
				setTrain.setTotalTrainHaults(rs.getLong("totaltrainhaults"));
				setTrain.setNumberOfExpress(rs.getLong("numberofexpress"));
				setTrain.setStationId(rs.getLong("id"));
				setTrain.setTrainName(rs.getString("trainname"));
				setTrain.setTrainStartsFrm(rs.getString("trainstartsfrm"));
				setTrain.setNoOfHaults(rs.getString("noofhaults"));
				setTrain.setTrainEnds(rs.getString("trainends"));
				trainList.add(setTrain);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trainList;
	}
	
	@Override
	public Map<String, String> insertTrain(Train train) {
		
		entity.unwrap(Session.class).doWork(connection -> {
		        try (CallableStatement cs = connection.prepareCall("CALL trainDataSave(?, ?, ?, ?, ?, ?, ?, ? ,?)")) {
		        	cs.setArray(1, connection.createArrayOf("text", train.getIdsArr()));
		        	cs.setArray(2, connection.createArrayOf("text", train.getTrainNameArr()));
		            cs.setArray(3, connection.createArrayOf("text", train.getTrainStartsFrmArr()));
		            cs.setArray(4, connection.createArrayOf("text", train.getNoOfHaultsArr()));
		            cs.setArray(5, connection.createArrayOf("text", train.getTrainEndsArr()));
		            cs.setArray(6, connection.createArrayOf("text", train.getTrainACCostArr()));
		            cs.setArray(7, connection.createArrayOf("text", train.getTrainSleeperCostArr()));
		            cs.setArray(8, connection.createArrayOf("text", train.getLocoUsedArr()));
		            cs.setLong(9, train.getActive()); 

		            cs.execute();
		        }
		    });
		
		Map<String, String> res = new HashMap<String,String>();
		res.put("status", "data saved");
		return res;
	}

	@Override
	public Map<String, String> updateTrain(Train train) {

    entity.unwrap(Session.class).doWork(connection ->{
    try (CallableStatement cs = connection.prepareCall("CALL trainDataSave(?, ?, ?, ?, ?, ?, ?, ? ,?)")) {
    	cs.setArray(1, connection.createArrayOf("text", train.getIdsArr()));
    	cs.setArray(2, connection.createArrayOf("text", train.getTrainNameArr()));
        cs.setArray(3, connection.createArrayOf("text", train.getTrainStartsFrmArr()));
        cs.setArray(4, connection.createArrayOf("text", train.getNoOfHaultsArr()));
        cs.setArray(5, connection.createArrayOf("text", train.getTrainEndsArr()));
        cs.setArray(6, connection.createArrayOf("text", train.getTrainACCostArr()));
        cs.setArray(7, connection.createArrayOf("text", train.getTrainSleeperCostArr()));
        cs.setArray(8, connection.createArrayOf("text", train.getLocoUsedArr()));
        cs.setLong(9, train.getActive()); 

        cs.execute();
    }
    });
		
    Map<String, String> res = new HashMap<String,String>();
	res.put("status", "data updated");
	return res;
	}
	

	@Override
	public Map<String, String> deleteTrain(Train train) {
		
		entity.unwrap(Session.class).doWork(connection ->{
			try(CallableStatement cstmt = connection.prepareCall("CALL trainDelete(?)")){
				cstmt.setArray(1, connection.createArrayOf("text", train.getIdsArr()));
				
				cstmt.execute();
		}
		});
		
		 Map<String, String> res = new HashMap<String,String>();
			res.put("status", "data deleted sucessfully");
			return res;
	}

	@Override
	public Train getTrainById(long id) {
		AtomicReference<Train> setData = new AtomicReference<Train>();
		entity.unwrap(Session.class).doWork(connection ->{
			try(CallableStatement  cstmt = connection.prepareCall("CALL getTrainDataById(?,?)")){
				cstmt.setLong(1, id);
				cstmt.registerOutParameter(2, java.sql.Types.OTHER);
				cstmt.execute();
				ResultSet	rs = (ResultSet) cstmt.getObject(2);
				Train setTrain = new Train();
				while(rs.next()) {
					setTrain.setId(rs.getLong("id"));	
					setTrain.setTrainName(rs.getString("trainName"));
					setTrain.setTrainStartsFrm(rs.getString("trainStartsFrm"));
					setTrain.setNoOfHaults(rs.getString("noOfHaults"));
					setTrain.setTrainEnds(rs.getString("trainEnds"));
					setTrain.setTrainACCost(rs.getString("trainAcCost"));
					setTrain.setTrainSleeperCost(rs.getString("trainSleeperCost"));
					setTrain.setLocoUsed(rs.getString("locoUsed"));
					setTrain.setActive(rs.getLong("active"));
				}
				setData.set(setTrain);
			}
			
		});

		return setData.get();
	}
		
//	@Transactional
//	@Override
//	public Map<String, String> insertTrain(Train train) {
//
//	    entity.unwrap(Session.class).doWork(connection -> {
//	        try (CallableStatement cs = connection.prepareCall("CALL trainDataSave(?, ?, ?, ?, ?, ?, ?, ?)")) {
//
//	            cs.setArray(1, connection.createArrayOf("text", train.getTrainNameArr()));
//	            cs.setArray(2, connection.createArrayOf("text", train.getTrainStartsFrmArr()));
//	            cs.setArray(3, connection.createArrayOf("text", train.getNoOfHaultsArr()));
//	            cs.setArray(4, connection.createArrayOf("text", train.getTrainEndsArr()));
//	            cs.setArray(5, connection.createArrayOf("text", train.getTrainACCostArr()));
//	            cs.setArray(6, connection.createArrayOf("text", train.getTrainSleeperCostArr()));
//	            cs.setArray(7, connection.createArrayOf("text", train.getLocoUsedArr()));
//	            cs.setLong(8, train.getActive());
//	            
//	            cs.execute();
//	        }
//	    });
//
//	    Map<String, String> res = new HashMap<>();
//	    res.put("status", "data saved");
//	    return res;
//	}

//	 public PriorityDays getPriorityDays() {
//	        return webClient.get()
//	                .uri("/position/getPriorityDays")
//	                .retrieve()
//	                .bodyToMono(PriorityDays.class)
//	                .block();
//	    }
	
	public List<PriorityDays> getPriorityDays() {
	    return webClient.get()
	            .uri("/position/getPriorityDays")
	            .retrieve()
	            .bodyToFlux(PriorityDays.class) 
	            .collectList() 
	            .block(); 
	}
	
	public Personnel getWorkerResourcesList(Schedule schedule) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder
	                    .path("/position/getWorkerResourcesList")
	                    .queryParam("eventId", schedule.getEventId())
	                    .queryParam("flag", schedule.getFlag())
	                    .queryParam("filter", schedule.getFilter())
	                    .queryParam("lowerBound", schedule.getLowerBound())
	                    .queryParam("upperBound", schedule.getUpperBound())
	                    .build()
	            )
				.retrieve()
				.bodyToFlux(Personnel.class)
//				.collectList()
				.next()
				.block();
	}
	
//	public WorkerOverTime getWorkerOverTimeList(Schedule schedule) {
//	return webClient.get()
//			.uri(uriBuilder -> uriBuilder
//					.path("position/getWorkerOverTimeList")
//					.queryParam("sDate", schedule.getsDate())
//					.queryParam("eDate", schedule.geteDate())
//					.queryParam("workerId", schedule.getWorkerId())
//					.build()
//					)
//			.retrieve()
//			.bodyToFlux(WorkerOverTime.class)
//			.next()
//			.block();
//	}
	
	public WorkerOverTime getWorkerOverTimeList(Schedule schedule) {
    return	webClient.get()
	.uri(uriBuilder -> uriBuilder
			.path("position/getWorkerOverTimeList")
			.queryParam("sDate", schedule.getsDate())
			.queryParam("eDate", schedule.geteDate())
			.queryParam("workerId", schedule.getWorkerId())
			.build()
			)
	.retrieve()
	.bodyToFlux(WorkerOverTime.class)
	.next()
	.block();
	}
	
	public Map<String,String> saveWorkerNotes(Worker worker){
		return webClient.post()
				.uri("position/saveWorkerNotes")
				.bodyValue(worker)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {})
				.block();
	}
	
}
