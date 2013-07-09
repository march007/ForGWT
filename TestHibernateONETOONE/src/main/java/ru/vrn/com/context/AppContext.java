package ru.vrn.com.context;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.NamingException;

import org.hibernate.Session;

import com.ipc.oce.exceptions.ConfigurationException;

import ru.vrn.com.LogIt;
import ru.vrn.com.access.internet.Mysql;
import ru.vrn.com.access.usb.MsSql;
import ru.vrn.com.ad.AccessForActiveDirectory.UserRec;
import ru.vrn.com.ad.exchange.AccessForExchange;
import ru.vrn.com.datamodel.AccessExchange;
import ru.vrn.com.datamodel.AccessFor1C;
import ru.vrn.com.datamodel.AccessFor1CDetail;
import ru.vrn.com.datamodel.AccessInternet;
import ru.vrn.com.datamodel.AccessMail;
import ru.vrn.com.datamodel.AccessUSB;
import ru.vrn.com.datamodel.AccessVPN;
import ru.vrn.com.datamodel.Accordance;
import ru.vrn.com.datamodel.ListOfMonitoring;
import ru.vrn.com.datamodel.UsersAD;
import ru.vrn.com.exception.JIExceptionCustom;

/**
 * 
 * Контекст приложения, предназначенный для конечной работы с базой данных.
 * Обновление или сохранение данных в базу данных.
 * 
 * @author marchenko
 * 
 * @create 16.06.2013
 * 
 */
public class AppContext {

	private Session session;
	private List<UserRec> lastList;
	private List<UsersAD> lastListUsersAD;

	private List<AccessVPN> listAccessVPN = new ArrayList<AccessVPN>();
	private List<AccessMail> listMails = new ArrayList<AccessMail>();

	public AppContext(Session session, List<UserRec> lastList) {
		this.lastList = lastList;
		this.session = session;
		tweak(false);
	}

	public AppContext(Session session, List<UsersAD> lastListUsersAD,
			boolean bool) {
		this.lastListUsersAD = lastListUsersAD;
		this.session = session;
		tweak(bool);
	}

	/**
	 * Предназначена для управления взаимодействием с базой данных.
	 * 
	 * @param b
	 *            - пармаетр, определяет подготовлен ли спиоск пользователей из
	 *            Active Directory. Если b = true, то список пользователей
	 *            подговтовлен и с ним можно продолжать взаимодействие. Если b =
	 *            false, то список пользователей не подговтовлен, и требуется
	 *            временный список пользователей привести в соответствие классу
	 *            UsersAD.
	 * 
	 * 
	 */
	private void tweak(boolean b) {
		this.session.beginTransaction();

		List<ListOfMonitoring> list = session.createCriteria(
				ListOfMonitoring.class).list();

		CheckUsers checkUsers = new CheckUsers(list, lastList);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		List<UsersAD> listUsers = new ArrayList<UsersAD>();
		List<String> listOnlyAccountAD = new ArrayList<String>();

		Map<ListOfMonitoring, List<UsersAD>> map = null;

		if (!b) {
			for (UserRec user : lastList) {
				UsersAD usersADs = new UsersAD();
				usersADs.setAccount(user.getAccount());
				usersADs.setDepartment(user.getDepartment());
				usersADs.setDescription(user.getDescription1());
				usersADs.setName(user.getName());
				usersADs.setStatus(true);
				listUsers.add(usersADs);

				session.saveOrUpdate(usersADs);

				listOnlyAccountAD.add(user.getAccount());

				String localVPNAccess = user.getExtension();
				if ((localVPNAccess != null) && (localVPNAccess.equals("yes"))) {
					AccessVPN vpn = new AccessVPN();
					vpn.setDateLastMofification(timestamp);
					vpn.setHomeAddress(usersADs);
					listAccessVPN.add(vpn);
				}

				if (user.getEmail() != null) {
					AccessMail mail = new AccessMail();
					mail.setDateLastMofification(timestamp);
					mail.setMailAccess(user.getEmail());
					mail.setHomeAddress(usersADs);
					listMails.add(mail);
				}
			}
		} else {
			listUsers = lastListUsersAD;
		}

		try {
			map = checkUsers.getMapAccess(listUsers, timestamp);
		} catch (IOException e) {
			LogIt.log(e);
			e.printStackTrace();
		} catch (ConfigurationException e) {
			LogIt.log(e);
			e.printStackTrace();
		} catch (JIExceptionCustom e) {
			LogIt.log(e);
			e.printStackTrace();
		}

		LogIt.log("Карта с базами и доступом пользователей " + map.size());
		saveNewUsersAdToDb(map, timestamp);

		AccessForExchange accessExchange = new AccessForExchange();
		try {
			accessExchange.listAllUsers("Administrator", "Ghjbpdtltybt1");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		Collection<String> collExchangeAccounts = accessExchange
				.getOnlyAccounts();
		saveNewAccessToExchange(listUsers, collExchangeAccounts, timestamp);

		Mysql mysql = new Mysql();
		List<AccessInternet> listForAccessInternet = mysql.checkUserInternet(
				listUsers, timestamp);
		saveNewAccessToInternet(listForAccessInternet);

		MsSql msSql = new MsSql();
		List<String> listForAccessUsbTemporary = msSql
				.checkUserUsb(listOnlyAccountAD);
		// System.out.println("list USB " + listForAccessUsbTemporary);
		// LogIt.log("Карта с базами и доступом пользователей " + map.size());
		saveNewAccessToUsb(listForAccessUsbTemporary, listUsers, timestamp);

		saveNewAccessToVPN(listAccessVPN);

		saveNewAccessToMails(listMails);

		if (session.getTransaction().isActive()) {
			session.getTransaction().commit();
		}
	}

	/**
	 * 
	 * Предназначена для сохранения или обновления данных о почте пользователей.
	 * 
	 * @param listMails2
	 *            - список почт пользователей.
	 * 
	 * @see ru.vrn.com.datamodel.AccessMail
	 */
	private void saveNewAccessToMails(List<AccessMail> listMails2) {
		for (AccessMail mail : listMails) {
			if (session.isOpen()) {
				session.saveOrUpdate(mail);
			}
		}
	}

	/**
	 * 
	 * Предназначена для сохранения или обновления данных о доступе VPN
	 * пользователей.
	 * 
	 * @param listAccessVPN2
	 *            - список доступа к VPN пользоватлей.
	 * 
	 * @see ru.vrn.com.datamodel.AccessVPN
	 */
	private void saveNewAccessToVPN(List<AccessVPN> listAccessVPN2) {
		for (AccessVPN vpn : listAccessVPN) {
			if (session.isOpen()) {
				session.saveOrUpdate(vpn);
			}
		}
	}

	/**
	 * 
	 * Предназначена для сохранения или обновления данных о доступе к usb портам
	 * пользователей.
	 * 
	 * @param listForAccessUsbTemporary
	 *            - список доступа к usb портам пользователей.
	 * @param listUsers
	 *            - список пользователей Active Directory
	 * @param time
	 *            - дата и время обновления или сохранения.
	 * 
	 * @see ru.vrn.com.datamodel.UsersAD
	 */
	private void saveNewAccessToUsb(List<String> listForAccessUsbTemporary,
			List<UsersAD> listUsers, Timestamp time) {

		List<AccessUSB> listForAccessUsb = new ArrayList<AccessUSB>();
		List<Accordance> listAccordance = new ArrayList<Accordance>();

		for (String string : listForAccessUsbTemporary) {

			String[] masStr = string.split(":");

			for (UsersAD it : listUsers) {
				if (it.getAccount().equals(masStr[0])) {
					AccessUSB usb = new AccessUSB();
					usb.setDateLastMofification(time);
					usb.setHomeAddress(it);
					listForAccessUsb.add(usb);

					Accordance accordance = new Accordance();
					accordance.setDateLastMofification(time);
					accordance.setComputer(masStr[1]);
					accordance.setHomeAddress(it);
					listAccordance.add(accordance);

					break;
				}
			}
		}

		for (Accordance accordance : listAccordance) {
			if (session.isOpen()) {
				session.saveOrUpdate(accordance);
			}
		}

		for (AccessUSB usb : listForAccessUsb) {
			if (session.isOpen()) {
				session.saveOrUpdate(usb);
			}
		}
	}

	/**
	 * 
	 * Предназначена для сохранения или обновления данных о доступе к интернету
	 * пользователей.
	 * 
	 * @param listForAccessInternet
	 *            - список доступа к интернету пользователей.
	 * @see ru.vrn.com.datamodel.AccessInternet
	 */
	private void saveNewAccessToInternet(
			List<AccessInternet> listForAccessInternet) {
		for (AccessInternet inet : listForAccessInternet) {
			if (session.isOpen()) {
				session.saveOrUpdate(inet);

			}
		}
	}

	/**
	 * 
	 * Предназначена для сохранения или обновления данных о доступе к Exchange
	 * пользователей.
	 * 
	 * @param collExchangeAccounts
	 *            - коллекция доступа к Exchange пользователей.
	 * @param listUsers
	 *            - список пользователей Active Directory
	 * @param time
	 *            - дата и время обновления или сохранения..
	 * 
	 * @see ru.vrn.com.datamodel.UsersAD
	 */
	private void saveNewAccessToExchange(List<UsersAD> listUsers,
			Collection<String> collExchangeAccounts, Timestamp time) {

		List<AccessExchange> exchanges = new ArrayList<AccessExchange>();

		for (String str : collExchangeAccounts) {
			for (UsersAD it : listUsers) {
				if (it.getAccount().equals(str)) {
					AccessExchange exchange = new AccessExchange();
					exchange.setDateLastMofification(time);
					exchange.setHomeAddress(it);
					break;
				}
			}
		}

		for (AccessExchange exchange : exchanges) {
			if (session.isOpen()) {
				session.saveOrUpdate(exchange);
			}
		}
	}

	/**
	 * 
	 * Предназначена для сохранения или обновления данных о доступе к
	 * пользователей к базам 1С.
	 * 
	 * @param map
	 *            - Карта соответствий доступа базы данных и пользователя. То
	 *            есть у одной базы может быть несколько пользователей, это
	 *            соответствие проводиться как карта ключ у которой база данных,
	 *            а значение список пользователей Active Directory.
	 * 
	 * @param time
	 *            - дата и время обновления или сохранения.
	 * 
	 * @see ru.vrn.com.datamodel.ListOfMonitoring
	 * @see ru.vrn.com.datamodel.UsersAD
	 */
	private void saveNewUsersAdToDb(Map<ListOfMonitoring, List<UsersAD>> map,
			Timestamp time) {
		for (Entry<ListOfMonitoring, List<UsersAD>> entry : map.entrySet()) {

			ListOfMonitoring listKey = entry.getKey();

			System.out.println("-------------   " + listKey);

			for (UsersAD user : entry.getValue()) {

				System.out.println("USER  ------------ " + user);
				AccessFor1C for1c = new AccessFor1C();
				for1c.setDateLastMofification(time);
				for1c.setHomeAddress(user);

				AccessFor1CDetail accessFor1CDetail = new AccessFor1CDetail();
				accessFor1CDetail.setListOfMonitoring(listKey);
				accessFor1CDetail.setAccessFor1C(for1c);

				if (session.isOpen()) {

					session.saveOrUpdate(listKey);
					session.saveOrUpdate(for1c);
					session.saveOrUpdate(accessFor1CDetail);

				}
			}
		}

	}

}
