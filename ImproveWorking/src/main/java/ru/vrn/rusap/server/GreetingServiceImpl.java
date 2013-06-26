package ru.vrn.rusap.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vrn.rusap.client.GreetingService;
import ru.vrn.rusap.server.dao.GreetingServiceDao;
import ru.vrn.rusap.shared.FieldVerifier;
import ru.vrn.rusap.shared.model.ListOfMonitoring;
import ru.vrn.rusap.shared.model.User;
import ru.vrn.rusap.shared.model.UsersAD;
import ru.vrn.rusap.shared.transfer.ListOfMonitoringTransfer;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@Service("productService")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {
	
	@Autowired
	private GreetingServiceDao dao;

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

	@Transactional
	public void get(int i) {
		System.out.println("******************************** start : " + i);
		UsersAD usersAD = dao.get(new Long(i));
		System.out.println("******************************** finish "
				+ usersAD.getAccount() + "  " + usersAD.getDepartment() + "  "
				+ usersAD.getName());
	}

	@Transactional
	public List<UsersAD> getListUsersAD() {
		
		
		
		
//		List<UsersAD> list  = dao.getAllUsersAD();
//		for (UsersAD usersAD : list) {
//			System.out.println("usersAD " + usersAD.getName());
//		}
		return dao.getAllUsersAD();
	}

	@Transactional
	public String getInformationByUser(UsersAD usersAD) {
		
//		System.out.println("usersAD " + usersAD.getAccount() + " name " +usersAD.getName());
		
		return dao.getInformation(usersAD);
	}

	@Transactional
	public List<String> getDbs() {
		return dao.getDbs();
	}

	@Transactional
	public ListOfMonitoringTransfer getDbByString(String string) {
		
		ListOfMonitoringTransfer lis = dao.getBaseByString(string);
		
		System.out.println("lis " + lis);
		
		return lis;
	}

	@Transactional
	public boolean addBase(ListOfMonitoring base) {
		
		boolean bool  = dao.addNewDatabase(base);
		return bool;
	}

//	@Override
//	public boolean changeExistBase(String string) {
//		boolean bool  = dao.changeExistDatabase(string);
//		return false;
//	}

	@Transactional
	public boolean changeExistBase(ListOfMonitoringTransfer base) {
//		System.out.println("lalala " + base);
		return dao.changeExistDatabase(base);
//		return false;
	}

	@Transactional
	public boolean addNetworkRule(String rule, UsersAD usersAD) {
		// TODO Auto-generated method stub
		return dao.addNetworkRules(rule, usersAD);
	}

	@Override
	public boolean checkUser(User person) {
		return dao.checkUserForAutorization(person);
	}

//	@Override
//	public boolean addBase(ListOfMonitoring base) {
//		return false;
//	}
}
