package com.example.filedemo.dao;

import java.util.List;


import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.filedemo.payload.UploadFileResponse;

@Repository
public class UploadFileResponseDaoImpl implements UploadFileResponseDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<UploadFileResponse> getAllFiles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<UploadFileResponse>  customerList = session.createQuery("from UploadFileResponse").list();
		return customerList;
	}

	@Override
	public UploadFileResponse getFileDetails(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		UploadFileResponse customer = (UploadFileResponse) session.get(UploadFileResponse.class, id);
		return customer;
	}

	@Override
	public UploadFileResponse addFileDetails(UploadFileResponse customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(customer);
		return customer;
	}

	@Override
	public void updateFileDetails(UploadFileResponse customer) {
		Session session = this.sessionFactory.getCurrentSession();
		Hibernate.initialize(customer);
		session.update(customer);

	}

	@Override
	public void deleteFileDetails(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		UploadFileResponse p = (UploadFileResponse) session.load(UploadFileResponse.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}

}
