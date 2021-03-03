package in.co.rays.project_3.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Student JavaDto encapsulates student attributes
 * @author Mayank mishra
 *
 */

public class StudentDTO extends BaseDTO {

	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNo;
	private long collegeId;
	private Date dob;
	private String collegeName;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id+" ";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return firstName+""+lastName;
	}

}
