package ru.vrn.com.datamodel;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ru.vrn.com.datamodel.superclass.Access;

@Entity
@Table(name = "Access_File_Resourses")
public class AccessFileResourses extends Access {
	
	@OneToMany(mappedBy = "accessFileResourses", targetEntity = AccessFileResoursesDetail.class)
	private Set<AccessFileResoursesDetail> AccessFileResoursesDetailItems;


	public Set<AccessFileResoursesDetail> getAccessFileResoursesDetailItems() {
		return AccessFileResoursesDetailItems;
	}


	public void setAccessFileResoursesDetailItems(
			Set<AccessFileResoursesDetail> accessFileResoursesDetailItems) {
		AccessFileResoursesDetailItems = accessFileResoursesDetailItems;
	}
	
}
