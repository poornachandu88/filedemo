package com.example.filedemo.payload;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Upload_File_Response")
public class UploadFileResponse {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String fileName;
	
    private String fileDownloadUri;

    private String fileType;
	
    private String year;

    private String filecoverimage;

    private String filecoverimageDownloadUri;

    private long size;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getFilecoverimage() {
		return filecoverimage;
	}

	public void setFilecoverimage(String filecoverimage) {
		this.filecoverimage = filecoverimage;
	}

	public String getFilecoverimageDownloadUri() {
		return filecoverimageDownloadUri;
	}

	public void setFilecoverimageDownloadUri(String filecoverimageDownloadUri) {
		this.filecoverimageDownloadUri = filecoverimageDownloadUri;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public UploadFileResponse(int id, String fileName, String fileDownloadUri, String fileType, String year,
			String filecoverimage, String filecoverimageDownloadUri, long size) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.year = year;
		this.filecoverimage = filecoverimage;
		this.filecoverimageDownloadUri = filecoverimageDownloadUri;
		this.size = size;
	}

	public UploadFileResponse() {
		super();
	}
	
	


}
