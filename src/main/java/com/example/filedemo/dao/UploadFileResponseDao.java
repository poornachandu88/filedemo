package com.example.filedemo.dao;

import java.util.List;

import com.example.filedemo.payload.UploadFileResponse;


public interface UploadFileResponseDao {
	
	
	public List<UploadFileResponse> getAllFiles() ;

	public UploadFileResponse getFileDetails(int id) ;
	

	public UploadFileResponse addFileDetails(UploadFileResponse customer);

	public void updateFileDetails(UploadFileResponse customer) ;

	public void deleteFileDetails(int id) ;

}
