package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.consumer.Consumer;
import com.example.demo.consumer.ShowRoomConsumer;
import com.example.demo.departmentConsumer.DepartmentConsumer;
import com.example.demo.departmentInterface.DepartmentInterface;
import com.example.demo.model.Common;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.ShowRoom;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	
	@Autowired
	private ShowRoomConsumer showRoomConsumer;
	
	@Autowired
	private Consumer consumer;
	
	@Autowired
	private DepartmentInterface departmentInterface;
	
	@Autowired
	private DepartmentConsumer departmentConsumer;

	@GetMapping("getDepartment")
	public String getDepartMent() {
	String data = departmentConsumer.getConsumerEmployee();	
		return "i m department"+data;
	}
	
	@GetMapping("getDepartments")
	public String getDepartMents() {
	String data = departmentConsumer.getAllEmployees();
		return "i m department"+data;
	}
	
	@PostMapping("/saveDept")
	public Department saveDept(@RequestBody Department department) {
		Department save = departmentInterface.saveDept(department);
		return save;
	}
	
	@GetMapping("/getAllDept")
	public List<Object> getAllDept(){
		List<Department> deptList = departmentInterface.getAllDept();
		Object employeeData = departmentConsumer.getAllData();
		List<Object> obj = new ArrayList<Object>();
		obj.add(employeeData);
		obj.add(deptList);
		return obj;
	}
	
	@GetMapping("/getAllDataOfCompany")
	public List<Object> getAllDataOfCompany(){
		List<Department> deptList = departmentInterface.getAllDept();
		Object object = departmentConsumer.getAllData();
		Object objectShow = departmentConsumer.getAllShowRoomInfo();
		List<Object> objectList = new ArrayList<Object>();
		objectList.add(deptList);
		objectList.add(object);
		objectList.add(objectShow);
		return objectList;
	}
	
	@GetMapping("/getAllDatas")
	public Employee getAllDatas() {
		List<Employee> employee = consumer.getAllData();
		List<Department> deptList = departmentInterface.getAllDept();
		Common common = showRoomConsumer.getShowRoomData();
		Employee employees = new Employee();
		employees.setDeptList(deptList);
		employees.setEmployee(employee);
		employees.setCommon(common);
		return employees;
	}
	
	@PostMapping("/saveShowRoom")
	public ShowRoom saveShowRoom(@RequestBody ShowRoom showRoom) {
		ShowRoom showRoomData = showRoomConsumer.saveShowRoom(showRoom);
		Department department = showRoom.getDepartment();
		Department save = departmentInterface.saveDept(department);
		showRoomData.setDepartment(save);
		Employee employee = showRoom.getEmployee();
		Employee saveEmployee = consumer.saveEmployee(employee);
		showRoomData.setEmployee(saveEmployee);
		return showRoomData;
	}
	
	@GetMapping("/getDataById")
	public ShowRoom getDataById(@RequestParam("showRoomId") long showRoomId) {
		Department department = departmentInterface.getDepartment(showRoomId);
		Employee employee = consumer.getEmployee(showRoomId);
		Common common = showRoomConsumer.getAllBikesById(showRoomId);
		ShowRoom showRoomData = new ShowRoom();
		showRoomData.setDepartment(department);
		showRoomData.setEmployee(employee);
		showRoomData.setCommon(common);
		return showRoomData;
	}
	
	@GetMapping("/deleteAllInfoById")
	public Map<String,String> deleteAllInfoById(@RequestParam("showRoomId") long showRoomId){
		Map<String,String> del = departmentInterface.deleteById(showRoomId);
		Map<String,String> delCon = consumer.deleteById(showRoomId);
		Map<String,String> delShowCon = showRoomConsumer.deleteAllBikeById(showRoomId);
		Map<String,String> delete = showRoomConsumer.deleteShowRoom(showRoomId);
		Map<String,String> response = new HashMap<String,String>();
		response.put("status", "deleted sucessfully");
		return response;
	}
	
	@PostMapping("updateDepartment")
	public Map<String,String> updateDepartment(@RequestBody ShowRoom showRoom){
		Department department = showRoom.getDepartment();
		Map<String,String> departmentSave = departmentInterface.updateDepartment(department); 
		Employee employee = showRoom.getEmployee();
		Map<String,String> departmentRes = consumer.updateEmployee(employee);
		return departmentSave;
	}

	
	@PostMapping("updateShowRoom")
	public Map<String,String> updateShowRoom(@RequestBody ShowRoom showRoom){
		Map<String,String> updateShowRoom = showRoomConsumer.updateShowRoom(showRoom);
		return updateShowRoom;
	}
	
}
