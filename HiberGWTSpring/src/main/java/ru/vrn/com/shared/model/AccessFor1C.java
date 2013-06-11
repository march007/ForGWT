package ru.vrn.com.shared.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ru.vrn.com.shared.model.superclass.Access;

@Entity
@Table(name = "Access_For_1C")
// @AttributeOverride(name = "id", column = @Column(name = "ID"))
public class AccessFor1C extends Access {

	// @Id
	// @GeneratedValue
	// private Long id;

	@OneToMany(mappedBy = "accessFor1C", targetEntity = AccessFor1CDetail.class, cascade = CascadeType.ALL)
	private Set<AccessFor1CDetail> accessFor1CDetail;

	public Set<AccessFor1CDetail> getAccessFor1CDetail() {
		return accessFor1CDetail;
	}

	public void setAccessFor1CDetail(Set<AccessFor1CDetail> accessFor1CDetail) {
		this.accessFor1CDetail = accessFor1CDetail;
	}

}
