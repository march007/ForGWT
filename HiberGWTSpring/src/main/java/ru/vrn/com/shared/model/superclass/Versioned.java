package ru.vrn.com.shared.model.superclass;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class Versioned {

	@Id
	@GenericGenerator(name = "my_gen_id", strategy = "sequence", parameters = { @org.hibernate.annotations.Parameter(name = "sequence", value = "idcounter") })
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_gen_id")
	@Column(name = "ID", columnDefinition = "BIGINT")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}