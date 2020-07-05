package com.alighthub.dms.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alighthub.dms.dao.AdminDao;
import com.alighthub.dms.dao.LoginDao;
import com.alighthub.dms.model.Admin;
import com.alighthub.dms.model.Login;
import com.alighthub.dms.service.ServiceDMS;

/*
 * 
 * @author Ravindra Sonawane
 * @page Service Implimentation
 * @time 08/09/2019 - 9.20 PM
 * @purpose To impliment all Service methods
 * 
 *
 */
@Service
public class ServiceImplimentation implements ServiceDMS{
	
	@Autowired
	AdminDao admindao;
	@Autowired
	LoginDao logindao;
	
	
	@Override
	public void addData(Admin admin) {
		// TODO Auto-generated method stub
		admindao.save(admin);
		
	}

	@Override
	public Admin displayAdmin(String loginuname, String loginpassword) {
		// TODO Auto-generated method stub
		
		return admindao.findByUnameAndPass(loginuname, loginpassword);
	}


	/*@Override
	public Login admin(String loginuname, String loginpassword) {
		// TODO Auto-generated method stub
		    
			return logindao.findByLoginunameAndLoginpassword(loginuname, loginpassword);
		
	}*/
	
	
	
	
	
}
