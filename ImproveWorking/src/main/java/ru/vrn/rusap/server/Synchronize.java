package ru.vrn.rusap.server;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class Synchronize {
	
	private HibernateTemplate template;
	public Synchronize() {
	}

	public Synchronize(HibernateTemplate template) {
		this.template = template;
		System.out.println("Synchronize Synchronize Synchronize");
	}
	
	
}
