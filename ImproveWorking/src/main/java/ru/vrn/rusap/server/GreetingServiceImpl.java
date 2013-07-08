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
 * Серверная сторона реализующая RPC сервис.
 * 
 * @autor marchenko
 * 
 * @create 25.05.2013 
 * 
 */
@Service("productService")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	@Autowired
	private GreetingServiceDao dao;

	public String greetServer(String input) throws IllegalArgumentException {
		if (!FieldVerifier.isValidName(input)) {
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html
	 *            the html string to escape
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
		UsersAD usersAD = dao.get(new Long(i));
		System.out.println("******************************** finish "
				+ usersAD.getAccount() + "  " + usersAD.getDepartment() + "  "
				+ usersAD.getName());
	}

	@Transactional
	public List<UsersAD> getListUsersAD() {
		return dao.getAllUsersAD();
	}

	@Transactional
	public String getInformationByUser(UsersAD usersAD) {
		return dao.getInformation(usersAD);
	}

	@Transactional
	public List<String> getDbs() {
		return dao.getDbs();
	}

	@Transactional
	public ListOfMonitoringTransfer getDbByString(String string) {
		return dao.getBaseByString(string);
	}

	@Transactional
	public boolean addBase(ListOfMonitoring base) {
		return dao.addNewDatabase(base);
	}

	@Transactional
	public boolean changeExistBase(ListOfMonitoringTransfer base) {
		return dao.changeExistDatabase(base);
	}

	@Transactional
	public boolean addNetworkRule(String rule, UsersAD usersAD) {
		return dao.addNetworkRules(rule, usersAD);
	}

	@Override
	public boolean checkUser(User person) {
		return dao.checkUserForAutorization(person);
	}
}
