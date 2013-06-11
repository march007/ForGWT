package ru.vrn.com.shared.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ru.vrn.com.shared.model.superclass.Versioned;


@Entity
@Table(name = "Users_AD")
public class UsersAD extends Versioned implements Serializable {
	
	@Column(name ="NAME", columnDefinition = "VARCHAR(255)", nullable = false)
	private String name;
	
	@Column(name = "DEPARTMENT", columnDefinition = "VARCHAR(255)", nullable = true)
	private String department;
	
	@Column(name = "ACCOUNT", columnDefinition = "VARCHAR(255)", nullable = false)
	private String account; 
	
	@Column(name="DESCRIPTION", columnDefinition = "VARCHAR(255)", nullable = true)
	private String description;
	
	@Column(name="STATUS", columnDefinition = "SMALLINT", nullable = false)
	private boolean status;
	
	@Column(nullable = true)
	private String extraAttribute1;
	
	@Column(nullable = true)
	private String extraAttribute2;
	
	@Column(nullable = true)
	private String extraAttribute3;
	
	@Column(nullable = true)
	private String extraAttribute4;
	
	@Column(nullable = true)
	private String extraAttribute5;

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getAccount() {
		return account;
	}

	public String getDescription() {
		return description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setDepartment(String department) {
		this.department = department;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getExtraAttribute1() {
		return extraAttribute1;
	}

	public String getExtraAttribute2() {
		return extraAttribute2;
	}

	public String getExtraAttribute3() {
		return extraAttribute3;
	}

	public String getExtraAttribute4() {
		return extraAttribute4;
	}

	public String getExtraAttribute5() {
		return extraAttribute5;
	}

	public void setExtraAttribute1(String extraAttribute1) {
		this.extraAttribute1 = extraAttribute1;
	}

	public void setExtraAttribute2(String extraAttribute2) {
		this.extraAttribute2 = extraAttribute2;
	}

	public void setExtraAttribute3(String extraAttribute3) {
		this.extraAttribute3 = extraAttribute3;
	}

	public void setExtraAttribute4(String extraAttribute4) {
		this.extraAttribute4 = extraAttribute4;
	}

	public void setExtraAttribute5(String extraAttribute5) {
		this.extraAttribute5 = extraAttribute5;
	}
}