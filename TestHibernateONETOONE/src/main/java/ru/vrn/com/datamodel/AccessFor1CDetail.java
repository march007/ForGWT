package ru.vrn.com.datamodel;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ru.vrn.com.datamodel.superclass.Versioned;

@Entity
@Table(name = "Access_For_1C_Detail")
public class AccessFor1CDetail extends Versioned implements Serializable{
	
	public AccessFor1CDetail() {
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Access1C")
	private AccessFor1C accessFor1C;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Base1C")
	private ListOfMonitoring listOfMonitoring;

	public ListOfMonitoring getListOfMonitoring() {
		return listOfMonitoring;
	}

	public void setListOfMonitoring(ListOfMonitoring listOfMonitoring) {
		this.listOfMonitoring = listOfMonitoring;
	}

	public AccessFor1C getAccessFor1C() {
		return accessFor1C;
	}

//	public ListOfMonitoring getListOfBases1C() {
//		return listOfMonitoring;
//	}

	public void setAccessFor1C(AccessFor1C accessFor1C) {
		this.accessFor1C = accessFor1C;
	}

//	public void setListOfBases1C(ListOfMonitoring listOfBases1C) {
//		this.listOfMonitoring = listOfBases1C;
//	}

}
