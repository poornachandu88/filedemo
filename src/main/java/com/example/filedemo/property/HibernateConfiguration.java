package com.example.filedemo.property;	
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ConfigurationProperties(prefix = "file")
@EnableTransactionManagement
public class HibernateConfiguration {
	
		

	private String DRIVER;
	private String PASSWORD;
	private String URL;
	private String USERNAME;
	private String DIALECT;
	private String SHOW_SQL;
	private String HBM2DDL_AUTO;
	private String PACKAGES_TO_SCAN;


	
	public String getDRIVER() {
		return DRIVER;
	}

	public void setDRIVER(String dRIVER) {
		DRIVER = dRIVER;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getDIALECT() {
		return DIALECT;
	}

	public void setDIALECT(String dIALECT) {
		DIALECT = dIALECT;
	}

	public String getSHOW_SQL() {
		return SHOW_SQL;
	}

	public void setSHOW_SQL(String sHOW_SQL) {
		SHOW_SQL = sHOW_SQL;
	}

	public String getHBM2DDL_AUTO() {
		return HBM2DDL_AUTO;
	}

	public void setHBM2DDL_AUTO(String hBM2DDL_AUTO) {
		HBM2DDL_AUTO = hBM2DDL_AUTO;
	}

	public String getPACKAGES_TO_SCAN() {
		return PACKAGES_TO_SCAN;
	}

	public void setPACKAGES_TO_SCAN(String pACKAGES_TO_SCAN) {
		PACKAGES_TO_SCAN = pACKAGES_TO_SCAN;
	}
	
	

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", DIALECT);
		hibernateProperties.put("hibernate.show_sql", SHOW_SQL);
		hibernateProperties.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
		sessionFactory.setHibernateProperties(hibernateProperties);

		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}	
}