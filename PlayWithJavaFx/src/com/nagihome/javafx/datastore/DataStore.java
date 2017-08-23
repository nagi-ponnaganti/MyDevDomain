package com.nagihome.javafx.datastore;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DataStore {

	private SessionFactory sessionFactory;

	public DataStore() throws Exception {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<Actor> getActorList() throws Exception {

		Session session = null;
		List<Actor> queryList = new ArrayList<>();

		try {

			session = sessionFactory.openSession();

			Query query = session.createQuery("from Actor a");
			queryList = query.list();
			queryList.stream().forEach(e -> System.out.println("Actor: " + e));

		} finally {
			session.close();
		}

		return queryList;

	}

}
