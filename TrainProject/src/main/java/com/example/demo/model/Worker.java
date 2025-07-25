package com.example.demo.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Worker {
	private long id;
	private String name;
	private String createdDate;
	private long notesId;
	private long resourceId;
	private long userId;
	private String notes;
	private long certificateId;
	private String certificateName;
	private String createdBy;
	private String updatedBy;
	private String updatedOn;
	private String paymentMode;
	private String nameOnCheck;
	private String taxId;
	private String bank;
	private String routing;
	private String account;
	private String adpNumber;
	private String rate1;
	private String rate2;
	private String rate3;
	private String cutoffTimeBefore;
	private String cutoffTimeAfter;
	private String minPayHours;
	private long suspendPay;
	private String overhead;
	private List<Worker>    workerList;
//	private List<WorkerCertifications> workerCertificationsList;
	private Worker workers;
	private Worker workersDataList;
	private long certificationId;
	private String certificationExpiryDate;
	private int certificateActive;
	private String certificationNotes;
	private String workerCertificateimageName;
	private String caterDocsId;
	private int managePreference;
	private String startTime;
	private String endTime;
	private String createdOn;
    private String createdUser_id;
    private String startDate;
    private String endDate;
    private String cisNo;
    private long eventExceptionId;
    private String dayFlag1;
    private String dayFlag2;
    private String chk2DisableFalg;
    private long effectDateId;
    private long groupId;
    private long personalTypeId;
    private long reconcileCheck;
    private long scheduledCheck;
    
    private String[] rates;
    private String[] ids;
    private String[] checkedValues;
   
    private String weekDate;
    private String uploadContentType;
	private String uploadFileName;
	private String fileType;
	
	private String covidVaccineCertificateimageContentType;
	private String covidVaccineCertificateimageuploadFileName;
	private String covidVaccineCertificateimageFileType;
	
	private String covidVaccineCertificateimageId;
	private String suffix;
	private String hireDate;
	private String terminationDate;
	private String workerType;
    private String contractExpiryDate;
    private String citizenship;
    private String ethnicity;
    private String fax;
    private String pager;
    private String sortOrder;
    private String doubleBooking;
    private long  addressId;
    private String userName;
    private String passWord;
    private String paperWork;
    private String transportation;
    private String preferredWorker;
    private String vaccineName;
    private String vaccinatedDate;
    private String agency;
    private String emergencyContactName;
    private String emergencyContactNumber;
    private String emergencyEmail;
    
	
	    private long tuxedo;
	    private String height;
	    private String weight;
	    private String jacket;
	    private String collar;
	    private String waist;
	    private String inseam;
	    private String priority;
	    private String floor;
	    private String kitchen;
	    private String attendance;
	    private String ability;
	    private String attitude;
	    private String appearance;
	    private String tardiness;
	    private String comments;
	    private String freeLancerFlag;
	    
	    private long fsd;
	    private String fsdSize;
	    private long privateHome;
	    private String privateHomeSize;
	    private long tasting;
	    private String tastingSize;
	    private String[] uniformTypeIds;
	    private String[] uniformSizeIds;
	    private List<Worker>    securityList;
	    private String expiryDate;
	    private String   securityNo;
	    private String[] expiryDates;
	    private String[] securityNos;
	    private String[] securityIds;
	    
	    private long uniformTypeId;
	    private long uniformSizeId;
	    private String uniformSize;
	    private String uniformName;
	    private long savedUniformSize;
	    private List<Worker> uniformTypeList;
	    private List<Worker> uniformSizeList;
	    private List<Worker> uniformTypeSizeList;
	    private List<Worker>    personnelRateList;
	    private List<Worker>    personnelRateTypesList;
	    
	    private long newPersonnelRateId;
	    private String preference;
	    private long  count;
	    private String location;
	    private String eventType;
	    private String uniformType;
	    private String date;
	    private String type;
	    private String rate;
	    private long checkedValue;
	    private String firstName;
	    private String middleInitial;
	    private String lastName;
	    private String sex;
	    private String ssn;
	    private String dateOfBirth;
	    private String placeofBirth;
	    private String active;
	    private String street;
	    private String suite;
	    private String city;
	    private String state;
	    private String zip;
	    private String workPhone;
	    private String homePhone; 
	    private String cell; 
	    private String email;
	    private String question1;
	    private String answer1;
	    private String question2;
	    private String answer2;
	    private String question3;
	    private String answer3;
	    private String  loginid;
	    private String pants;
	    private String shoe;
	    private String poloTshirt;
		private String dressShirt;
		private String userIds;
	    private String workerFlag;
	    
	    private long schId;
		private long eventId;
		private long workerTypeId;
		private String fileName;
		private String covidVaccineCertificateimageName;
		private int managePlusPreference;
		private List<Personnel> stateList;
		private List<Personnel> ethnicityList;
		private List<Personnel> workerTypeList;
//		private List<UserInfo>  userList;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		public long getNotesId() {
			return notesId;
		}
		public void setNotesId(long notesId) {
			this.notesId = notesId;
		}
		public long getResourceId() {
			return resourceId;
		}
		public void setResourceId(long resourceId) {
			this.resourceId = resourceId;
		}
		public long getUserId() {
			return userId;
		}
		public void setUserId(long userId) {
			this.userId = userId;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		public long getCertificateId() {
			return certificateId;
		}
		public void setCertificateId(long certificateId) {
			this.certificateId = certificateId;
		}
		public String getCertificateName() {
			return certificateName;
		}
		public void setCertificateName(String certificateName) {
			this.certificateName = certificateName;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public String getUpdatedBy() {
			return updatedBy;
		}
		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}
		public String getUpdatedOn() {
			return updatedOn;
		}
		public void setUpdatedOn(String updatedOn) {
			this.updatedOn = updatedOn;
		}
		public String getPaymentMode() {
			return paymentMode;
		}
		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}
		public String getNameOnCheck() {
			return nameOnCheck;
		}
		public void setNameOnCheck(String nameOnCheck) {
			this.nameOnCheck = nameOnCheck;
		}
		public String getTaxId() {
			return taxId;
		}
		public void setTaxId(String taxId) {
			this.taxId = taxId;
		}
		public String getBank() {
			return bank;
		}
		public void setBank(String bank) {
			this.bank = bank;
		}
		public String getRouting() {
			return routing;
		}
		public void setRouting(String routing) {
			this.routing = routing;
		}
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public String getAdpNumber() {
			return adpNumber;
		}
		public void setAdpNumber(String adpNumber) {
			this.adpNumber = adpNumber;
		}
		public String getRate1() {
			return rate1;
		}
		public void setRate1(String rate1) {
			this.rate1 = rate1;
		}
		public String getRate2() {
			return rate2;
		}
		public void setRate2(String rate2) {
			this.rate2 = rate2;
		}
		public String getRate3() {
			return rate3;
		}
		public void setRate3(String rate3) {
			this.rate3 = rate3;
		}
		public String getCutoffTimeBefore() {
			return cutoffTimeBefore;
		}
		public void setCutoffTimeBefore(String cutoffTimeBefore) {
			this.cutoffTimeBefore = cutoffTimeBefore;
		}
		public String getCutoffTimeAfter() {
			return cutoffTimeAfter;
		}
		public void setCutoffTimeAfter(String cutoffTimeAfter) {
			this.cutoffTimeAfter = cutoffTimeAfter;
		}
		public String getMinPayHours() {
			return minPayHours;
		}
		public void setMinPayHours(String minPayHours) {
			this.minPayHours = minPayHours;
		}
		public long getSuspendPay() {
			return suspendPay;
		}
		public void setSuspendPay(long suspendPay) {
			this.suspendPay = suspendPay;
		}
		public String getOverhead() {
			return overhead;
		}
		public void setOverhead(String overhead) {
			this.overhead = overhead;
		}
		public List<Worker> getWorkerList() {
			return workerList;
		}
		public void setWorkerList(List<Worker> workerList) {
			this.workerList = workerList;
		}
		public Worker getWorkers() {
			return workers;
		}
		public void setWorkers(Worker workers) {
			this.workers = workers;
		}
		public Worker getWorkersDataList() {
			return workersDataList;
		}
		public void setWorkersDataList(Worker workersDataList) {
			this.workersDataList = workersDataList;
		}
		public long getCertificationId() {
			return certificationId;
		}
		public void setCertificationId(long certificationId) {
			this.certificationId = certificationId;
		}
		public String getCertificationExpiryDate() {
			return certificationExpiryDate;
		}
		public void setCertificationExpiryDate(String certificationExpiryDate) {
			this.certificationExpiryDate = certificationExpiryDate;
		}
		public int getCertificateActive() {
			return certificateActive;
		}
		public void setCertificateActive(int certificateActive) {
			this.certificateActive = certificateActive;
		}
		public String getCertificationNotes() {
			return certificationNotes;
		}
		public void setCertificationNotes(String certificationNotes) {
			this.certificationNotes = certificationNotes;
		}
		public String getWorkerCertificateimageName() {
			return workerCertificateimageName;
		}
		public void setWorkerCertificateimageName(String workerCertificateimageName) {
			this.workerCertificateimageName = workerCertificateimageName;
		}
		public String getCaterDocsId() {
			return caterDocsId;
		}
		public void setCaterDocsId(String caterDocsId) {
			this.caterDocsId = caterDocsId;
		}
		public int getManagePreference() {
			return managePreference;
		}
		public void setManagePreference(int managePreference) {
			this.managePreference = managePreference;
		}
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		public String getCreatedOn() {
			return createdOn;
		}
		public void setCreatedOn(String createdOn) {
			this.createdOn = createdOn;
		}
		public String getCreatedUser_id() {
			return createdUser_id;
		}
		public void setCreatedUser_id(String createdUser_id) {
			this.createdUser_id = createdUser_id;
		}
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		public String getCisNo() {
			return cisNo;
		}
		public void setCisNo(String cisNo) {
			this.cisNo = cisNo;
		}
		public long getEventExceptionId() {
			return eventExceptionId;
		}
		public void setEventExceptionId(long eventExceptionId) {
			this.eventExceptionId = eventExceptionId;
		}
		public String getDayFlag1() {
			return dayFlag1;
		}
		public void setDayFlag1(String dayFlag1) {
			this.dayFlag1 = dayFlag1;
		}
		public String getDayFlag2() {
			return dayFlag2;
		}
		public void setDayFlag2(String dayFlag2) {
			this.dayFlag2 = dayFlag2;
		}
		public String getChk2DisableFalg() {
			return chk2DisableFalg;
		}
		public void setChk2DisableFalg(String chk2DisableFalg) {
			this.chk2DisableFalg = chk2DisableFalg;
		}
		public long getEffectDateId() {
			return effectDateId;
		}
		public void setEffectDateId(long effectDateId) {
			this.effectDateId = effectDateId;
		}
		public long getGroupId() {
			return groupId;
		}
		public void setGroupId(long groupId) {
			this.groupId = groupId;
		}
		public long getPersonalTypeId() {
			return personalTypeId;
		}
		public void setPersonalTypeId(long personalTypeId) {
			this.personalTypeId = personalTypeId;
		}
		public long getReconcileCheck() {
			return reconcileCheck;
		}
		public void setReconcileCheck(long reconcileCheck) {
			this.reconcileCheck = reconcileCheck;
		}
		public long getScheduledCheck() {
			return scheduledCheck;
		}
		public void setScheduledCheck(long scheduledCheck) {
			this.scheduledCheck = scheduledCheck;
		}
		public String[] getRates() {
			return rates;
		}
		public void setRates(String[] rates) {
			this.rates = rates;
		}
		public String[] getIds() {
			return ids;
		}
		public void setIds(String[] ids) {
			this.ids = ids;
		}
		public String[] getCheckedValues() {
			return checkedValues;
		}
		public void setCheckedValues(String[] checkedValues) {
			this.checkedValues = checkedValues;
		}
		public String getWeekDate() {
			return weekDate;
		}
		public void setWeekDate(String weekDate) {
			this.weekDate = weekDate;
		}
		public String getUploadContentType() {
			return uploadContentType;
		}
		public void setUploadContentType(String uploadContentType) {
			this.uploadContentType = uploadContentType;
		}
		public String getUploadFileName() {
			return uploadFileName;
		}
		public void setUploadFileName(String uploadFileName) {
			this.uploadFileName = uploadFileName;
		}
		public String getFileType() {
			return fileType;
		}
		public void setFileType(String fileType) {
			this.fileType = fileType;
		}
		public String getCovidVaccineCertificateimageContentType() {
			return covidVaccineCertificateimageContentType;
		}
		public void setCovidVaccineCertificateimageContentType(String covidVaccineCertificateimageContentType) {
			this.covidVaccineCertificateimageContentType = covidVaccineCertificateimageContentType;
		}
		public String getCovidVaccineCertificateimageuploadFileName() {
			return covidVaccineCertificateimageuploadFileName;
		}
		public void setCovidVaccineCertificateimageuploadFileName(String covidVaccineCertificateimageuploadFileName) {
			this.covidVaccineCertificateimageuploadFileName = covidVaccineCertificateimageuploadFileName;
		}
		public String getCovidVaccineCertificateimageFileType() {
			return covidVaccineCertificateimageFileType;
		}
		public void setCovidVaccineCertificateimageFileType(String covidVaccineCertificateimageFileType) {
			this.covidVaccineCertificateimageFileType = covidVaccineCertificateimageFileType;
		}
		public String getCovidVaccineCertificateimageId() {
			return covidVaccineCertificateimageId;
		}
		public void setCovidVaccineCertificateimageId(String covidVaccineCertificateimageId) {
			this.covidVaccineCertificateimageId = covidVaccineCertificateimageId;
		}
		public String getSuffix() {
			return suffix;
		}
		public void setSuffix(String suffix) {
			this.suffix = suffix;
		}
		public String getHireDate() {
			return hireDate;
		}
		public void setHireDate(String hireDate) {
			this.hireDate = hireDate;
		}
		public String getTerminationDate() {
			return terminationDate;
		}
		public void setTerminationDate(String terminationDate) {
			this.terminationDate = terminationDate;
		}
		public String getWorkerType() {
			return workerType;
		}
		public void setWorkerType(String workerType) {
			this.workerType = workerType;
		}
		public String getContractExpiryDate() {
			return contractExpiryDate;
		}
		public void setContractExpiryDate(String contractExpiryDate) {
			this.contractExpiryDate = contractExpiryDate;
		}
		public String getCitizenship() {
			return citizenship;
		}
		public void setCitizenship(String citizenship) {
			this.citizenship = citizenship;
		}
		public String getEthnicity() {
			return ethnicity;
		}
		public void setEthnicity(String ethnicity) {
			this.ethnicity = ethnicity;
		}
		public String getFax() {
			return fax;
		}
		public void setFax(String fax) {
			this.fax = fax;
		}
		public String getPager() {
			return pager;
		}
		public void setPager(String pager) {
			this.pager = pager;
		}
		public String getSortOrder() {
			return sortOrder;
		}
		public void setSortOrder(String sortOrder) {
			this.sortOrder = sortOrder;
		}
		public String getDoubleBooking() {
			return doubleBooking;
		}
		public void setDoubleBooking(String doubleBooking) {
			this.doubleBooking = doubleBooking;
		}
		public long getAddressId() {
			return addressId;
		}
		public void setAddressId(long addressId) {
			this.addressId = addressId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassWord() {
			return passWord;
		}
		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}
		public String getPaperWork() {
			return paperWork;
		}
		public void setPaperWork(String paperWork) {
			this.paperWork = paperWork;
		}
		public String getTransportation() {
			return transportation;
		}
		public void setTransportation(String transportation) {
			this.transportation = transportation;
		}
		public String getPreferredWorker() {
			return preferredWorker;
		}
		public void setPreferredWorker(String preferredWorker) {
			this.preferredWorker = preferredWorker;
		}
		public String getVaccineName() {
			return vaccineName;
		}
		public void setVaccineName(String vaccineName) {
			this.vaccineName = vaccineName;
		}
		public String getVaccinatedDate() {
			return vaccinatedDate;
		}
		public void setVaccinatedDate(String vaccinatedDate) {
			this.vaccinatedDate = vaccinatedDate;
		}
		public String getAgency() {
			return agency;
		}
		public void setAgency(String agency) {
			this.agency = agency;
		}
		public String getEmergencyContactName() {
			return emergencyContactName;
		}
		public void setEmergencyContactName(String emergencyContactName) {
			this.emergencyContactName = emergencyContactName;
		}
		public String getEmergencyContactNumber() {
			return emergencyContactNumber;
		}
		public void setEmergencyContactNumber(String emergencyContactNumber) {
			this.emergencyContactNumber = emergencyContactNumber;
		}
		public String getEmergencyEmail() {
			return emergencyEmail;
		}
		public void setEmergencyEmail(String emergencyEmail) {
			this.emergencyEmail = emergencyEmail;
		}
		public long getTuxedo() {
			return tuxedo;
		}
		public void setTuxedo(long tuxedo) {
			this.tuxedo = tuxedo;
		}
		public String getHeight() {
			return height;
		}
		public void setHeight(String height) {
			this.height = height;
		}
		public String getWeight() {
			return weight;
		}
		public void setWeight(String weight) {
			this.weight = weight;
		}
		public String getJacket() {
			return jacket;
		}
		public void setJacket(String jacket) {
			this.jacket = jacket;
		}
		public String getCollar() {
			return collar;
		}
		public void setCollar(String collar) {
			this.collar = collar;
		}
		public String getWaist() {
			return waist;
		}
		public void setWaist(String waist) {
			this.waist = waist;
		}
		public String getInseam() {
			return inseam;
		}
		public void setInseam(String inseam) {
			this.inseam = inseam;
		}
		public String getPriority() {
			return priority;
		}
		public void setPriority(String priority) {
			this.priority = priority;
		}
		public String getFloor() {
			return floor;
		}
		public void setFloor(String floor) {
			this.floor = floor;
		}
		public String getKitchen() {
			return kitchen;
		}
		public void setKitchen(String kitchen) {
			this.kitchen = kitchen;
		}
		public String getAttendance() {
			return attendance;
		}
		public void setAttendance(String attendance) {
			this.attendance = attendance;
		}
		public String getAbility() {
			return ability;
		}
		public void setAbility(String ability) {
			this.ability = ability;
		}
		public String getAttitude() {
			return attitude;
		}
		public void setAttitude(String attitude) {
			this.attitude = attitude;
		}
		public String getAppearance() {
			return appearance;
		}
		public void setAppearance(String appearance) {
			this.appearance = appearance;
		}
		public String getTardiness() {
			return tardiness;
		}
		public void setTardiness(String tardiness) {
			this.tardiness = tardiness;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public String getFreeLancerFlag() {
			return freeLancerFlag;
		}
		public void setFreeLancerFlag(String freeLancerFlag) {
			this.freeLancerFlag = freeLancerFlag;
		}
		public long getFsd() {
			return fsd;
		}
		public void setFsd(long fsd) {
			this.fsd = fsd;
		}
		public String getFsdSize() {
			return fsdSize;
		}
		public void setFsdSize(String fsdSize) {
			this.fsdSize = fsdSize;
		}
		public long getPrivateHome() {
			return privateHome;
		}
		public void setPrivateHome(long privateHome) {
			this.privateHome = privateHome;
		}
		public String getPrivateHomeSize() {
			return privateHomeSize;
		}
		public void setPrivateHomeSize(String privateHomeSize) {
			this.privateHomeSize = privateHomeSize;
		}
		public long getTasting() {
			return tasting;
		}
		public void setTasting(long tasting) {
			this.tasting = tasting;
		}
		public String getTastingSize() {
			return tastingSize;
		}
		public void setTastingSize(String tastingSize) {
			this.tastingSize = tastingSize;
		}
		public String[] getUniformTypeIds() {
			return uniformTypeIds;
		}
		public void setUniformTypeIds(String[] uniformTypeIds) {
			this.uniformTypeIds = uniformTypeIds;
		}
		public String[] getUniformSizeIds() {
			return uniformSizeIds;
		}
		public void setUniformSizeIds(String[] uniformSizeIds) {
			this.uniformSizeIds = uniformSizeIds;
		}
		public List<Worker> getSecurityList() {
			return securityList;
		}
		public void setSecurityList(List<Worker> securityList) {
			this.securityList = securityList;
		}
		public String getExpiryDate() {
			return expiryDate;
		}
		public void setExpiryDate(String expiryDate) {
			this.expiryDate = expiryDate;
		}
		public String getSecurityNo() {
			return securityNo;
		}
		public void setSecurityNo(String securityNo) {
			this.securityNo = securityNo;
		}
		public String[] getExpiryDates() {
			return expiryDates;
		}
		public void setExpiryDates(String[] expiryDates) {
			this.expiryDates = expiryDates;
		}
		public String[] getSecurityNos() {
			return securityNos;
		}
		public void setSecurityNos(String[] securityNos) {
			this.securityNos = securityNos;
		}
		public String[] getSecurityIds() {
			return securityIds;
		}
		public void setSecurityIds(String[] securityIds) {
			this.securityIds = securityIds;
		}
		public long getUniformTypeId() {
			return uniformTypeId;
		}
		public void setUniformTypeId(long uniformTypeId) {
			this.uniformTypeId = uniformTypeId;
		}
		public long getUniformSizeId() {
			return uniformSizeId;
		}
		public void setUniformSizeId(long uniformSizeId) {
			this.uniformSizeId = uniformSizeId;
		}
		public String getUniformSize() {
			return uniformSize;
		}
		public void setUniformSize(String uniformSize) {
			this.uniformSize = uniformSize;
		}
		public String getUniformName() {
			return uniformName;
		}
		public void setUniformName(String uniformName) {
			this.uniformName = uniformName;
		}
		public long getSavedUniformSize() {
			return savedUniformSize;
		}
		public void setSavedUniformSize(long savedUniformSize) {
			this.savedUniformSize = savedUniformSize;
		}
		public List<Worker> getUniformTypeList() {
			return uniformTypeList;
		}
		public void setUniformTypeList(List<Worker> uniformTypeList) {
			this.uniformTypeList = uniformTypeList;
		}
		public List<Worker> getUniformSizeList() {
			return uniformSizeList;
		}
		public void setUniformSizeList(List<Worker> uniformSizeList) {
			this.uniformSizeList = uniformSizeList;
		}
		public List<Worker> getUniformTypeSizeList() {
			return uniformTypeSizeList;
		}
		public void setUniformTypeSizeList(List<Worker> uniformTypeSizeList) {
			this.uniformTypeSizeList = uniformTypeSizeList;
		}
		public List<Worker> getPersonnelRateList() {
			return personnelRateList;
		}
		public void setPersonnelRateList(List<Worker> personnelRateList) {
			this.personnelRateList = personnelRateList;
		}
		public List<Worker> getPersonnelRateTypesList() {
			return personnelRateTypesList;
		}
		public void setPersonnelRateTypesList(List<Worker> personnelRateTypesList) {
			this.personnelRateTypesList = personnelRateTypesList;
		}
		public long getNewPersonnelRateId() {
			return newPersonnelRateId;
		}
		public void setNewPersonnelRateId(long newPersonnelRateId) {
			this.newPersonnelRateId = newPersonnelRateId;
		}
		public String getPreference() {
			return preference;
		}
		public void setPreference(String preference) {
			this.preference = preference;
		}
		public long getCount() {
			return count;
		}
		public void setCount(long count) {
			this.count = count;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getEventType() {
			return eventType;
		}
		public void setEventType(String eventType) {
			this.eventType = eventType;
		}
		public String getUniformType() {
			return uniformType;
		}
		public void setUniformType(String uniformType) {
			this.uniformType = uniformType;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getRate() {
			return rate;
		}
		public void setRate(String rate) {
			this.rate = rate;
		}
		public long getCheckedValue() {
			return checkedValue;
		}
		public void setCheckedValue(long checkedValue) {
			this.checkedValue = checkedValue;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getMiddleInitial() {
			return middleInitial;
		}
		public void setMiddleInitial(String middleInitial) {
			this.middleInitial = middleInitial;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getSsn() {
			return ssn;
		}
		public void setSsn(String ssn) {
			this.ssn = ssn;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getPlaceofBirth() {
			return placeofBirth;
		}
		public void setPlaceofBirth(String placeofBirth) {
			this.placeofBirth = placeofBirth;
		}
		public String getActive() {
			return active;
		}
		public void setActive(String active) {
			this.active = active;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getSuite() {
			return suite;
		}
		public void setSuite(String suite) {
			this.suite = suite;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getZip() {
			return zip;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}
		public String getWorkPhone() {
			return workPhone;
		}
		public void setWorkPhone(String workPhone) {
			this.workPhone = workPhone;
		}
		public String getHomePhone() {
			return homePhone;
		}
		public void setHomePhone(String homePhone) {
			this.homePhone = homePhone;
		}
		public String getCell() {
			return cell;
		}
		public void setCell(String cell) {
			this.cell = cell;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getQuestion1() {
			return question1;
		}
		public void setQuestion1(String question1) {
			this.question1 = question1;
		}
		public String getAnswer1() {
			return answer1;
		}
		public void setAnswer1(String answer1) {
			this.answer1 = answer1;
		}
		public String getQuestion2() {
			return question2;
		}
		public void setQuestion2(String question2) {
			this.question2 = question2;
		}
		public String getAnswer2() {
			return answer2;
		}
		public void setAnswer2(String answer2) {
			this.answer2 = answer2;
		}
		public String getQuestion3() {
			return question3;
		}
		public void setQuestion3(String question3) {
			this.question3 = question3;
		}
		public String getAnswer3() {
			return answer3;
		}
		public void setAnswer3(String answer3) {
			this.answer3 = answer3;
		}
		public String getLoginid() {
			return loginid;
		}
		public void setLoginid(String loginid) {
			this.loginid = loginid;
		}
		public String getPants() {
			return pants;
		}
		public void setPants(String pants) {
			this.pants = pants;
		}
		public String getShoe() {
			return shoe;
		}
		public void setShoe(String shoe) {
			this.shoe = shoe;
		}
		public String getPoloTshirt() {
			return poloTshirt;
		}
		public void setPoloTshirt(String poloTshirt) {
			this.poloTshirt = poloTshirt;
		}
		public String getDressShirt() {
			return dressShirt;
		}
		public void setDressShirt(String dressShirt) {
			this.dressShirt = dressShirt;
		}
		public String getUserIds() {
			return userIds;
		}
		public void setUserIds(String userIds) {
			this.userIds = userIds;
		}
		public String getWorkerFlag() {
			return workerFlag;
		}
		public void setWorkerFlag(String workerFlag) {
			this.workerFlag = workerFlag;
		}
		public long getSchId() {
			return schId;
		}
		public void setSchId(long schId) {
			this.schId = schId;
		}
		public long getEventId() {
			return eventId;
		}
		public void setEventId(long eventId) {
			this.eventId = eventId;
		}
		public long getWorkerTypeId() {
			return workerTypeId;
		}
		public void setWorkerTypeId(long workerTypeId) {
			this.workerTypeId = workerTypeId;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getCovidVaccineCertificateimageName() {
			return covidVaccineCertificateimageName;
		}
		public void setCovidVaccineCertificateimageName(String covidVaccineCertificateimageName) {
			this.covidVaccineCertificateimageName = covidVaccineCertificateimageName;
		}
		public int getManagePlusPreference() {
			return managePlusPreference;
		}
		public void setManagePlusPreference(int managePlusPreference) {
			this.managePlusPreference = managePlusPreference;
		}
		public List<Personnel> getStateList() {
			return stateList;
		}
		public void setStateList(List<Personnel> stateList) {
			this.stateList = stateList;
		}
		public List<Personnel> getEthnicityList() {
			return ethnicityList;
		}
		public void setEthnicityList(List<Personnel> ethnicityList) {
			this.ethnicityList = ethnicityList;
		}
		public List<Personnel> getWorkerTypeList() {
			return workerTypeList;
		}
		public void setWorkerTypeList(List<Personnel> workerTypeList) {
			this.workerTypeList = workerTypeList;
		}
		@Override
		public String toString() {
			return "Worker [id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", notesId=" + notesId
					+ ", resourceId=" + resourceId + ", userId=" + userId + ", notes=" + notes + ", certificateId="
					+ certificateId + ", certificateName=" + certificateName + ", createdBy=" + createdBy
					+ ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", paymentMode=" + paymentMode
					+ ", nameOnCheck=" + nameOnCheck + ", taxId=" + taxId + ", bank=" + bank + ", routing=" + routing
					+ ", account=" + account + ", adpNumber=" + adpNumber + ", rate1=" + rate1 + ", rate2=" + rate2
					+ ", rate3=" + rate3 + ", cutoffTimeBefore=" + cutoffTimeBefore + ", cutoffTimeAfter="
					+ cutoffTimeAfter + ", minPayHours=" + minPayHours + ", suspendPay=" + suspendPay + ", overhead="
					+ overhead + ", workerList=" + workerList + ", workers=" + workers + ", workersDataList="
					+ workersDataList + ", certificationId=" + certificationId + ", certificationExpiryDate="
					+ certificationExpiryDate + ", certificateActive=" + certificateActive + ", certificationNotes="
					+ certificationNotes + ", workerCertificateimageName=" + workerCertificateimageName
					+ ", caterDocsId=" + caterDocsId + ", managePreference=" + managePreference + ", startTime="
					+ startTime + ", endTime=" + endTime + ", createdOn=" + createdOn + ", createdUser_id="
					+ createdUser_id + ", startDate=" + startDate + ", endDate=" + endDate + ", cisNo=" + cisNo
					+ ", eventExceptionId=" + eventExceptionId + ", dayFlag1=" + dayFlag1 + ", dayFlag2=" + dayFlag2
					+ ", chk2DisableFalg=" + chk2DisableFalg + ", effectDateId=" + effectDateId + ", groupId=" + groupId
					+ ", personalTypeId=" + personalTypeId + ", reconcileCheck=" + reconcileCheck + ", scheduledCheck="
					+ scheduledCheck + ", rates=" + Arrays.toString(rates) + ", ids=" + Arrays.toString(ids)
					+ ", checkedValues=" + Arrays.toString(checkedValues) + ", weekDate=" + weekDate
					+ ", uploadContentType=" + uploadContentType + ", uploadFileName=" + uploadFileName + ", fileType="
					+ fileType + ", covidVaccineCertificateimageContentType=" + covidVaccineCertificateimageContentType
					+ ", covidVaccineCertificateimageuploadFileName=" + covidVaccineCertificateimageuploadFileName
					+ ", covidVaccineCertificateimageFileType=" + covidVaccineCertificateimageFileType
					+ ", covidVaccineCertificateimageId=" + covidVaccineCertificateimageId + ", suffix=" + suffix
					+ ", hireDate=" + hireDate + ", terminationDate=" + terminationDate + ", workerType=" + workerType
					+ ", contractExpiryDate=" + contractExpiryDate + ", citizenship=" + citizenship + ", ethnicity="
					+ ethnicity + ", fax=" + fax + ", pager=" + pager + ", sortOrder=" + sortOrder + ", doubleBooking="
					+ doubleBooking + ", addressId=" + addressId + ", userName=" + userName + ", passWord=" + passWord
					+ ", paperWork=" + paperWork + ", transportation=" + transportation + ", preferredWorker="
					+ preferredWorker + ", vaccineName=" + vaccineName + ", vaccinatedDate=" + vaccinatedDate
					+ ", agency=" + agency + ", emergencyContactName=" + emergencyContactName
					+ ", emergencyContactNumber=" + emergencyContactNumber + ", emergencyEmail=" + emergencyEmail
					+ ", tuxedo=" + tuxedo + ", height=" + height + ", weight=" + weight + ", jacket=" + jacket
					+ ", collar=" + collar + ", waist=" + waist + ", inseam=" + inseam + ", priority=" + priority
					+ ", floor=" + floor + ", kitchen=" + kitchen + ", attendance=" + attendance + ", ability="
					+ ability + ", attitude=" + attitude + ", appearance=" + appearance + ", tardiness=" + tardiness
					+ ", comments=" + comments + ", freeLancerFlag=" + freeLancerFlag + ", fsd=" + fsd + ", fsdSize="
					+ fsdSize + ", privateHome=" + privateHome + ", privateHomeSize=" + privateHomeSize + ", tasting="
					+ tasting + ", tastingSize=" + tastingSize + ", uniformTypeIds=" + Arrays.toString(uniformTypeIds)
					+ ", uniformSizeIds=" + Arrays.toString(uniformSizeIds) + ", securityList=" + securityList
					+ ", expiryDate=" + expiryDate + ", securityNo=" + securityNo + ", expiryDates="
					+ Arrays.toString(expiryDates) + ", securityNos=" + Arrays.toString(securityNos) + ", securityIds="
					+ Arrays.toString(securityIds) + ", uniformTypeId=" + uniformTypeId + ", uniformSizeId="
					+ uniformSizeId + ", uniformSize=" + uniformSize + ", uniformName=" + uniformName
					+ ", savedUniformSize=" + savedUniformSize + ", uniformTypeList=" + uniformTypeList
					+ ", uniformSizeList=" + uniformSizeList + ", uniformTypeSizeList=" + uniformTypeSizeList
					+ ", personnelRateList=" + personnelRateList + ", personnelRateTypesList=" + personnelRateTypesList
					+ ", newPersonnelRateId=" + newPersonnelRateId + ", preference=" + preference + ", count=" + count
					+ ", location=" + location + ", eventType=" + eventType + ", uniformType=" + uniformType + ", date="
					+ date + ", type=" + type + ", rate=" + rate + ", checkedValue=" + checkedValue + ", firstName="
					+ firstName + ", middleInitial=" + middleInitial + ", lastName=" + lastName + ", sex=" + sex
					+ ", ssn=" + ssn + ", dateOfBirth=" + dateOfBirth + ", placeofBirth=" + placeofBirth + ", active="
					+ active + ", street=" + street + ", suite=" + suite + ", city=" + city + ", state=" + state
					+ ", zip=" + zip + ", workPhone=" + workPhone + ", homePhone=" + homePhone + ", cell=" + cell
					+ ", email=" + email + ", question1=" + question1 + ", answer1=" + answer1 + ", question2="
					+ question2 + ", answer2=" + answer2 + ", question3=" + question3 + ", answer3=" + answer3
					+ ", loginid=" + loginid + ", pants=" + pants + ", shoe=" + shoe + ", poloTshirt=" + poloTshirt
					+ ", dressShirt=" + dressShirt + ", userIds=" + userIds + ", workerFlag=" + workerFlag + ", schId="
					+ schId + ", eventId=" + eventId + ", workerTypeId=" + workerTypeId + ", fileName=" + fileName
					+ ", covidVaccineCertificateimageName=" + covidVaccineCertificateimageName
					+ ", managePlusPreference=" + managePlusPreference + ", stateList=" + stateList + ", ethnicityList="
					+ ethnicityList + ", workerTypeList=" + workerTypeList + "]";
		}
		
		
}
