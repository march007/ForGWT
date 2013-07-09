package ru.vrn.com.datamodel;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ru.vrn.com.datamodel.superclass.Modification;

@Entity
@Table(name = "List_Of_Monitoring")
public class ListOfMonitoring extends Modification implements Serializable {
	
	public ListOfMonitoring() {
	}

	@Column(name = "PATH", columnDefinition = "VARCHAR(255)", nullable = true)
	private String path;

	@Column(name = "HOST", columnDefinition = "VARCHAR(50)", nullable = false)
	private String host;

	//���� sqlActive = true  ����� ���� sql, ����� �������� ����. 
	@Column(name = "SQlActive", nullable = false)
	private boolean sqlActive;
	
	@Column(name = "SERVER", nullable = true)
	private String srv;
	
	@Column(name = "REF", nullable = true)
	private String ref;
	
	@Column(name = "VERSION", nullable = false)
	private String Version;
	
	@Column(name = "HOST_PASSWORD", nullable = false)
	private String hostPassword;
	
	@Column(name = "HOST_USER", nullable = false)
	private String hostUser;
	
	@Column(name = "DOMAIN", nullable = false)
	private String domain;
	
	@Column(name = "PROGRAMM_USER", nullable = false)
	private String user;
	
	@Column(name = "PROGRAMM_1C_PASSWORD", nullable = false)
	private String program1cPassword;
	
	@OneToMany(mappedBy = "listOfMonitoring", targetEntity = AccessFor1CDetail.class, cascade = CascadeType.ALL)
	private Set<AccessFor1CDetail> accessFor1CDetail;

	public Set<AccessFor1CDetail> getAccessFor1CDetail() {
		return accessFor1CDetail;
	}

	public void setAccessFor1CDetail(Set<AccessFor1CDetail> accessFor1CDetail) {
		this.accessFor1CDetail = accessFor1CDetail;
	}
	
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
						" | "+ Version+" | " + sqlActive +" |" + super.getDateLastMofification()+" |" +
						super.getId();
		
		
		return toString;
	}
}
