package ru.vrn.com.shared.model.superclass;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Modification extends Versioned {

	@Column(name = "date_Last_Modification", nullable = false)
	private Timestamp DateLastModification;

	public Timestamp getDateLastMofification() {
		return DateLastModification;
	}

	public void setDateLastMofification(Timestamp dateLastMofification) {
		DateLastModification = dateLastMofification;
	}

}
