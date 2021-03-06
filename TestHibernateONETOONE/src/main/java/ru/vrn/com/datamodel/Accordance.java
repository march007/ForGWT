package ru.vrn.com.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ru.vrn.com.datamodel.superclass.Access;


@Entity
@Table(name = "Accordance")
public class Accordance extends Access {

	@Column(name = "computer", nullable = false)
	String computer;

	public String getComputer() {
		return computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}
}
