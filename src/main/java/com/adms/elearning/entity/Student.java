package com.adms.elearning.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.adms.common.domain.BaseDomain;

@Entity
@Table(name="STUDENT")
public class Student extends BaseDomain {

	private static final long serialVersionUID = -2194350095604692690L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="CITIZEN_ID")
	private String citizenId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="MID_NAME")
	private String midName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="DATE_OF_BIRTH")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBirth;
	
	@Column(name="STREET_ADDRESS")
	private String streetAddress;
	
	@Column(name="CITI")
	private String citi;
	
	@Column(name="POST_CODE")
	private String postCode;
	
	@Column(name="HONE_PHONE")
	private String homePhone;
	
	@Column(name="OFFICE_PHONE")
	private String officePhone;
	
	@Column(name="MOBILE_PHONE")
	private String mobilePhone;
	
	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCiti() {
		return citi;
	}

	public void setCiti(String citi) {
		this.citi = citi;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
