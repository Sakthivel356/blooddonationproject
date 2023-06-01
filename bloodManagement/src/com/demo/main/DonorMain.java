package com.demo.main;

//import java.lang.System.Logger;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
//import java.util.logging.Logger;

import org.apache.log4j.Logger;

import com.dem.VO.DonorVO;
import com.demo.BO.DonorBO;
import com.demo.DAO.DonorDAO;
import com.demo.Exception.DonorNotFoundException;
import com.demo.logger.DonorEx;
import com.demo.response.ResponseObject;
import com.demo.service.DonorService;
import com.mysql.cj.log.Log;

public class DonorMain {

	static DonorVO donorVo = new DonorVO();
	static DonorDAO donorDao = new DonorDAO();
	static DonorBO donorBo = new DonorBO();

	static Scanner scn = new Scanner(System.in);
	static DonorService service = new DonorService();
	 static Logger log = Logger.getLogger(DonorMain.class.getName());  
	  

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		log.info("Blood Donation Management Started ");	
		System.out.println("select the option");
		System.out.println("\n 1.add Donor\n 2.Update Donor\n 3.fetch Donor\n 4.fetch All Donor");
		int option = scn.nextInt();

		switch (option) {
		case 1:
			addDonor();
			break;
		case 2:
			updateDonor();
			break;
		case 3:
			fetchDonor();
			break;
		case 4:
			fetchAllDonor();

			break;
		default:
			System.out.println(" select a valid option");

		}

	}

	private static void addDonor() {
		// TODO Auto-generated method stub
		System.out.println("Enter the donor Id");
		int donorId = scn.nextInt();

		System.out.println("Enter the Donor Name");
		String donorName = scn.next();

		System.out.println("Enter the Donor Age");
		int donorAge = scn.nextInt();

		System.out.println("Enter the gender Id ");
		int genderId = scn.nextInt();

		System.out.println("Enter the Contact");
		long donorContact = scn.nextLong();

		System.out.println("Enter the donor weight");
		int donorWeight = scn.nextInt();

		System.out.println("Enter the address Id");
		int addressId = scn.nextInt();

		donorVo.setDonorId(donorId);
		donorVo.setDonoName(donorName);
		donorVo.setDonorAge(donorAge);
		donorVo.setGenderId(genderId);
		donorVo.setDonorContact(donorContact);
		donorVo.setDonorWeight(donorWeight);
		donorVo.setAddressId(addressId);

		ResponseObject response = service.addDonor(donorVo);

		if (response.getSuccessMessage() != null) {
			System.out.println(response.getSuccessMessage());
		} else {
			System.out.println(response.getFailearMassage());
		}
	}

	private static void updateDonor()  {
		// TODO Auto-generated method stub
		System.out.println("Enter donor Id");
		int donorId = scn.nextInt();

		System.out.println("Enter the donor Name");
		String donorName = scn.next();

		System.out.println("Enter the donor Age");
		int donorAge = scn.nextInt();

		System.out.println("Enter the donor Weight");
		int donorWeight = scn.nextInt();

		donorVo.setDonoName(donorName);
		donorVo.setDonorAge(donorAge);
		donorVo.setDonorWeight(donorWeight);
		donorVo.setDonorId(donorId);

		ResponseObject response = service.Updatedonor(donorVo);

		if (response.getSuccessMessage() != null) {
			System.out.println(response.getSuccessMessage());
		} else {
			System.out.println(response.getFailearMassage());
		}
	}

	private static void fetchDonor()  {
		// TODO Auto-generated method stub
		System.out.println("enter donor Id");
		int donorId = scn.nextInt();

		ResponseObject response = service.fetchDonor(donorId);
		donorVo = response.getDonorvo();

		if (donorVo != null) {
			System.out.println(
					"=========================================================================================================");
			System.out.println(
					"ID        NAME          AGE            GENDER ID           CONTACT           WEIGHT        ADDRESS ID");
			System.out.println(
					"==========================================================================================================");
			System.out.println(donorVo.getDonorId() + "\t" + donorVo.getDonoName() + "\t\t" + donorVo.getDonorAge()
					+ "\t\t" + donorVo.getGenderId() + "\t\t" + donorVo.getDonorContact() + "\t\t"
					+ donorVo.getDonorWeight() + "\t\t" + donorVo.getAddressId());
		} else {
			System.out.println(response.getFailearMassage());
		}
	}

	private static void fetchAllDonor()  {
		// TODO Auto-generated method stub
		ResponseObject response = new ResponseObject();
		DonorService service = new DonorService();
		response = service.fetchAllDonor();
		List<DonorVO> listOfDonor;
		listOfDonor = response.getListOfDonor();
		if ((listOfDonor != null) && (response.getFailearMassage() == null)) {
			System.out.println(
					"=========================================================================================================");
			System.out.println(
					"ID        NAME         AGE           GENDERID         CONTACT         WEIGHT       ADDRESS ID");
			System.out.println(
					"=========================================================================================================");
			for (DonorVO vo : listOfDonor) {
				System.out.println(vo.getDonorId() + "\t" + vo.getDonoName() + "\t\t" + vo.getDonorAge() + "\t\t"
						+ vo.getGenderId() + "  " + "\t" + vo.getDonorContact() + "\t\t" + vo.getDonorWeight() + "\t\t"
						+ vo.getAddressId());
			}

		} else {
			System.out.println(response.getFailearMassage());
		}
	}

}
