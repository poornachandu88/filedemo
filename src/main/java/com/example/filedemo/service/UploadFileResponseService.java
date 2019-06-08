package com.example.filedemo.service;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.filedemo.dao.UploadFileResponseDao;
import com.example.filedemo.payload.UploadFileResponse;

@Service
public class UploadFileResponseService {
	
	
	@Autowired
	UploadFileResponseDao uploadFileResponseDao;
	
	@Transactional
	public List<UploadFileResponse> getAllCustomers() {
		return uploadFileResponseDao.getAllFiles();
	}

	@Transactional
	public UploadFileResponse getCustomer(int id) {
		return uploadFileResponseDao.getFileDetails(id);
	}

	@Transactional
	public UploadFileResponse addCustomer(UploadFileResponse customer) {
		uploadFileResponseDao.addFileDetails(customer);
		
		return customer;
	}

	@Transactional
	public void updateCustomer(UploadFileResponse customer) {
		uploadFileResponseDao.updateFileDetails(customer);

	}

	@Transactional
	public void deleteCustomer(int id) {
		uploadFileResponseDao.deleteFileDetails(id);
	}
	
	

}
