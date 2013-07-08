package ru.vrn.rusap.server.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import ru.vrn.rusap.server.encrypt.EncryptPass;
import ru.vrn.rusap.shared.model.AccessExchange;
import ru.vrn.rusap.shared.model.AccessFileResourses;
import ru.vrn.rusap.shared.model.AccessFileResoursesDetail;
import ru.vrn.rusap.shared.model.AccessFor1C;
import ru.vrn.rusap.shared.model.AccessFor1CDetail;
import ru.vrn.rusap.shared.model.AccessInternet;
import ru.vrn.rusap.shared.model.AccessMail;
import ru.vrn.rusap.shared.model.AccessUSB;
import ru.vrn.rusap.shared.model.AccessVPN;
import ru.vrn.rusap.shared.model.Accordance;
import ru.vrn.rusap.shared.model.ListOfMonitoring;
import ru.vrn.rusap.shared.model.User;
import ru.vrn.rusap.shared.model.UsersAD;
import ru.vrn.rusap.shared.model.superclass.Versioned;
import ru.vrn.rusap.shared.transfer.ListOfMonitoringTransfer;

/**
 * DAO (Data Access Object) слой для серверной стороны RPC сервиса.
 * 
 * @author marchenko
 * 
 * @create 25.05.2013
 * 
 */
@Repository
public class GreetingServiceDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	HibernateTemplate hibernateTemplate;

	Set<AccessFor1CDetail> for1cDetails = new HashSet<AccessFor1CDetail>();
	AccessFileResourses accessFileResoursesMain;

	public UsersAD get(Long id) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<UsersAD> list1 = session
				.createSQLQuery("SELECT * FROM USERS_AD where id = 3")
				.addEntity(UsersAD.class).list();

		session.getTransaction().commit();
		session.close();
		return list1.get(0);
	}

	/**
	 * Предназначена для получения Всех пользователей Active Directory.
	 * 
	 * @return List<UsersAD> - Список пользователей Active Directory
	 * 
	 * @see ru.vrn.rusap.shared.model.UsersAD
	 * 
	 */
	public List<UsersAD> getAllUsersAD() {

		final String queryStr = "SELECT * FROM USERS_AD a order by a.NAME";
		Session session = getCurrentSession();

		List<UsersAD> newlist1 = hibernateTemplate
				.executeFind(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						return session.createSQLQuery(queryStr)
								.addEntity(UsersAD.class).list();
					}
				});

		return newlist1;
	}

	/**
	 * Предназначена для получения текущей сеccии.
	 * 
	 * @return Session - Текущая сессия.
	 * 
	 * @see org.hibernate.Session
	 * 
	 */
	private Session getCurrentSession() {
		return hibernateTemplate.getSessionFactory().getCurrentSession();
	}

	/**
	 * 
	 * Предназначена для получения информации о доступе к IT ресурсам сети.
	 * Собирает информацию о доступе к Интернету, о доступе к Usb портам, VPN,
	 * базам 1с, Exchange.
	 * 
	 * @param user
	 *            - пользователь Active Directory
	 * 
	 * @return String - Строка инфоормации о достeпе пользователя Active
	 *         Directory
	 * 
	 * 
	 */
	public String getInformation(UsersAD user) {

		StringBuilder builder = new StringBuilder();
		Session session = getCurrentSession();

		UsersAD userForChek = null;
		List<UsersAD> listUser = getListUsersADIdByUser(user, session);

		if (listUser.size() == 1) {
			userForChek = listUser.get(0);
		}

		String queryStr = "SELECT * FROM ACCESS_EXCHANGE a where a.ID_USER_AD = "
				+ userForChek.getId();
		List listExchange = getListExtendsVersioned(userForChek, session,
				queryStr, new AccessExchange());

		if (listExchange.size() > 0) {
			builder.append("Access to Exchange:  yes;");
		}
		System.gc();

		queryStr = "SELECT * FROM ACCESS_INTERNET a where a.ID_USER_AD = "
				+ userForChek.getId();
		List listInternet = getListExtendsVersioned(userForChek, session,
				queryStr, new AccessInternet());

		if (listInternet.size() > 0) {
			builder.append("Access to Internet:  yes;");

		}
		System.gc();

		queryStr = "SELECT * FROM ACCESS_MAIL a where a.ID_USER_AD = "
				+ userForChek.getId();
		List listMail = getListExtendsVersioned(userForChek, session, queryStr,
				new AccessMail());

		if (listMail.size() > 0) {

			for (Object object : listMail) {
				if (object instanceof AccessMail) {
					builder.append("Mail:  "
							+ ((AccessMail) object).getMailAccess() + ";");
				}
			}
		}
		System.gc();

		queryStr = "SELECT * FROM ACCESS_USB a where a.ID_USER_AD = "
				+ userForChek.getId();
		List listUsb = getListExtendsVersioned(userForChek, session, queryStr,
				new AccessUSB());

		if (listUsb.size() > 0) {
			builder.append("Access to USB: yes;");

		}
		System.gc();

		queryStr = "SELECT * FROM ACCORDANCE a where a.ID_USER_AD = "
				+ userForChek.getId();
		List listAccordance = getListExtendsVersioned(userForChek, session,
				queryStr, new Accordance());

		if (listAccordance.size() > 0) {
			for (Object object : listAccordance) {
				if (object instanceof Accordance) {
					Accordance accordance = (Accordance) object;
					builder.append("Computer: " + accordance.getComputer()
							+ ";");
				}
			}
		}
		System.gc();

		queryStr = "SELECT * FROM ACCESS_VPN a where a.ID_USER_AD = "
				+ userForChek.getId();

		List listVPN = getListExtendsVersioned(userForChek, session, queryStr,
				new AccessVPN());

		if (listVPN.size() > 0) {
			builder.append("Access to VPN: yes;");
		}
		System.gc();

		queryStr = "SELECT * FROM ACCESS_FILE_RESOURSES a where a.ID_USER_AD = "
				+ userForChek.getId();
		List listAccessFileResource = getListExtendsVersioned(userForChek,
				session, queryStr, new AccessFileResourses());

		if (listAccessFileResource.size() > 0) {
			for (Object object : listAccessFileResource) {
				if (object instanceof AccessFileResourses) {
					Set<AccessFileResoursesDetail> set = ((AccessFileResourses) object)
							.getAccessFileResoursesDetailItems();
					for (AccessFileResoursesDetail accessFileResoursesDetails : set) {
						String str = accessFileResoursesDetails.getPath();

						builder.append("Access to Folder " + str + " : yes;");
					}
				}
			}
		}

		queryStr = "SELECT * FROM ACCESS_FOR_1C a where a.ID_USER_AD = "
				+ userForChek.getId();
		List listAccess1C = getListExtendsVersioned(userForChek, session,
				queryStr, new AccessFor1C());

		if (listAccess1C.size() > 0) {
			for (Object object : listAccess1C) {
				if (object instanceof AccessFor1C) {
					Set<AccessFor1CDetail> set = ((AccessFor1C) object)
							.getAccessFor1CDetail();
					for (AccessFor1CDetail accessFor1CDetail : set) {
						String str = accessFor1CDetail.getListOfMonitoring()
								.getRef();

						builder.append("Access to database " + str + " : yes;");
					}
				}
			}

		}
		System.gc();

		return builder.toString();
	}

	private List<UsersAD> getListUsersADIdByUser(final UsersAD user,
			Session session) {
		List<UsersAD> listUsersAD = (List<UsersAD>) hibernateTemplate
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						Criteria criteria = session
								.createCriteria(UsersAD.class);
						criteria.add(Restrictions.eq("account",
								user.getAccount()));
						return criteria.list();
					}
				});
		return listUsersAD;
	}

	private <T extends Versioned> List<? extends Versioned> getListExtendsVersioned(
			final UsersAD user, Session session, final String query,
			final T className) {

		return hibernateTemplate.executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {

				return session.createSQLQuery(query)
						.addEntity(className.getClass()).list();
			}
		});
	}

	/**
	 * Предназначена для получения баз 1С в виде строки.
	 * 
	 * @return List<String> - Список баз 1С, собранных в строку для удобства.
	 *         Строка представляет собой соединения из данных о сревере и
	 *         строкой подключения (ref).
	 * 
	 */
	public List<String> getDbs() {
		List<String> listDbs = new ArrayList<String>();
		for (ListOfMonitoring listOfMonitoring : getListDbs(getCurrentSession())) {
			listDbs.add(listOfMonitoring.getSrv() + " ; "
					+ listOfMonitoring.getRef());
		}
		return listDbs;
	}

	/**
	 * Предназначена для получения баз 1С.
	 * 
	 * @return List<ListOfMonitoring> - Список баз 1С.
	 * 
	 * @see ru.vrn.rusap.shared.model.ListOfMonitoring
	 * 
	 **/
	private List<ListOfMonitoring> getListDbs(Session session) {
		List<ListOfMonitoring> listDbs = (List<ListOfMonitoring>) hibernateTemplate
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						Criteria criteria = session
								.createCriteria(ListOfMonitoring.class);
						return criteria.list();
					}
				});
		return listDbs;
	}

	/**
	 * Предназначена для получения списка от класса Versioned.
	 * 
	 * @param user
	 *            - пользователь Active Directory.
	 * @param session
	 *            - сессия хибернета.
	 * @param query
	 *            - запрос к базе данных.
	 * @param T
	 *            className - класс для соответствия запроса классу. Класс T от
	 *            Versioned.
	 * 
	 * @return List<? extends Versioned> - Список полученных из базы данных,
	 *         приведенных в соответстиве хибернетом с классом в коде, который
	 *         расширяет класс Versioned. То есть вместо WildCard может стоять
	 *         любой класс, который расширяет класс Versioned.
	 * 
	 * @see ru.vrn.rusap.shared.model.superclass.Versioned
	 * 
	 **/
	private <T extends Versioned> List<? extends Versioned> getListExtendsVersionedWithLazyInit(
			final UsersAD user, Session session, final String query,
			final T className) {

		return hibernateTemplate.executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {

				List lis = session.createSQLQuery(query)
						.addEntity(className.getClass()).list();
				Set<AccessFor1CDetail> details = ((ListOfMonitoring) lis.get(0))
						.getAccessFor1CDetail();
				hibernateTemplate.initialize(details);
				for1cDetails.addAll(details);
				return lis;
			}
		});
	}

	/**
	 * Предназначена для получения класса ListOfMonitoringTransfer, для передачи
	 * на клиентскую часть.
	 * 
	 * @param baseName
	 *            - имя базы 1С, стостоящей из строки сервера и строки
	 *            подключения (ref).
	 * 
	 * @return ListOfMonitoringTransfer - Временный класс, дял передачи на
	 *         клиенткусю часть, в точности повторяющий ListOfMonitoring.
	 * 
	 * @see ru.vrn.rusap.shared.transfer.ListOfMonitoringTransfer.
	 * 
	 **/
	public ListOfMonitoringTransfer getBaseByString(String baseName) {
		for1cDetails.clear();
		String[] strings = baseName.split(";");
		String query = "SELECT * FROM LIST_OF_MONITORING a where a.SERVER ='"
				+ strings[0].trim() + "'and a.REF ='" + strings[1].trim() + "'";

		System.out.println("query  --- " + query);
		List list = getListExtendsVersionedWithLazyInit(new UsersAD(),
				getCurrentSession(), query, new ListOfMonitoring());

		ListOfMonitoringTransfer mon = new ListOfMonitoringTransfer();
		ListOfMonitoring monTemp = ((ListOfMonitoring) list.get(0));

		mon.setId(monTemp.getId());
		mon.setDateLastMofification(monTemp.getDateLastMofification());
		mon.setDomain(monTemp.getDomain());
		mon.setHost(monTemp.getHost());
		mon.setHostPassword(monTemp.getHostPassword());
		mon.setHostUser(monTemp.getHostUser());
		mon.setPath(monTemp.getPath());
		mon.setProgram1cPassword(monTemp.getProgram1cPassword());
		mon.setRef(monTemp.getRef());
		mon.setSqlActive(monTemp.isSqlActive());
		mon.setSrv(monTemp.getSrv());
		mon.setUser(monTemp.getUser());
		mon.setVersion(monTemp.getVersion());

		return mon;
	}

	/**
	 * Предназначена для изменения данных существующей базы 1С.
	 * 
	 * @param base
	 *            - Временный класс, для передачи на клиенткусю часть, в
	 *            точности повторяющий ListOfMonitoring.
	 * 
	 * @return boolean - результат корректности изменения существующей базы 1С.
	 * 
	 * @see ru.vrn.rusap.shared.transfer.ListOfMonitoringTransfer.
	 * 
	 **/
	public boolean changeExistDatabase(ListOfMonitoringTransfer base) {

		ListOfMonitoring monitoring = new ListOfMonitoring();

		monitoring.setDateLastMofification(base.getDateLastMofification());
		monitoring.setDomain(base.getDomain());
		monitoring.setHost(base.getHost());
		monitoring.setHostPassword(base.getHostPassword());
		monitoring.setHostUser(base.getHostUser());
		monitoring.setId(base.getId());
		monitoring.setPath(base.getPath());
		monitoring.setProgram1cPassword(base.getProgram1cPassword());
		monitoring.setRef(base.getRef());
		monitoring.setSqlActive(base.isSqlActive());
		monitoring.setSrv(base.getSrv());
		monitoring.setUser(base.getUser());
		monitoring.setVersion(base.getVersion());

		try {

			hibernateTemplate.update(monitoring);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Предназначена для сохранения или обновления базы 1С.
	 * 
	 * @param base
	 *            - Временный класс, для передачи на клиенткусю часть, в
	 *            точности повторяющий ListOfMonitoring.
	 * 
	 * @param bool
	 *            - результат корректности изменения существующей базы 1С.
	 * 
	 * @see ru.vrn.rusap.shared.transfer.ListOfMonitoringTransfer.
	 * 
	 **/
	private void saveChangingBase(final ListOfMonitoring base,
			final boolean bool) {

		this.hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {

				org.hibernate.Transaction tx = session.beginTransaction();

				tx.begin();
				if (bool) {
					session.update(base);
				} else {
					session.save(base);
				}
				tx.commit();
				session.close();
				return null;
			}
		});
	}

	/**
	 * Предназначена для сохранения новой базы 1С.
	 * 
	 * @param base
	 *            - класс с данными о базе 1С.
	 * 
	 * @return boolean - результат корректности добавления базы 1С.
	 * 
	 * 
	 **/
	public boolean addNewDatabase(ListOfMonitoring base) {

		base.setDateLastMofification(new Timestamp(System.currentTimeMillis()));

		try {
			hibernateTemplate.save(base);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Предназначена для сохранения сетевых правил для данного пользователя.
	 * 
	 * @param rule
	 *            - строка сетевого правила. Для примера это может быть :
	 *            \\Rusap\Vestnik\Vestnik
	 * 
	 * @param usersAD
	 *            - пользователь Active Directory.
	 * 
	 * @return boolean - результат корректности добавления сетевых правил.
	 * 
	 * 
	 **/
	public boolean addNetworkRules(String rule, UsersAD usersAD) {

		UsersAD rightUserAd = getListUsersADIdByUser(usersAD,
				getCurrentSession()).get(0);
		System.out.println("rightUserAd " + rightUserAd.getAccount() + " "
				+ usersAD.getId());

		AccessFileResourses accessFileResourses = null;
		if (accessFileResoursesMain == null) {

			accessFileResourses = new AccessFileResourses();
			accessFileResourses.setDateLastMofification(new Timestamp(System
					.currentTimeMillis()));
			accessFileResourses.setHomeAddress(rightUserAd);

			accessFileResoursesMain = accessFileResourses;

		} else {
			if (accessFileResoursesMain.getHomeAddress().getAccount()
					.equals(usersAD.getAccount())) {
				System.out.println("true");
				// accessFileResourses = accessFileResoursesMain;
				accessFileResourses = new AccessFileResourses();
				accessFileResourses.setDateLastMofification(new Timestamp(
						System.currentTimeMillis()));
				accessFileResourses.setHomeAddress(rightUserAd);
			} else {
				System.out.println("false");
				accessFileResourses = new AccessFileResourses();
				accessFileResourses.setDateLastMofification(new Timestamp(
						System.currentTimeMillis()));
				accessFileResourses.setHomeAddress(rightUserAd);

				accessFileResoursesMain = accessFileResourses;
			}

		}

		AccessFileResoursesDetail accessFileResoursesDetailItems = new AccessFileResoursesDetail();
		accessFileResoursesDetailItems.setPath(rule);
		accessFileResoursesDetailItems.setDictionary(accessFileResourses);

		try {
			hibernateTemplate.saveOrUpdate(accessFileResourses);
			hibernateTemplate.saveOrUpdate(accessFileResoursesDetailItems);

		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Предназначена для сохранения новых сетевых правил в виде сформированного
	 * класса модели базы данных.
	 * 
	 * @param accessFileResourses
	 *            - класс модели базы данных, содержащий информацию о сетевых
	 *            ресурсах определенного пользователя.
	 * 
	 * @see ru.vrn.rusap.shared.model.AccessFileResourses
	 **/
	private void saveNewNetworkRule(
			final AccessFileResourses accessFileResourses) {
		this.hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				org.hibernate.Transaction tx = session.beginTransaction();
				tx.begin();
				session.save(accessFileResourses);
				tx.commit();
				session.close();
				return null;
			}
		});
	}

	/**
	 * Предназначена дял проверки пользователя при авторизации.
	 * 
	 * @param person
	 *            - класс модели базы данных, предназначенный для хранения
	 *            информации о пользователях системы мониторинга.
	 * 
	 * @return boolean - результат проверки пользователя при авторизации.
	 * 
	 **/
	public boolean checkUserForAutorization(User person) {

		final String use = EncryptPass.encrypt(person.getPassword());
		List<User> list = (List<User>) hibernateTemplate
				.execute(new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						Criteria criteria = session.createCriteria(User.class);
						return criteria.list();
					}
				});

		System.out.println("list " + list.get(0).getLogin() + " "
				+ list.get(0).getMail());

		if ((list.size() != 0) || (list != null)) {

			for (User user : list) {
				if (user.getPassword().equals(use)) {
					return true;
				}
			}
			return false;

		} else {
			return false;
		}
	}

}
