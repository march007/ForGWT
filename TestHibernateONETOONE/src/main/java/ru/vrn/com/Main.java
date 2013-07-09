package ru.vrn.com;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;

import ru.vrn.com.datamodel.Accordance;
import ru.vrn.com.datamodel.utils.HibernateSessionFactory;

public class Main {
	public static void main(String[] args) {

		Timestamp lastTimestamp = null;

		Session session = HibernateSessionFactory.getSession();

		while (true) {
			List<Accordance> listAccordance = session.createCriteria(
					Accordance.class).list();
			if (listAccordance.size() > 0) {
				lastTimestamp = listAccordance.get(0).getDateLastMofification();
			}

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			int hour = timestamp.getHours();
			LogIt.log("Началось! " + hour);
			int diff = (lastTimestamp.getDay() - timestamp.getDay());
			if (diff > 2) {

				if ((hour < 18)&&(hour > 8)) {
					int needTime = 23  - hour;
					try {
						Thread.sleep(needTime*3600000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				LogIt.log("Синхронизация началась в " + new Timestamp(System.currentTimeMillis()));
				new Synch(session);
				System.gc();
			}
			try {
				Thread.sleep(86400000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
