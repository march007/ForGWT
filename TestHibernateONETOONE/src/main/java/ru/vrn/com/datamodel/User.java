package ru.vrn.com.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ru.vrn.com.datamodel.superclass.Versioned;

@Entity
@Table(name = "Person")
public class User extends Versioned {

	@Column(name = "LOGIN", columnDefinition = "VARCHAR(70)", nullable = false)
	private String login;

	@Column(name = "PASS", columnDefinition = "VARCHAR(20)", nullable = false)
	private String password;

	@Column(name = "MAIL", columnDefinition = "VARCHAR(70)", nullable = false)
	private String mail;

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getMail() {
		return mail;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
