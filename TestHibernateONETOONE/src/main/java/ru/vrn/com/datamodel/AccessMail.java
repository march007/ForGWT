package ru.vrn.com.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ru.vrn.com.datamodel.superclass.Access;

@Entity
@Table(name = "Access_Mail")
public class AccessMail extends Access {

	@Column(name = "MAIL_ACCESS", columnDefinition = "VARCHAR(255)", nullable = false)
	private String mailAccess;

	public String getMailAccess() {
		return mailAccess;
	}

	public void setMailAccess(String mailAccess) {
		this.mailAccess = mailAccess;
	}
}
