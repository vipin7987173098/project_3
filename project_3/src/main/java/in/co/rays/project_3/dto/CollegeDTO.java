package in.co.rays.project_3.dto;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * College JavaBean encapsulates College attributes
 * @author Mayank mishra
 *
 */

public class CollegeDTO extends BaseDTO
{
	private String name;
	private String address;
	private String city;
	private String state;
	private String phoneNo;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getKey() {
		
		return id+"";
	}

	public String getValue() {
		
		return name+"";
	}

}
