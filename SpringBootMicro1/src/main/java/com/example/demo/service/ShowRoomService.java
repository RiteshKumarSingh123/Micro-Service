package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Bajaj;
import com.example.demo.model.Common;
import com.example.demo.model.Hero;
import com.example.demo.model.Honda;
import com.example.demo.model.Kawasaki;
import com.example.demo.model.ShowRoom;
import com.example.demo.model.Tvs;
import com.example.demo.model.Yamaha;
import com.example.demo.repo.ShowRoomRepo;
import com.example.demo.repo.ShowRoomRepo1;
import com.example.demo.showRoomInterface.ShowRoomInterface;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class ShowRoomService implements ShowRoomInterface{
	
	@Autowired
	private ShowRoomRepo showRoomRepo;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private ShowRoomRepo1 showRoomRepo1;

	@Override
	public ShowRoom saveShowRoom(ShowRoom showRoom) {
		ShowRoom saveData = showRoomRepo.save(showRoom);
		return saveData;
	}

	@Override
	public List<ShowRoom> getShowRoomList() {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getShowRoom");
		query.registerStoredProcedureParameter("oCursor",Void.class, ParameterMode.REF_CURSOR);
		query.execute();
		ResultSet rs = null;
		
		rs = (ResultSet) query.getOutputParameterValue("oCursor");
		List<ShowRoom> showRoomList = new ArrayList<ShowRoom>();
		try {
			while(rs.next()) {
			ShowRoom showRoom = new ShowRoom();
			showRoom.setShowRoomId(rs.getLong("show_room_id"));
			showRoom.setShowRoomName(rs.getString("show_room_name"));
			showRoom.setShowRoomOwnerName(rs.getString("show_room_owner_name"));
			showRoom.setTotalEmployess(rs.getString("total_employess"));
			showRoomList.add(showRoom);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return showRoomList;
	}

	@Override
	public List<Common> getAllList() {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getallcompaniesdata");
		query.registerStoredProcedureParameter("oCursor", Void.class, ParameterMode.REF_CURSOR);
		query.execute();
		ResultSet rs = (ResultSet) query.getOutputParameterValue("oCursor");
		List<Common> commonList = new ArrayList<Common>();
		try {
			while(rs.next()) {
			Common commonData = new Common();
			commonData.sethBestModel(rs.getString("best_model"));
			commonData.sethCompanyFrom(rs.getString("company_from"));
			commonData.sethManagerName(rs.getString("manager_name"));
			commonData.setHoBestModel(rs.getString("best_model"));
			commonData.setHoCompanyFrom(rs.getString("company_from"));
			commonData.setHoManagerName(rs.getString("manager_name"));
			commonData.setyBestModel(rs.getString("best_model"));
			commonData.setyCompanyFrom(rs.getString("company_from"));
			commonData.setyManagerName(rs.getString("manager_name"));
			commonData.setkBestModel(rs.getString("best_model"));
			commonData.setkCompanyFrom(rs.getString("company_from"));
			commonData.setkManagerName(rs.getString("manager_name"));
			commonData.setbBestModel(rs.getString("best_model"));
			commonData.setbCompanyFrom(rs.getString("company_from"));
			commonData.setbManagerName(rs.getString("manager_name"));
			commonData.settBestModel(rs.getString("best_model"));
			commonData.settCompanyFrom(rs.getString("company_from"));
			commonData.settManagerName(rs.getString("manager_name"));
			commonList.add(commonData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return commonList;
	}

	@Override
	public Common getShowRoomData() {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getShowRoomData");
		query.registerStoredProcedureParameter("oShow_Room", Void.class, ParameterMode.REF_CURSOR);
		query.registerStoredProcedureParameter("oHonda", Void.class, ParameterMode.REF_CURSOR);
		query.registerStoredProcedureParameter("oHero", Void.class, ParameterMode.REF_CURSOR);
		query.registerStoredProcedureParameter("oYamaha", Void.class, ParameterMode.REF_CURSOR);
		query.registerStoredProcedureParameter("oBajaj", Void.class, ParameterMode.REF_CURSOR);
		query.registerStoredProcedureParameter("oTvs", Void.class, ParameterMode.REF_CURSOR);
		query.registerStoredProcedureParameter("oKawasaki", Void.class, ParameterMode.REF_CURSOR);
		
		query.execute();
		
		ResultSet rs = (ResultSet) query.getOutputParameterValue("oShow_Room");
		ResultSet rs1 = (ResultSet) query.getOutputParameterValue("oHonda");
		ResultSet rs2 = (ResultSet) query.getOutputParameterValue("oHero");
		ResultSet rs3 = (ResultSet) query.getOutputParameterValue("oYamaha");
		ResultSet rs4 = (ResultSet) query.getOutputParameterValue("oBajaj");
		ResultSet rs5 = (ResultSet) query.getOutputParameterValue("oTvs");
		ResultSet rs6 = (ResultSet) query.getOutputParameterValue("oKawasaki");
		
		Common common = new Common();
	    
		List<ShowRoom> showRoomList = new ArrayList<ShowRoom>();
		List<Honda> hondaList = new ArrayList<Honda>();
		List<Hero> heroList = new ArrayList<Hero>();
		List<Yamaha> yamahaList = new ArrayList<Yamaha>();
		List<Bajaj> bajajList = new ArrayList<Bajaj>();
		List<Tvs> tvsList = new ArrayList<Tvs>();
		List<Kawasaki> kawasakiList = new ArrayList<Kawasaki>();
		
		ShowRoom showRoom = null;
		Honda honda = null;
		Hero hero = null;
		Yamaha yamaha =  null;
		Bajaj bajaj = null;
		Tvs tvs = null;
		Kawasaki kawasaki = null;
		try {
			while(rs.next()) {
			showRoom = new ShowRoom();
			showRoom.setShowRoomId(rs.getLong("show_room_id"));
			showRoom.setShowRoomName(rs.getString("show_room_name"));
			showRoom.setShowRoomOwnerName(rs.getString("show_room_owner_name"));
			showRoom.setTotalEmployess(rs.getString("total_employess"));
			showRoomList.add(showRoom);
			}
			
			while(rs1.next()) {
			    honda = new Honda();
			    honda.setCompanyId(rs1.getLong("company_id"));
				honda.setBestModel(rs1.getString("best_model"));
				honda.setCompanyFrom(rs1.getString("company_from"));
				honda.setManagerName(rs1.getString("manager_name"));
				hondaList.add(honda);
				}
			
			
			while(rs2.next()) {
			    hero = new Hero();
			    hero.setCompanyId(rs2.getLong("company_id"));
				hero.setBestModel(rs2.getString("best_model"));
				hero.setCompanyFrom(rs2.getString("company_from"));
				hero.setManagerName(rs2.getString("manager_name"));
				heroList.add(hero);
				}
			
			
			while(rs3.next()) {
				yamaha = new Yamaha();
				yamaha.setCompanyId(rs3.getLong("company_id"));
				yamaha.setBestModel(rs3.getString("best_model"));
				yamaha.setCompanyFrom(rs3.getString("company_from"));
				yamaha.setManagerName(rs3.getString("manager_name"));
				yamahaList.add(yamaha);
				}
			
			
			while(rs4.next()) {
				bajaj = new Bajaj();
				bajaj.setCompanyId(rs4.getLong("company_id"));
				bajaj.setBestModel(rs4.getString("best_model"));
				bajaj.setCompanyFrom(rs4.getString("company_from"));
				bajaj.setManagerName(rs4.getString("manager_name"));
				bajajList.add(bajaj);
				}
			
			
			while(rs5.next()) {
				tvs = new Tvs();
				tvs.setCompanyId(rs5.getLong("company_id"));
				tvs.setBestModel(rs5.getString("best_model"));
				tvs.setCompanyFrom(rs5.getString("company_from"));
				tvs.setManagerName(rs5.getString("manager_name"));
				tvsList.add(tvs);
				}
			
			
			while(rs6.next()) {
				kawasaki = new Kawasaki();
				kawasaki.setCompanyId(rs6.getLong("company_id"));
				kawasaki.setBestModel(rs6.getString("best_model"));
				kawasaki.setCompanyFrom(rs6.getString("company_from"));
				kawasaki.setManagerName(rs6.getString("manager_name"));
				kawasakiList.add(kawasaki);
				}
			
			common.setShowRoomList(showRoomList);
			common.setHeroList(heroList);
			common.setHondaList(hondaList);
			common.setBajajList(bajajList);
			common.setTvsList(tvsList);
			common.setYamahaList(yamahaList);
			common.setKawasakiList(kawasakiList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return common;
	}

	@Override
	public ShowRoom getShowRoomById(long showRoomId) {
	StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getShowRoomById");
	query.registerStoredProcedureParameter("iId", Integer.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("oCursor", Void.class, ParameterMode.REF_CURSOR);
	query.setParameter("iId", showRoomId);
	query.execute();	
	ResultSet rs = null;
	
	rs = (ResultSet) query.getOutputParameterValue("oCursor");
	ShowRoom showRoom = null;
	try {
		while(rs.next()) {
		showRoom = new ShowRoom();
		showRoom.setShowRoomName(rs.getString("show_room_name"));
		showRoom.setShowRoomOwnerName(rs.getString("show_room_owner_name"));
		showRoom.setTotalEmployess(rs.getString("total_employess"));
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return showRoom;
	}

	@Override
	public Common getAllBikesById(long companyId) {
	StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getAllBikesById");
	query.registerStoredProcedureParameter("iId", Integer.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("oShowRoom", Void.class, ParameterMode.REF_CURSOR);
	query.registerStoredProcedureParameter("oHonda", Void.class, ParameterMode.REF_CURSOR);
	query.registerStoredProcedureParameter("oHero", Void.class, ParameterMode.REF_CURSOR);
	query.registerStoredProcedureParameter("oYamaha", Void.class, ParameterMode.REF_CURSOR);
	query.registerStoredProcedureParameter("oBajaj", Void.class, ParameterMode.REF_CURSOR);
	query.registerStoredProcedureParameter("oTvs", Void.class, ParameterMode.REF_CURSOR);
	query.registerStoredProcedureParameter("oKawasaki", Void.class, ParameterMode.REF_CURSOR);
	
	query.setParameter("iId",companyId);
	
	query.execute();
	
	ResultSet rs = (ResultSet) query.getOutputParameterValue("oShowRoom");
	ResultSet rs1 = (ResultSet) query.getOutputParameterValue("oHonda");
	ResultSet rs2 = (ResultSet) query.getOutputParameterValue("oHero");
	ResultSet rs3 = (ResultSet) query.getOutputParameterValue("oYamaha");
	ResultSet rs4 = (ResultSet) query.getOutputParameterValue("oBajaj");
	ResultSet rs5 = (ResultSet) query.getOutputParameterValue("oTvs");
	ResultSet rs6 = (ResultSet) query.getOutputParameterValue("oKawasaki");
	
	Common common = new Common();
    
	List<ShowRoom> showRoomList = new ArrayList<ShowRoom>();
	List<Honda> hondaList = new ArrayList<Honda>();
	List<Hero> heroList = new ArrayList<Hero>();
	List<Yamaha> yamahaList = new ArrayList<Yamaha>();
	List<Bajaj> bajajList = new ArrayList<Bajaj>();
	List<Tvs> tvsList = new ArrayList<Tvs>();
	List<Kawasaki> kawasakiList = new ArrayList<Kawasaki>();
	
	ShowRoom showRoom = null;
	Honda honda = null;
	Hero hero = null;
	Yamaha yamaha =  null;
	Bajaj bajaj = null;
	Tvs tvs = null;
	Kawasaki kawasaki = null;
	try {
		while(rs.next()) {
		showRoom = new ShowRoom();
		showRoom.setShowRoomName(rs.getString("show_room_name"));
		showRoom.setShowRoomOwnerName(rs.getString("show_room_owner_name"));
		showRoom.setTotalEmployess(rs.getString("total_employess"));
		showRoomList.add(showRoom);
		}
		
		while(rs1.next()) {
		    honda = new Honda();
			honda.setBestModel(rs1.getString("best_model"));
			honda.setCompanyFrom(rs1.getString("company_from"));
			honda.setManagerName(rs1.getString("manager_name"));
			hondaList.add(honda);
			}
		
		
		while(rs2.next()) {
		    hero = new Hero();
			hero.setBestModel(rs2.getString("best_model"));
			hero.setCompanyFrom(rs2.getString("company_from"));
			hero.setManagerName(rs2.getString("manager_name"));
			heroList.add(hero);
			}
		
		
		while(rs3.next()) {
			yamaha = new Yamaha();
			yamaha.setBestModel(rs3.getString("best_model"));
			yamaha.setCompanyFrom(rs3.getString("company_from"));
			yamaha.setManagerName(rs3.getString("manager_name"));
			yamahaList.add(yamaha);
			}
		
		
		while(rs4.next()) {
			bajaj = new Bajaj();
			bajaj.setBestModel(rs4.getString("best_model"));
			bajaj.setCompanyFrom(rs4.getString("company_from"));
			bajaj.setManagerName(rs4.getString("manager_name"));
			bajajList.add(bajaj);
			}
		
		
		while(rs5.next()) {
			tvs = new Tvs();
			tvs.setBestModel(rs5.getString("best_model"));
			tvs.setCompanyFrom(rs5.getString("company_from"));
			tvs.setManagerName(rs5.getString("manager_name"));
			tvsList.add(tvs);
			}
		
		
		while(rs6.next()) {
			kawasaki = new Kawasaki();
			kawasaki.setBestModel(rs6.getString("best_model"));
			kawasaki.setCompanyFrom(rs6.getString("company_from"));
			kawasaki.setManagerName(rs6.getString("manager_name"));
			kawasakiList.add(kawasaki);
			}
		
		common.setShowRoomList(showRoomList);
		common.setHeroList(heroList);
		common.setHondaList(hondaList);
		common.setBajajList(bajajList);
		common.setTvsList(tvsList);
		common.setYamahaList(yamahaList);
		common.setKawasakiList(kawasakiList);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return common;
		
	}

	@Override
	public Map<String, String> deleteShowRoom(long showRoomId) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("deleteShowRoomById");
		query.registerStoredProcedureParameter("iId", Integer.class, ParameterMode.IN);
		query.setParameter("iId", showRoomId);
		query.execute();
		Map<String,String> deletedResponse = new HashMap<String,String>();
		deletedResponse.put("status", "deleted sucessfully");
		return deletedResponse;
	}

	@Override
	public Map<String, String> deleteAllBikeById(long companyId) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("deleteBikeById");
		query.registerStoredProcedureParameter("iId", Integer.class, ParameterMode.IN);
		query.setParameter("iId", companyId);
		query.execute();
		Map<String,String> deletedResponse = new HashMap<String,String>();
		deletedResponse.put("status", "deleted sucessfully");
		return deletedResponse;
	}

	@Override
	public Map<String,String> updateShowRoom(ShowRoom showRoom) {
	StoredProcedureQuery query = entityManager.createStoredProcedureQuery("updateShowRoom");
	query.registerStoredProcedureParameter("iShowRoomId", Integer.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("iShowRoomName", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("iShowRoomOwnerName", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("iTotalEmployess", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("ihCompanyFrom", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("ihManagerName", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("ihBestModel", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("iBCompanyFrom", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("iBManagerName", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("iBBestModel", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("ihoCompanyFrom", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("ihoManagerName", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("ihoBestModel", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("ikCompanyFrom", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("ikManagerName", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("ikBestModel", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("itCompanyFrom", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("itManagerName", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("itBestModel", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("iyCompanyFrom", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("iyManagerName", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("iyBestModel", String.class, ParameterMode.IN);
	query.setParameter("iShowRoomId", showRoom.getShowRoomId());
	query.setParameter("iShowRoomName", showRoom.getShowRoomName());
	query.setParameter("iShowRoomOwnerName", showRoom.getShowRoomOwnerName());
	query.setParameter("iTotalEmployess", showRoom.getTotalEmployess());
	query.setParameter("ihCompanyFrom", showRoom.getHeroList().get(0).getCompanyFrom());
	query.setParameter("ihManagerName", showRoom.getHeroList().get(0).getManagerName());
	query.setParameter("ihBestModel", showRoom.getHeroList().get(0).getBestModel());
	query.setParameter("iBCompanyFrom", showRoom.getBajajList().get(0).getCompanyFrom());
	query.setParameter("iBManagerName", showRoom.getBajajList().get(0).getManagerName());
	query.setParameter("iBBestModel", showRoom.getBajajList().get(0).getBestModel());
	query.setParameter("ihoCompanyFrom", showRoom.getHondaList().get(0).getCompanyFrom());
	query.setParameter("ihoManagerName", showRoom.getHondaList().get(0).getManagerName());
	query.setParameter("ihoBestModel", showRoom.getHondaList().get(0).getBestModel());
	query.setParameter("ikCompanyFrom", showRoom.getKawasakiList().get(0).getCompanyFrom());
	query.setParameter("ikManagerName", showRoom.getKawasakiList().get(0).getManagerName());
	query.setParameter("ikBestModel", showRoom.getKawasakiList().get(0).getBestModel());
	query.setParameter("itCompanyFrom", showRoom.getTvsList().get(0).getCompanyFrom());
	query.setParameter("itManagerName", showRoom.getTvsList().get(0).getManagerName());
	query.setParameter("itBestModel", showRoom.getTvsList().get(0).getBestModel());
	query.setParameter("iyCompanyFrom", showRoom.getYamahaList().get(0).getCompanyFrom());
	query.setParameter("iyManagerName", showRoom.getYamahaList().get(0).getManagerName());
	query.setParameter("iyBestModel", showRoom.getYamahaList().get(0).getBestModel());
	
	query.execute();
	
	Map<String,String> updatedResponse = new HashMap<String,String>();
	updatedResponse.put("status", "updated sucessfully");
	return updatedResponse;
	
	}

	

	  
	
}
