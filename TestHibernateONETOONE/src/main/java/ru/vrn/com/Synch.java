package ru.vrn.com;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ru.vrn.com.ad.AccessForActiveDirectory.UserRec;
import ru.vrn.com.context.AppContext;
import ru.vrn.com.datamodel.UsersAD;
import ru.vrn.com.util.Assistent;

public class Synch {

	private Session session;

	public Synch(Session session) {
		this.session = session;
		init();
	}

	private void init() {

		List<UsersAD> listUsers = session.createCriteria(UsersAD.class).list();

		List<String> listForCheckingUsersADFromDb = new ArrayList<String>();

		for (UsersAD it : listUsers) {
			listForCheckingUsersADFromDb.add(it.getAccount());
		}

		Assistent assistent = new Assistent();
		List<UserRec> listAD = assistent.getUserFromActiveDirectory();

		List<String> listForCheckingUsersADUserRec = new ArrayList<String>();

		for (UserRec string : listAD) {
			listForCheckingUsersADUserRec.add(string.getAccount());
		}

		if (listForCheckingUsersADFromDb
				.containsAll(listForCheckingUsersADUserRec)) {
		} else if (listForCheckingUsersADUserRec.size() > listForCheckingUsersADFromDb
				.size()) {

			listForCheckingUsersADUserRec
					.removeAll(listForCheckingUsersADFromDb);

			
			LogIt.log("ListUsersFromActiveDirectory . size : " + listAD.size());
			LogIt.log("listUsersFromDb . size : " + listUsers.size());

			List<UserRec> lastList = new ArrayList<UserRec>();
			for (UserRec it : listAD) {
				for (String string : listForCheckingUsersADUserRec) {
					if (it.getAccount().equals(string)) {
						LogIt.log(" Новые пользователи из Актив Директори, которых еще нет базе: " + it.getDescription1());
						lastList.add(it);
						break;
					}
				}
			}

			System.gc();
			new AppContext(session, lastList);
			new AppContext(session, listUsers, true);
		}
	}

}
