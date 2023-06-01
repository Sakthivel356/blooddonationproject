package com.demo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dem.VO.DonorVO;
import com.dem.VO.DonorVO;
import com.demo.BO.DonorBO;
import com.demo.Exception.DonorException;
import com.demo.Exception.DonorNotFoundException;
import com.demo.main.DonorMain;

public class DonorDAO implements Iblood {
	DonorVO donorVo = new DonorVO();
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<DonorVO> listOfDonor = new ArrayList<>();
	 static Logger log = Logger.getLogger(DonorMain.class.getName()); 

	public boolean addDonor(DonorVO donorVo) throws DonorException, SQLException {

		boolean flag = false;

		try {
			conn = DriverManager.getConnection(url, user, pwd);
			String query = "insert into donor_details values(?,?,?,?,?,?,?);";
			ps = conn.prepareStatement(query);

			ps.setInt(1, donorVo.getDonorId());
			ps.setString(2, donorVo.getDonoName());
			ps.setInt(3, donorVo.getDonorAge());
			ps.setInt(4, donorVo.getGenderId());
			ps.setLong(5, donorVo.getDonorContact());
			ps.setInt(6, donorVo.getDonorWeight());
			ps.setInt(7, donorVo.getAddressId());

			int i = ps.executeUpdate();
			//System.out.println(i);
			if (i > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DonorException(donorVo.getDonorId()+"can't be inserted in database.please raise a mail to admin team",e);

		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				throw new DonorException("Error when closing connection");

			}
		}

		return flag;

	}

	public boolean updateDonor(DonorVO donorVo) throws DonorException {

		boolean flag = false;

		try {
			conn = DriverManager.getConnection(url, user, pwd);
			String query = "update donor_details set donor_name=?,donor_age=?,donor_weight=? where donor_id=?;";
			ps = conn.prepareStatement(query);

			ps.setString(1, donorVo.getDonoName());
			ps.setInt(2, donorVo.getDonorAge());
			ps.setInt(3, donorVo.getDonorWeight());
			ps.setInt(4, donorVo.getDonorId());

			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			throw new DonorException(donorVo.getDonorId()+"can't be updated.please check the Donor Id ");
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				throw new DonorException("Error when closing connection");
			}
		}

		return flag;
	}

	public DonorVO fetchDonor(int donorId) throws DonorNotFoundException {

		try {
			conn = DriverManager.getConnection(url, user, pwd);
			String query = "select *from donor_details where donor_id=? ;";
			ps = conn.prepareStatement(query);

			ps.setInt(1, donorId);

			rs = ps.executeQuery();
			rs.first();

			donorVo.setDonorId(rs.getInt("donor_id"));
			donorVo.setDonoName(rs.getString("donor_name"));
			donorVo.setDonorAge(rs.getInt("donor_age"));
			donorVo.setGenderId(rs.getInt("gender_id"));
			donorVo.setDonorContact(rs.getLong("donor_contact"));
			donorVo.setDonorWeight(rs.getInt("donor_weight"));
			donorVo.setAddressId(rs.getInt("address_id"));
			
			log.info(donorVo);
			log.info(donorId+" Id details Fetched succesfully");
			log.info("--------------------------------------------");

		} catch (SQLException e) {
			log.error("error while Fetched donor", e);
			log.warn("Fetch Donor process not completed.Due to bug");
			throw new DonorNotFoundException(donorId + "donor data can't be fetched",e);
			
		} finally {
			try {
				conn.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				throw new DonorNotFoundException("Error when closing connection ");
			}
		}

		return donorVo;

	}

	public List<DonorVO> fetchAllDonor() throws DonorNotFoundException {
		log.info("Fetch All Process Started Succesfully");

		try {
			conn = DriverManager.getConnection(url, user, pwd);
			String query = "select *from donor_details  ;";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {
				DonorVO donorVo = new DonorVO();
				donorVo.setDonorId(rs.getInt("donor_id"));
				donorVo.setDonoName(rs.getString("donor_name"));
				donorVo.setDonorAge(rs.getInt("donor_age"));
				donorVo.setGenderId(rs.getInt("gender_id"));
				donorVo.setDonorContact(rs.getLong("donor_contact"));
				donorVo.setDonorWeight(rs.getInt("donor_weight"));
				donorVo.setAddressId(rs.getInt("address_id"));
				listOfDonor.add(donorVo);
				
				log.info(donorVo);
				
				log.info("Fetched All Donor Details Sucesfully");
				log.info("-----------------------------------------");
			}
		} catch (SQLException e) {
			log.error("error while updating donor", e);
			log.warn("Fetche All Donor Details  process not completed.Due to bug");
			throw new DonorNotFoundException("donor Details not found");
		} finally {
			try {
				ps.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				throw new DonorNotFoundException("Error when closing connection");
			}
		}

		return listOfDonor;

	}

}
