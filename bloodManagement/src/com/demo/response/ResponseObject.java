package com.demo.response;

import java.util.List;

import com.dem.VO.DonorVO;

public class ResponseObject {

	String successMessage;
	String failearMassage;
	DonorVO donorvo;
	List<DonorVO>listOfDonor;
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getFailearMassage() {
		return failearMassage;
	}
	public void setFailearMassage(String failearMassage) {
		this.failearMassage = failearMassage;
	}
	public DonorVO getDonorvo() {
		return donorvo;
	}
	public void setDonorvo(DonorVO donorvo) {
		this.donorvo = donorvo;
	}
	public List<DonorVO> getListOfDonor() {
		return listOfDonor;
	}
	public void setListOfDonor(List<DonorVO> listOfDonor) {
		this.listOfDonor = listOfDonor;
	}
	
}
