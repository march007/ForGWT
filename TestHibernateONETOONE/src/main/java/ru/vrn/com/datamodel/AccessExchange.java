package ru.vrn.com.datamodel;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import ru.vrn.com.datamodel.superclass.Access;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
@Table(name = "Access_Exchange")
public class AccessExchange extends Access implements Serializable {

	
//	protected String emailNew;
//
//	public String getEmailNew() {
//		return emailNew;
//	}
//
//	public void setEmailNew(String emailNew) {
//		this.emailNew = emailNew;
//	}
}
