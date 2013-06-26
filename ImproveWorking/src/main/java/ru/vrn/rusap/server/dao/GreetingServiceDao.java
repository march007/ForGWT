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

@Repository
public class GreetingServiceDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
//	List<AccessFor1CDetail> list1CDetail new ;
	Set<AccessFor1CDetail> for1cDetails = new HashSet<AccessFor1CDetail>();
	AccessFileResourses accessFileResoursesMain;
	
	public UsersAD get(Long id) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
//		System.out.println("***************************  factory: " + sessionFactory);
//		System.out.println("***************************   this.hibernateTemplate: " + this.hibernateTemplate);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<UsersAD> list = session.createSQLQuery("SELECT* FROM USERS_AD a where id = 1").addEntity(UsersAD.class).list();
		
		session.getTransaction().commit();
//		System.out.println("*****************  " + list.get(0).getAccount());
//		System.out.println("*****************  " + list.get(0).getDepartment());
//		System.out.println("*****************  " + list.get(0).getName());
		
		
		session.beginTransaction();
		
		List<UsersAD> list1 = session.createSQLQuery("SELECT * FROM USERS_AD where id = 3").addEntity(UsersAD.class).list();
		
		session.getTransaction().commit();
		session.close();
//		return hibernate.get(UsersAD.class, id);
		
//		System.out.println("*************************  " + list1.size());
//		System.out.println("*************************  " + list1.get(0).getName());
		return list1.get(0);
//		return new UsersAD();
	}
	
	
	public List<UsersAD> getAllUsersAD(){
		
//		Timer timer = new Timer(hibernateTemplate);
//		timer.run();
		
		
		
//		System.out.println("***************************   this.hibernateTemplate: " + this.hibernateTemplate);
		final String queryStr = "SELECT * FROM USERS_AD a order by a.NAME";
		Session session = getCurrentSession();
		
//		if (session.isOpen()) System.out.println("OPEN");
//		if (session.isConnected()) System.out.println("isConnected");
		
		
		List<UsersAD> newlist1 = hibernateTemplate.executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				return session.createSQLQuery(queryStr).addEntity(UsersAD.class).list();
			}
		});
		
//		for (UsersAD usersAD : newlist1) {
//			System.out.println("usersAD " + usersAD.getAccount() + " name " + usersAD.getName());
//		}
		
//		Query query = getCurrentSession().createQuery(queryStr).addEntity(UsersAD.class).list();;
//		List<UsersAD> list = (List<UsersAD>)query.list();
//		
//		for (UsersAD usersAD : list) {
//			System.out.println("user AD " + usersAD.getAccount() + "   " + usersAD.getName());
//		}
		
		return newlist1;		
	}
	
	private Session getCurrentSession() {
		return hibernateTemplate.getSessionFactory().getCurrentSession();
	}
	
	public String getInformation(UsersAD user){
		
//		System.out.println("wowowowow  " + user.getAccount());
		
		StringBuilder builder = new StringBuilder();
		
		
//		builder.
//		final String queryStr = "SELECT * FROM USERS_AD a order by a.NAME";
		Session session = getCurrentSession();
		
//		String query = "SELECT id FROM ACCESS_EXCHANGE a where a.ID_USER_AD = ";
				
//		System.out.println("userAD.id " + user.getId());
		
		
		
//		List<AccessExchange> listExchange2 = 
//				this.hibernateTemplate.find("from ACCESS_EXCHANGE a where a.id_user_ad = ?", new Integer(111));
//
//		System.out.println("-------------------------listExchange222 " + listExchange2.size() + "  "+ listExchange2);
//		
//		
//		List<AccessExchange> listExchange1 = 
//				this.hibernateTemplate.find("from ACCESS_EXCHANGE a where a.id_user_ad = ?", 111);

//		System.out.println("-------------------------listExchange111 " + listExchange1.size() + "  "+ listExchange1);
		
		UsersAD userForChek = null;
		List<UsersAD> listUser = getListUsersADIdByUser(user, session);
//		for (UsersAD usersAD : listUser) {
//			System.out.println("users.account " + usersAD.getAccount());
//			System.out.println("users.name " + usersAD.getName());
//			System.out.println("users.id " + usersAD.getId());
//		}
		
		if (listUser.size()==1){
			userForChek =  listUser.get(0);
		}
		
		
		System.out.println("userForChek " + userForChek.getAccount());
		System.out.println("userForChek.name " + userForChek.getName());
		System.out.println("userForChek.id " + userForChek.getId());
		
		System.out.println("-----------------------------------------------------");
		
//		AccessExchange exchange = new AccessExchange();
		
    String queryStr = "SELECT * FROM ACCESS_EXCHANGE a where a.ID_USER_AD = " + userForChek.getId();	
	List listExchange = getListExtendsVersioned(userForChek, session, queryStr,  new AccessExchange());	
	
	if (listExchange.size()>0){
		builder.append("Access to Exchange:  yes;");
	}
	
	
/*	for (Object object : listExchange1) {
		if (object instanceof AccessExchange){
			System.out.println("obj  " + ((AccessExchange)object).getHomeAddress().getAccount());
		}
	}
	
	List<AccessExchange> listExchange = getListExchange(userForChek, session);	
	
	
	String strSimple = "Доступ к exchange:  Есть;";
	if (listExchange.size()>0){
		for (AccessExchange accessExchange : listExchange) {
//			System.out.println("accessExchange  " + accessExchange.getHomeAddress());
//			builder.append("Доступ к exchange:  Есть;");
			builder.append("Access to Exchange:  yes;");
		}
				
	}*/
	System.gc();
	
	queryStr = "SELECT * FROM ACCESS_INTERNET a where a.ID_USER_AD = " + userForChek.getId();
	List listInternet = getListExtendsVersioned(userForChek, session, queryStr,  new AccessInternet());	
	
//	List<AccessInternet> listInternet = getListInternet(userForChek,  session);	
	
	if (listInternet.size()>0){
			builder.append("Access to Internet:  yes;");
				
	}
	System.gc();
		
	queryStr = "SELECT * FROM ACCESS_MAIL a where a.ID_USER_AD = " + userForChek.getId();
	List listMail = getListExtendsVersioned(userForChek, session, queryStr,  new AccessMail());	
	
//	List<AccessMail> listMail = getListMail(userForChek,  session);
	
	if (listMail.size()>0){
		
		for (Object object : listMail) {
			if (object instanceof AccessMail){
				builder.append("Mail:  "+((AccessMail)object).getMailAccess() +";");
			}
		}
	/*	for (AccessMail accessMail : listMail) {
			System.out.println("accessMail  " + accessMail.getHomeAddress());
//			builder.append("Почта:  "+accessMail.getMailAccess() +";");
			builder.append("Mail:  "+accessMail.getMailAccess() +";");
		}*/
				
	}
	System.gc();
	
	 queryStr = "SELECT * FROM ACCESS_USB a where a.ID_USER_AD = " + userForChek.getId();	
	List listUsb = getListExtendsVersioned(userForChek, session, queryStr,  new AccessUSB());	
	
//	List<AccessUSB> listUsb = getListUsb(userForChek,  session);
	
	if (listUsb.size()>0){
//		for (AccessUSB accessUSB : listUsb) {
//			System.out.println("accessUSB  " + accessUSB.getHomeAddress());
//			builder.append("Доступ к USB: Есть;");
			builder.append("Access to USB: yes;");	
//		}
			
	}
	System.gc();
	
	queryStr = "SELECT * FROM ACCORDANCE a where a.ID_USER_AD = " + userForChek.getId();
	List listAccordance = getListExtendsVersioned(userForChek, session, queryStr,  new Accordance());	
//	List<Accordance> listAccordance = getListAccordance(userForChek,  session);
	
	if (listAccordance.size()>0){
		for (Object object : listAccordance) {
			if (object instanceof Accordance){
				Accordance accordance = (Accordance)object;
				System.out.println("accordance  " + accordance.getHomeAddress());
				builder.append("Computer: "+accordance.getComputer()+";");
			}
		}
		
		
		
/*		for (Accordance accordance : listAccordance) {
			System.out.println("accordance  " + accordance.getHomeAddress());
//			builder.append("Соответствие компьютера и пользователя: "+accordance.getComputer()+";");
			builder.append("Computer: "+accordance.getComputer()+";");
		}*/
				
	}
	System.gc();
	
	queryStr = "SELECT * FROM ACCESS_VPN a where a.ID_USER_AD = " + userForChek.getId();
	
	List listVPN = getListExtendsVersioned(userForChek, session, queryStr,  new AccessVPN());
	
//	List<AccessVPN> listVPN = getListVPN(userForChek,  session);
	
	if (listVPN.size()>0){
//		for (AccessVPN accessVPN : listVPN) {
//			System.out.println("accessVPN  " + accessVPN.getHomeAddress());
//			builder.append("Доступ к  VPN: Есть;");
			builder.append("Access to VPN: yes;");
//		}
	}
	System.gc();
	
	queryStr = "SELECT * FROM ACCESS_FILE_RESOURSES a where a.ID_USER_AD = " + userForChek.getId();
	List listAccessFileResource = getListExtendsVersioned(userForChek, session, queryStr,  new AccessFileResourses());
	
	if (listAccessFileResource.size()>0){
		for (Object object : listAccessFileResource) {
			if (object instanceof AccessFileResourses){
				Set<AccessFileResoursesDetail> set  = ((AccessFileResourses)object).getAccessFileResoursesDetailItems();
				for (AccessFileResoursesDetail accessFileResoursesDetails : set) {
					System.out.println("accessFor1CDetail  " + accessFileResoursesDetails.getPath());
					String str = accessFileResoursesDetails.getPath();
					
//					builder.append("Доступ к базе: "+str+";");
					builder.append("Access to Folder "+str+" : yes;");
				}
			}
		}
	}
		
	
	queryStr = "SELECT * FROM ACCESS_FOR_1C a where a.ID_USER_AD = " + userForChek.getId();
	List listAccess1C = getListExtendsVersioned(userForChek, session, queryStr,  new AccessFor1C());
	
//	List<AccessFor1C> listAccess1C = getListAccess1C(userForChek,  session);
	
	if (listAccess1C.size()>0){
		for (Object object : listAccess1C) {
			if (object instanceof AccessFor1C){
				Set<AccessFor1CDetail> set  = ((AccessFor1C)object).getAccessFor1CDetail();
				for (AccessFor1CDetail accessFor1CDetail : set) {
					System.out.println("accessFor1CDetail  " + accessFor1CDetail.getListOfMonitoring().getRef());
					String str = accessFor1CDetail.getListOfMonitoring().getRef();
					
//					builder.append("Доступ к базе: "+str+";");
					builder.append("Access to database "+str+" : yes;");
				}
			}
		}
		
	}
	System.gc();
	System.out.println("*********************************************");
	System.out.println(builder.toString());
	System.out.println("*********************************************");
	
	
		return builder.toString();
	}

	private List<UsersAD> getListUsersADIdByUser(final UsersAD user, Session session) {
		List<UsersAD> listUsersAD = (List<UsersAD>) hibernateTemplate.execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				Criteria criteria = session.createCriteria(UsersAD.class);
				criteria.add(Restrictions.eq("account", user.getAccount()));
				return criteria.list();
			}
		});
		return listUsersAD;
	}
	
	private <T  extends Versioned> List<? extends Versioned> getListExtendsVersioned
			(final UsersAD user, Session session, final String query, final T className) {
		
		return hibernateTemplate.executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				return session.createSQLQuery(query).addEntity(className.getClass()).list();
			}
		});
	}


	public List<String> getDbs() {
		List<String> listDbs = new ArrayList<String>();
		for (ListOfMonitoring listOfMonitoring : getListDbs(getCurrentSession())) {
//			System.out.println("listOfMonitoring ------------------ " + listOfMonitoring.toString());
			listDbs.add(listOfMonitoring.getSrv() + " ; " + listOfMonitoring.getRef());
		} 
		return listDbs;
	}
	
	private List<ListOfMonitoring> getListDbs(Session session) {
		List<ListOfMonitoring> listDbs = (List<ListOfMonitoring>) hibernateTemplate.execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				Criteria criteria = session.createCriteria(ListOfMonitoring.class);
//				criteria.add(Restrictions.eq("account", user.getAccount()));
				return criteria.list();
			}
		});
		return listDbs;
	}

	
	private <T  extends Versioned> List<? extends Versioned> getListExtendsVersionedWithLazyInit
	(final UsersAD user, Session session, final String query, final T className) {

	return hibernateTemplate.executeFind(new HibernateCallback() {
		
		public Object doInHibernate(Session session) throws HibernateException,
				SQLException {
			
			List lis = session.createSQLQuery(query).addEntity(className.getClass()).list();
			Set<AccessFor1CDetail> details = ((ListOfMonitoring)lis.get(0)).getAccessFor1CDetail();
			hibernateTemplate.initialize(details);
			for1cDetails.addAll(details);
//			for (AccessFor1CDetail accessFor1CDetail : details) {
//				System.out.println("accessFor1CDetail    888 " + accessFor1CDetail.getAccessFor1C().getHomeAddress().getAccount());;
//				for1cDetails.add(accessFor1CDetail);
//			}
			return lis;
		}
		});
	}
	

	public ListOfMonitoringTransfer getBaseByString(String string) {
		for1cDetails.clear();
		String[] strings = string.split(";");
		String query = "SELECT * FROM LIST_OF_MONITORING a where a.SERVER ='"+strings[0].trim()+"'and a.REF ='"+strings[1].trim()+"'";
		
		System.out.println("query  --- " + query );
		List list = getListExtendsVersionedWithLazyInit(new UsersAD(), getCurrentSession(), query, new ListOfMonitoring());
		
//		for (AccessFor1CDetail accessFor1CDetail : for1cDetails) {
//			System.out.println("accessFor1CDetail    101010 " + accessFor1CDetail.getAccessFor1C().getHomeAddress().getAccount());;
//		}
//		List<ListOfMonitoring> lis1 = getListDbs(getCurrentSession());
		
//		System.out.println("lis1 " + lis1.size());
//for (ListOfMonitoring ob : lis1) {
//	System.out.println("ob eee " + ob.getSrv()+"  " + ob.getRef());
//	if ((ob.getSrv().equals(strings[0].trim()))&&(ob.getRef().equals(strings[1].trim()))){
//		System.out.println("ob.ob() " + ob);
//		return ob;
//	}
//}
		
//		Set<AccessFor1CDetail> set = new HashSet<AccessFor1CDetail>();
ListOfMonitoringTransfer mon = new ListOfMonitoringTransfer();
		
//		for (Object object : list) {
		ListOfMonitoring monTemp  = ((ListOfMonitoring)list.get(0));
		
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
		
//			System.out.println(" object eeeeeeeeee " + mon.getRef());
//			System.out.println(" object eeeeeeeeee 1 " + mon.getAccessFor1CDetail().size());
//			System.out.println(" object eeeeeeeeee 2 " + mon.getAccessFor1CDetail());
			
//			+"  " + mon.getAccessFor1CDetail().size()+ "   "+  mon.getAccessFor1CDetail());
			
//			for (AccessFor1CDetail acc : mon.getAccessFor1CDetail()) {
//				System.out.println("acc  " + acc.getAccessFor1C().getHomeAddress().getAccount());
//				
//				
//				AccessFor1CDetail detail = new AccessFor1CDetail();
//				
//				detail.setAccessFor1C(acc.getAccessFor1C());
//				detail.setId(acc.getId());
//				detail.setListOfMonitoring(acc.getListOfMonitoring());
//				
//				set.add(detail);
//			}
			
//			mon.setAccessFor1CDetail(set);
			
//		}
			
//			mon.setAccessFor1CDetail(for1cDetails);
		
//		ListOfMonitoring monitoring = (ListOfMonitoring)list.get(0);
		
		System.out.println("GreetingServiceDao.getBaseByString() " + mon);
		return mon;
	}


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
		
		System.out.println("base changeExistDatabase" + base);
		try{
			
			hibernateTemplate.update(monitoring);
//			saveChangingBase(monitoring, true);
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
			return true;
	}


	private void saveChangingBase(final ListOfMonitoring base, final boolean bool) {
		
		this.hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				org.hibernate.Transaction tx = session.beginTransaction();
                
                tx.begin();
                if (bool){
                	session.update(base);
                }else{
                	session.save(base);
                }
                tx.commit();
                session.close();
                return null;
			}
		});
	}


	public boolean addNewDatabase(ListOfMonitoring base) {
		
		base.setDateLastMofification(new Timestamp(System.currentTimeMillis()));
		
		System.out.println("base addNewDatabase" + base);
		
		/*ListOfMonitoring base = new ListOfMonitoring();		
		base.setSqlActive(true);
		
		String[] masStrings = string.split("|");
		
		for (String it : masStrings) {
			String[] masStringsTemporary = it.split("=");
			
			String fisrtStr = masStringsTemporary[0].trim();
			String secondStr = masStringsTemporary[1].trim();
			
				if (fisrtStr.equals("server")){
					base.setSrv(secondStr);
				}else if (fisrtStr.equals("ref")){
					base.setRef(secondStr);
				}else if (fisrtStr.equals("domain")){
					base.setDomain(secondStr);
				}else if (fisrtStr.equals("version")){
					base.setVersion(secondStr);
				}else if (fisrtStr.equals("host")){
					base.setHost(secondStr);
				}else if (fisrtStr.equals("host_user")){
					base.setHostUser(secondStr);
				}else if (fisrtStr.equals("host_password")){
					base.setHostPassword(secondStr);
				}else if (fisrtStr.equals("programm_user")){
					base.setUser(secondStr);
				}else if (fisrtStr.equals("programm_password")){
					base.setProgram1cPassword(secondStr);
				}
		}*/
		
//		boolean bool = true;
//		  Properties configuration = new Properties();
//	        
//	        configuration.setProperty(OCE_CFG_DRIVER, base.getVersion());
//	        configuration.setProperty(OCE_CFG_HOST, base.getHost());
//	        configuration.setProperty(OCE_CFG_HOST_USER, base.getUser());
//	        configuration.setProperty(OCE_CFG_HOST_PASSWORD,base.getHostPassword());
//	        configuration.setProperty(OCE_CFG_DOMAIN, base.getDomain());
////	        configuration.setProperty(OCE_CFG_1CDB_PATH, "I:\\Base8\\DCOM");
//	        configuration.setProperty(OCE_CFG_1CDB_USER, base.getHostUser());
//	        configuration.setProperty(OCE_CFG_1CDB_PASSWORD, base.getProgram1cPassword());
//	        configuration.setProperty(OCE_CFG_1CSRVR, base.getSrv());
//	        configuration.setProperty(OCE_CFG_1CREF, base.getRef());
//	        configuration.setProperty(OCE_CFG, "UPP_13_Vector");	
	        
//	        ApplicationDriver driver = ApplicationDriver.loadDriver((String) configuration.get( PropertiesReader.OCE_CFG_DRIVER ) );
//	        driver.setAutoRegistration(true); // только для самого первого подключения
//	        OCApp app = OCApp.getNewInstance();
	        
	        
//	        app.setApplicationDriver(driver);
//	        try{
//						app.connect(configuration);
//				
//	                System.out.println("Connected to " + app.getComputerName());
//	        } catch (JIException e) {
//				e.printStackTrace();
//				bool = false;
//			} catch (IOException e) {
//				bool = false;
//				e.printStackTrace();
//			}
		
		try{
			
//			if (bool)
				hibernateTemplate.save(base);
			
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
			return true;
	}


	public boolean addNetworkRules(String rule, UsersAD usersAD) {
		
		System.out.println("rule " + rule);
		System.out.println("usersAD " + usersAD.getAccount() + "  " + usersAD.getId());
		
		UsersAD rightUserAd = getListUsersADIdByUser(usersAD, getCurrentSession()).get(0);
		System.out.println("rightUserAd " + rightUserAd.getAccount() + " " + usersAD.getId());
		
		AccessFileResourses accessFileResourses = null;
		if(accessFileResoursesMain == null){
			
//		Set<AccessFileResoursesDetail> set = new HashSet<AccessFileResoursesDetail>();
//		set.add(accessFileResoursesDetailItems);
		
		accessFileResourses = new AccessFileResourses();
		accessFileResourses.setDateLastMofification(new Timestamp(System.currentTimeMillis()));
		accessFileResourses.setHomeAddress(rightUserAd);
//		accessFileResourses.setAccessFileResoursesDetailItems(set);
		
		accessFileResoursesMain = accessFileResourses;
		
		}else{
			if (accessFileResoursesMain.getHomeAddress().getAccount().equals(usersAD.getAccount())){
				System.out.println("true");
//				accessFileResourses = accessFileResoursesMain;
				accessFileResourses = new AccessFileResourses();
				accessFileResourses.setDateLastMofification(new Timestamp(System.currentTimeMillis()));
				accessFileResourses.setHomeAddress(rightUserAd);
			}else{
				System.out.println("false");
				accessFileResourses = new AccessFileResourses();
				accessFileResourses.setDateLastMofification(new Timestamp(System.currentTimeMillis()));
				accessFileResourses.setHomeAddress(rightUserAd);
				
				accessFileResoursesMain = accessFileResourses;
			}
			
		}
		
		AccessFileResoursesDetail accessFileResoursesDetailItems = new AccessFileResoursesDetail();
		accessFileResoursesDetailItems.setPath(rule);
		accessFileResoursesDetailItems.setDictionary(accessFileResourses);
		
		try{
		hibernateTemplate.saveOrUpdate(accessFileResourses);
		hibernateTemplate.saveOrUpdate(accessFileResoursesDetailItems);
		
//			saveNewNetworkRule(accessFileResourses);
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
			return true;
	}


	private void saveNewNetworkRule(final AccessFileResourses accessFileResourses){
		this.hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				org.hibernate.Transaction tx = session.beginTransaction();
                tx.begin();
                session.save(accessFileResourses);
                tx.commit();                
                session.close();
                return null;
			}
		});
	}


	public boolean checkUserForAutorization(User person) {
		
		final String use = EncryptPass.encrypt(person.getPassword());
		List<User> list = (List<User>) hibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				Criteria criteria = session.createCriteria(User.class);
				return criteria.list();
			}
		});
		
		System.out.println("list " + list.get(0).getLogin() + " " + list.get(0).getMail());
		
		if ((list.size()!=0)||(list !=null)){
			
			for (User user : list) {
				if (user.getPassword().equals(use)){
					return true;
				}
			}
				return false;
			
		}else{
			return false;
		}
	}
		
}
