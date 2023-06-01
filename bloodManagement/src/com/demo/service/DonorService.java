package com.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dem.VO.DonorVO;
import com.demo.BO.DonorBO;
import com.demo.Exception.DonorException;
import com.demo.Exception.DonorNotFoundException;
import com.demo.response.ResponseObject;

public class DonorService {

	// donorService service=new donorService();
	DonorBO donorBo = new DonorBO();
	ResponseObject response = new ResponseObject();

	DonorVO donorVo = new DonorVO();

	public ResponseObject addDonor(DonorVO donorVo)  {
		boolean flag;

		try {
			flag = donorBo.addDonor(donorVo);
			if (flag) {
				response.setSuccessMessage("donorID" + " " + donorVo.getDonorId() + "added successfully");
			} else {
				throw new DonorException("donorId" + " " + donorVo.getDonorId() + " can't be inserted");
			}

		} catch (DonorException e) {
			// TODO Auto-generated catch block
			response.setFailearMassage(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.setFailearMassage(e.getMessage());
		}
		return response;
	}

	public ResponseObject Updatedonor(DonorVO donorVo) {
		// donorVO vo = new donorVO();
		try {
			boolean result = donorBo.updateDonor(donorVo);

			if (result) {
				response.setSuccessMessage("donorID" + " " + donorVo.getDonorId() + "updated successfully");
			} else {
				throw new DonorException("donorId"+" "+donorVo.getDonorId()+"can't be updated");
			}

		} catch (DonorException e) {
			// TODO Auto-generated catch block
			response.setFailearMassage(e.getMessage());
		}
		return response;

	}

	public ResponseObject fetchDonor(int donorId) {
		DonorVO donorVo = new DonorVO();

		try {
			donorVo = donorBo.fetchDonor(donorId);
			response.setDonorvo(donorVo);

		} catch (DonorNotFoundException e) {
			response.setFailearMassage(e.getMessage());
		}
		return response;
	}

	public ResponseObject fetchAllDonor(){
		try {
			List<DonorVO> listOfDonor;
			listOfDonor = donorBo.fetchAllDonor();
			response.setListOfDonor(listOfDonor);

			if (listOfDonor.isEmpty()) {
				response.setFailearMassage("Empty list");
			} else {
				response.setListOfDonor(listOfDonor);
			}

		} catch (DonorNotFoundException e) {
			response.setFailearMassage(e.getMessage());
		}
		return response;
	}
}
