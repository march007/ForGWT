package ru.vrn.com.context;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.jinterop.dcom.common.JIException;

import ru.vrn.com.LogIt;
import ru.vrn.com.ad.AccessForActiveDirectory.UserRec;
import ru.vrn.com.datamodel.ListOfMonitoring;
import ru.vrn.com.datamodel.UsersAD;
import ru.vrn.com.exception.ExceptionCustom;
import ru.vrn.com.exception.IOExceptionCustom;
import ru.vrn.com.exception.JIExceptionCustom;

import com.ipc.oce.ApplicationDriver;
import com.ipc.oce.OCApp;
import com.ipc.oce.PropertiesReader;
import com.ipc.oce.exceptions.ConfigurationException;
import com.ipc.oce.objects.OCInfoBaseUser;
import com.ipc.oce.objects.OCInfoBaseUsersManager;
import com.ipc.oce.objects.OCUserArray;
import static com.ipc.oce.ConfigurationConstants.OCE_CFG_1CDB_PASSWORD;
import static com.ipc.oce.ConfigurationConstants.OCE_CFG_1CDB_USER;
import static com.ipc.oce.ConfigurationConstants.OCE_CFG_1CREF;
import static com.ipc.oce.ConfigurationConstants.OCE_CFG_1CSRVR;
import static com.ipc.oce.ConfigurationConstants.OCE_CFG_DOMAIN;
import static com.ipc.oce.ConfigurationConstants.OCE_CFG_DRIVER;
import static com.ipc.oce.ConfigurationConstants.OCE_CFG_HOST;
import static com.ipc.oce.ConfigurationConstants.OCE_CFG_HOST_PASSWORD;
import static com.ipc.oce.ConfigurationConstants.OCE_CFG_HOST_USER;



/**
 * 
 * Предназначен для получения данных о доступе к
 * пользователей к базам 1С.
 * 
 * @author marchenko
 * 
 * @create 07.06.2013
 * 
 */
public class CheckUsers {
	
	List<ListOfMonitoring> list;
	List<UserRec> lastList;
	private int count = 0;
	public CheckUsers() {
	}
	
	public CheckUsers(List<ListOfMonitoring> list, List<UserRec> lastList ){
		this.list = list;
		this.lastList = lastList;
	}

	
	
	/**
	 * 
	 * 
	 * @param usersADs - список пользователей Active Directory
	 * @param time - текущая дата со временем.
	 * 
	 * @return Map<ListOfMonitoring, List<UsersAD>>
	 *            - Карта соответствий доступа базы данных и пользователя. То
	 *            есть у одной базы может быть несколько пользователей, это
	 *            соответствие проводиться как карта ключ у которой база данных,
	 *            а значение список пользователей Active Directory.
	 *            
	 *            
	 * @throws IOExceptionCustom  - Исключение ввода вывода.
	 * @throws JIExceptionCustom  - Исключение при получении данных из базы 1С. 
	 * @throws ConfigurationException - Исключение конфигурации базы 1С
	 * Возникают, из-за недоступности сети, из-за недоступности базы, из-за ограниченного доступа к базе.
	 * 
	 * 
	 * @see ru.vrn.com.exception.IOExceptionCustom
	 * @see ru.vrn.com.exception.JIExceptionCustom
	 * @see  ru.vrn.com.exception.ConfigurationException
	 */
	Map<ListOfMonitoring, List<UsersAD>> getMapAccess(List<UsersAD> usersADs, Timestamp time) throws IOExceptionCustom, ConfigurationException, JIExceptionCustom {
		
		Map<ListOfMonitoring, List<UsersAD>>  map = new HashMap<ListOfMonitoring, List<UsersAD>>();
		
			try {
				iterationBy1cBases(usersADs, map, 0);
			} catch (JIExceptionCustom e) {
				LogIt.log(e);
				if (count < 3){
					e.printStackTrace();
					iterationBy1cBases(usersADs, map, e.getI());
					count++;
				}else{
					iterationBy1cBases(usersADs, map, e.getI()+1);
					count=0;
				}
			} catch (IOExceptionCustom ioe){
				LogIt.log(ioe);
				if (count < 3){
					ioe.printStackTrace();
					iterationBy1cBases(usersADs, map, ioe.getI());
					count++;
				}else{
					iterationBy1cBases(usersADs, map, ioe.getI()+1);
					count=0;
				}
			}
		
		return map;
	}

	/**
	 * 
	 * 
	 * @param usersADs - список пользователей Active Directory
	 * @param map
	 *            - Карта соответствий доступа базы данных и пользователя. То
	 *            есть у одной базы может быть несколько пользователей, это
	 *            соответствие проводиться как карта ключ у которой база данных,
	 *            а значение список пользователей Active Directory.
	 *            
	 * @param startIndex - индекс, с которого следует начинать итерацию по базам 1С.            
	 *            
	 * @throws IOExceptionCustom  - Исключение ввода вывода.
	 * @throws JIExceptionCustom  - Исключение при получении данных из базы 1С. 
	 * Возникают, из-за недоступности сети, из-за недоступности базы, из-за ограниченного доступа к базе.
	 * 
	 * 
	 * @see ru.vrn.com.exception.IOExceptionCustom
	 * @see ru.vrn.com.exception.JIExceptionCustom
	 */
	private void iterationBy1cBases(List<UsersAD> usersADs,
			Map<ListOfMonitoring, List<UsersAD>> map, int startIndex) throws IOExceptionCustom, JIExceptionCustom {
		
		for (int i = startIndex; i < list.size(); i++) {
			
			ListOfMonitoring monitor = list.get(i);
			
			LogIt.log("1С скуль база для мониторинга " + monitor);
		      Properties configuration = new Properties();
		        
		        configuration.setProperty(OCE_CFG_DRIVER, monitor.getVersion());
		        configuration.setProperty(OCE_CFG_HOST, monitor.getHost());
		        configuration.setProperty(OCE_CFG_HOST_USER, monitor.getUser());
		        configuration.setProperty(OCE_CFG_HOST_PASSWORD,monitor.getHostPassword());
		        configuration.setProperty(OCE_CFG_DOMAIN, monitor.getDomain());
		        configuration.setProperty(OCE_CFG_1CDB_USER, monitor.getHostUser());
		        configuration.setProperty(OCE_CFG_1CDB_PASSWORD, monitor.getProgram1cPassword());
		        configuration.setProperty(OCE_CFG_1CSRVR, monitor.getSrv());
		        configuration.setProperty(OCE_CFG_1CREF, monitor.getRef());
		        
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
		                		String osUser = infobaseUser.getOSUser();
		                		String kinder = osUser.substring(osUser.lastIndexOf("\\")+1);
		                		 
		                		for (UsersAD var : usersADs) {
		                			
									if (var.getAccount().equals(kinder)){
				                		
				                		ads.add(var);
				                		System.out.println("ads.size -----------------------  " + ads.size());
				                		System.out.println("user  ===  " + var.getAccount());
				                		break;
									}
								}
		                	}
						}
		                
		            	LogIt.log("listMonitoring " + monitor.getRef());
                		map.put(monitor, ads);
		    	} catch (JIException e) {
		    		LogIt.log(e);
					e.printStackTrace();
					JIExceptionCustom custom = new JIExceptionCustom(e.getErrorCode());
					custom.setI(i);
					throw custom;
				} catch (IOException e) {
					LogIt.log(e);
					e.printStackTrace();
					IOExceptionCustom exceptionCustom = new IOExceptionCustom();
					exceptionCustom.setI(i);
					throw exceptionCustom;
		        }finally{
		                try {
		                  app.exit();
		                } catch (JIException e) {
		                	LogIt.log(e);
		                }
		        }
		}
	}

}
