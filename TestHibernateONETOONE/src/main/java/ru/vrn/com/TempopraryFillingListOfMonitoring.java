package ru.vrn.com;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.hibernate.Session;
import org.jinterop.dcom.common.JIException;

import ru.vrn.com.datamodel.ListOfMonitoring;
import ru.vrn.com.datamodel.UsersAD;

import com.ipc.oce.ApplicationDriver;
import com.ipc.oce.OCApp;
import com.ipc.oce.PropertiesReader;
import com.ipc.oce.exceptions.ConfigurationException;
import com.ipc.oce.objects.OCInfoBaseUser;
import com.ipc.oce.objects.OCInfoBaseUsersManager;
import com.ipc.oce.objects.OCUserArray;

public class TempopraryFillingListOfMonitoring {
	private Session session;  
	
	public TempopraryFillingListOfMonitoring(Session session) {
		this.session = session;		
	}
	
	public TempopraryFillingListOfMonitoring() {
	}

	public TempopraryFillingListOfMonitoring(List<UsersAD> usersADs, Timestamp time, Session session) {
	}

	Map<ListOfMonitoring, List<UsersAD>> getMapAccess(List<UsersAD> usersADs, Timestamp time) throws IOException, ConfigurationException {
//		Timestamp time = new Timestamp(System.currentTimeMillis());
		
		Map<ListOfMonitoring, List<UsersAD>>  map = new HashMap<ListOfMonitoring, List<UsersAD>>();
		
		for (int i = 5; i < 22; i++) {
			PropertiesReader pr = new PropertiesReader(new File("D:\\my\\buh.properties"));
		      Properties configuration = pr.getPropertiesForInstance("inst"+i);
//		      System.out.println(configuration);	
		      
		      String tempString = configuration.toString().substring(1, configuration.toString().length()-1);
		      
		      String[] masString = tempString.split(", ");
		      
		     
		      ListOfMonitoring listMonitoring = new ListOfMonitoring();
		      
		      boolean bool = false;
		      
		      for (String string : masString) {
//				System.out.println("string " +string);
				
				String str1 = string.split("=")[0];				
				String str2 = string.split("=")[1];
//				System.out.println("---------------------------------------");
//				System.out.println("---- " +str1 + " ----- " + str2);
//				System.out.println("---------------------------------------");
				 
				
				
				 if (string.indexOf("oce.driver")!=(-1)){
					 listMonitoring.setVersion(str2); 
				 }else if (string.indexOf("oce.1c.password")!=(-1)){
					 listMonitoring.setProgram1cPassword(str2); 
				 }else if (string.indexOf("oce.1c.user")!=(-1)){
					 listMonitoring.setHostUser(str2); 
				 }else if (string.indexOf("oce.domain")!=(-1)){
					 listMonitoring.setDomain(str2);
				 }else if (string.indexOf("oce.host.user")!=(-1)){
					 listMonitoring.setUser(str2);
				 }else if (string.indexOf("oce.1c.srvr")!=(-1)){
					 listMonitoring.setSrv(str2);
					 listMonitoring.setSqlActive(true);
				 }else if ((string.indexOf("oce.host")!=(-1))&&(string.indexOf("oce.host.password")==(-1))){
					 listMonitoring.setHost(str2);
				 }else if (string.indexOf("oce.1c.ref")!=(-1)){
					 listMonitoring.setRef(str2);
					 listMonitoring.setSqlActive(true);
				 }else if (string.indexOf("oce.host.password")!=(-1)){
					 listMonitoring.setHostPassword(str2);
				 }
				 
			}
		      
		      listMonitoring.setDateLastMofification(time);
		      System.out.println("**************************************************");
		      System.out.println(listMonitoring.toString());
		      System.out.println("**************************************************");
		      
		      System.out.println(configuration);
		        
		        ApplicationDriver driver = ApplicationDriver.loadDriver((String) configuration.get( PropertiesReader.OCE_CFG_DRIVER ) );
		        driver.setAutoRegistration(true); 
		        OCApp app = OCApp.getNewInstance();
		        
		        
		        app.setApplicationDriver(driver);
		        try{
		                app.connect(configuration);
		                System.out.println("Connected to " + app.getComputerName());
		                
		                OCInfoBaseUsersManager infoBaseManager = app.getInfoBaseUserManager();
		                
		                OCUserArray users = infoBaseManager.getUsers();
		                
		                List<UsersAD> ads = new ArrayList<UsersAD>();;
		                
		                for (int j = 0; j < users.size(); j++) {
		                	
		                	OCInfoBaseUser infobaseUser  = users.getUser(j);
		                	
		                	if (infobaseUser.isOSAuthentication()){
//		                		System.out.println();
		                		String osUser = infobaseUser.getOSUser();
//		                		System.out.println("osUser " +osUser);
		                		
//		                		System.out.println(osUser.split("\\"));
		                		
		                		String kinder = osUser.substring(osUser.lastIndexOf("\\")+1);
		                		
		                		 
		                		for (UsersAD var : usersADs) {
		                			
									if (var.getAccount().equals(kinder)){
										
//										AccessFor1C for1c = new AccessFor1C();
//				                		for1c.setDateLastMofification(time);
//				                		for1c.setHomeAddress(var);
//				                		
//				                		AccessFor1CDetail accessFor1CDetail = new AccessFor1CDetail();
//				                		accessFor1CDetail.setListOfBases1C(listMonitoring);
//				                		accessFor1CDetail.setAccessFor1C(for1c);
				                		
				                		ads.add(var);
				                		System.out.println("ads.size -----------------------  " + ads.size());
				                		System.out.println("user  ===  " + var.getAccount());
//				                		if (this.session.isOpen()){
//				          		    	  this.session.beginTransaction();
//				          		    	  
//				          		    	 this.session.save(var);
//				          		    	  this.session.save(listMonitoring);
//				          		    	  this.session.save(for1c);
//				          		    	  this.session.save(accessFor1CDetail);
//				          		    	  
//				          		    	  this.session.getTransaction().commit();
//				          		      }
				                		break;
									}
								}
		                	
		                		
		                	}
		                	
						}
		                
		            	System.out.println("listMonitoring " + listMonitoring.getRef());
                		map.put(listMonitoring, ads);
		                
		                System.out.println("Computer name: "+app.getComputerName());
		        }catch(Exception e){
		                System.out.println(e.getStackTrace());
		                e.printStackTrace();
		        }finally{
		                try {
		                	
		                	 System.out.println("exit");
		                        app.exit();
		                        System.out.println("exit");
		                        
		                } catch (JIException e) {
		                        
		                }
		        }
		      
		      
		      
//		      if (this.session.isOpen()){
//		    	  this.session.beginTransaction();
//		    	  
//		    	  this.session.save(listMonitoring);
//		    	  this.session.getTransaction().commit();
//		      }
		}
		return map;
	}

//	public Map<ListOfMonitoring, List<UsersAD>> getMapAccess() {
//		return null;
//	}
	
	
}
