package ru.vrn.com.server.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import ru.vrn.com.shared.model.User;
import ru.vrn.com.shared.model.UsersAD;

@Repository
public class GreetingServiceDao {
	
//	@Autowired
//	private HibernateTemplate hibernate;
	
	@Autowired
	SessionFactory sessionFactory;
	
//	@Autowired
//	DriverManagerDataSource dataSource;
//	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	
	HibernateTemplate hibernateTemplate;
	
	public UsersAD get(Long id) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
//		System.out.println("------------------------------ " + dataSource.getConnectionProperties());
//		try {
//			System.out.println("--------------------------  " + dataSource.getConnection());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		System.out.println("***************************  factory: " + sessionFactory);
		System.out.println("***************************   this.hibernateTemplate: " + this.hibernateTemplate);
//		SQLQuery usersAD;
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<UsersAD> list = session.createSQLQuery("SELECT* FROM USERS_AD a where id = 1").addEntity(UsersAD.class).list();
		
		session.getTransaction().commit();
//		session.close();
//		session.flush();
		System.out.println("*****************  " + list.get(0).getAccount());
		System.out.println("*****************  " + list.get(0).getDepartment());
		System.out.println("*****************  " + list.get(0).getName());
		
		
//		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//		Query query = session.createSQLQuery("SELECT * FROM USERS_AD where id = 35").addEntity(UsersAD.class);
//		query.
//		Query query
		
		List<UsersAD> list1 = session.createSQLQuery("SELECT * FROM USERS_AD where id = 3").addEntity(UsersAD.class).list();
		
		session.getTransaction().commit();
		session.close();
//		return hibernate.get(UsersAD.class, id);
		
		System.out.println("*************************  " + list1.size());
		System.out.println("*************************  " + list1.get(0).getName());
		return list1.get(0);
//		return new UsersAD();
	}
	
//	public UsersAD get(Long id) {
//		return hibernate.get(UsersAD.class, id);
//	}
	
	/*public void delete(UsersAD entity) {
		hibernate.delete(entity);
	}
	
	public void save(UsersAD entity) {
		hibernate.saveOrUpdate(entity);
	}
	
	private Session getCurrentSession() {
		return hibernate.getSessionFactory().getCurrentSession();
	}*/
}
