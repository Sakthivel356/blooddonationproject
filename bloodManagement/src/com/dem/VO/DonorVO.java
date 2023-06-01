package com.dem.VO;

public class DonorVO {

	private int donorId;
	private String donoName;
	private int donorAge;
	private int genderId;
	private long donorContact;
	private int donorWeight;
	private int addressId;

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public String getDonoName() {
		return donoName;
	}

	public void setDonoName(String donoName) {
		this.donoName = donoName;
	}

	public int getDonorAge() {
		return donorAge;
	}

	public void setDonorAge(int donorAge) {
		this.donorAge = donorAge;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public long getDonorContact() {
		return donorContact;
	}

	public void setDonorContact(long donorContact) {
		this.donorContact = donorContact;
	}

	public int getDonorWeight() {
		return donorWeight;
	}

	public void setDonorWeight(int donorWeight) {
		this.donorWeight = donorWeight;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "donorVO [donorId=" + donorId + ", donoName=" + donoName + ", donorAge=" + donorAge + ", genderId="
				+ genderId + ", donorContact=" + donorContact + ", donorWeight=" + donorWeight + ", addressId="
				+ addressId + "]";
	}

}
