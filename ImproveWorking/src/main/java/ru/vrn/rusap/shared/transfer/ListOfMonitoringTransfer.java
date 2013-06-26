package ru.vrn.rusap.shared.transfer;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ru.vrn.rusap.shared.model.superclass.Modification;

public class ListOfMonitoringTransfer implements Serializable {
	
	public ListOfMonitoringTransfer() {
	}
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Timestamp DateLastModification;

	public Timestamp getDateLastMofification() {
		return DateLastModification;
	}

	public void setDateLastMofification(Timestamp dateLastMofification) {
		DateLastModification = dateLastMofification;
	}
	private String path;

	private String host;

	private boolean sqlActive;
	
	private String srv;
	
	private String ref;
	
	private String Version;
	
	private String hostPassword;
	
	private String hostUser;
	
	private String domain;
	
	private String user;
	
	private String program1cPassword;
	
	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
//		if (sqlActive)
		this.ref = ref;
	}

	public String getSrv() {
		return srv;
	}

	public void setSrv(String srv) {
//		if (sqlActive)
		this.srv = srv;
	}

	public boolean isSqlActive() {
		return sqlActive;
	}

	public void setSqlActive(boolean sqlActive) {
		this.sqlActive = sqlActive;
	}

	public String getPath() {
		return path;
	}

	public String getHost() {
		return host;
	}

	public void setPath(String path) {
//		if (!sqlActive)
		this.path = path;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getHostPassword() {
		return hostPassword;
	}

	public void setHostPassword(String hostPassword) {
		this.hostPassword = hostPassword;
	}

	public String getHostUser() {
		return hostUser;
	}

	public void setHostUser(String hostUser) {
		this.hostUser = hostUser;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getProgram1cPassword() {
		return program1cPassword;
	}

	public void setProgram1cPassword(String program1cPassword) {
		this.program1cPassword = program1cPassword;
	}
	
	@Override
	public String toString() {
		String toString = domain +" | "+ host + " | "+ hostPassword+" | "+hostUser +"" +
				" | " + path +" | "+ program1cPassword + " | "+ ref + " | "+ srv + " | "+ user+"" +
						" | "+ Version+" | " + sqlActive +" |" + getDateLastMofification()+" |" +
						getId();
		
		
		return toString;
	}
}
