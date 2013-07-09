package ru.vrn.com.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ru.vrn.com.datamodel.superclass.Versioned;

@Entity
@Table(name = "Access_File_Resourses_Detail")
public class AccessFileResoursesDetail extends Versioned {

//	@OneToMany(mappedBy = "id", targetEntity = AccessFileResourses.class)
//	private Set<AccessFileResourses> accessFileResoursesItems;

	@ManyToOne
	@JoinColumn(name = "id_Access_File_Resourses")
	private AccessFileResourses accessFileResourses;

	@Column(name = "PATH", columnDefinition = "VARCHAR(255)", nullable = false)
	private String path;

//	 public Set<AccessFileResourses> getAccessFileResoursesItems() {
//	 return accessFileResoursesItems;
//	 }

	public AccessFileResourses getDictionary() {
		return accessFileResourses;
	}

	public String getPath() {
		return path;
	}

//	 public void setAccessFileResoursesItems(
//	 Set<AccessFileResourses> accessFileResoursesItems) {
//	 this.accessFileResoursesItems = accessFileResoursesItems;
//	 }

	public void setDictionary(AccessFileResourses dictionary) {
		this.accessFileResourses = dictionary;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
