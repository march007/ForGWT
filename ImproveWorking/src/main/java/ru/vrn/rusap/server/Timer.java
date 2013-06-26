package ru.vrn.rusap.server;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class Timer implements Runnable {

private HibernateTemplate template;	
	public Timer(HibernateTemplate template) {
		this.template = template;
	}
	
	@Override
	public void run() {
		System.out.println("lalalalala");
		
		try {
			this.wait(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Synchronize synchronize = new Synchronize(template);
		
		
			
	}

}
