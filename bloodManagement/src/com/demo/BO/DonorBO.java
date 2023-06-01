package com.demo.BO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
//import java.util.logging.Logger;

import org.apache.log4j.Logger;

import com.dem.VO.DonorVO;
import com.dem.VO.DonorVO;
import com.demo.DAO.DonorDAO;
import com.demo.DAO.Iblood;
import com.demo.DAO.DonorDAO;
import com.demo.Exception.DonorException;
import com.demo.Exception.DonorNotFoundException;
import com.demo.logger.DonorEx;
import com.demo.main.DonorMain;
import com.demo.Exception.DonorException;
import com.demo.Exception.DonorNotFoundException;

public class DonorBO implements Iblood {

	DonorDAO donorDao = new DonorDAO();
	Connection conn = null;
	PreparedStatement ps = null;
	boolean flag1;
	
	 static Logger log = Logger.getLogger(DonorMain.class.getName());  
	 DonorVO donorVo = new DonorVO();
	  

	public boolean addDonor(DonorVO donorVo) throws DonorException, SQLException {

		log.info("Add Process Started Successfully");
		try {
			if (donorVo.getDonorAge() > 20 && donorVo.getDonorAge() < 60 && donorVo.getDonorWeight() > 50) {
				flag1 = donorDao.addDonor(donorVo);
			} else {
				throw new DonorException("check Age and Weight Limit");
			}
			
		  if(flag1) {
			  
			log.info(donorVo);
			log.info("add process completed succesfully");
			log.info("------------------------------------------------------------------------------");
			 
		  }
		} catch (DonorException e) {
			log.error("error while adding donor:", e);
			log.warn("Add process not completed.Due to bug:");
			throw new DonorException(e.getMessage());
		
		}

		

		return flag1;
	}

	public boolean updateDonor(DonorVO donorVo) throws DonorException {
		boolean flag2;
		log.info("Update Process Started Succesfully");
		try {
			if (donorVo.getDonorAge() > 20 && donorVo.getDonorAge() < 60 && donorVo.getDonorWeight() > 50) {
				flag2 = donorDao.updateDonor(donorVo);
			} else {
				throw new DonorException("check Age and Weight Limit");
			}
			if(flag2) {
				 log.info(donorVo);
				 log.info("update process completed successfully");
				 log.info("---------------------------------------------------------------------------");
			}
		} catch (DonorException e) {
			log.error("error while updating donor", e);
			log.warn("update process not completed.Due to bug");
			throw new DonorException(e.getMessage());
		}
		return flag2;
	}

	public DonorVO fetchDonor(int donorId) throws DonorNotFoundException {
		log.info("Fetch Id Process Started Sucesfully");
		
		
		return donorDao.fetchDonor(donorId);

	}

	public List<DonorVO> fetchAllDonor() throws DonorNotFoundException {
		return donorDao.fetchAllDonor();
	}
}
