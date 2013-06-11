package ru.vrn.com.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vrn.com.client.GreetingService;
import ru.vrn.com.server.dao.GreetingServiceDao;
import ru.vrn.com.shared.FieldVerifier;
import ru.vrn.com.shared.model.UsersAD;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */

@Service("productService")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GreetingServiceDao dao;

	public String greetServer(String input) throws IllegalArgumentException {

		System.out.println("unput " + input);
		// Verify that the input is valid.
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			System.out.println("**********************************");
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		System.out.println("////////////////////////////////////////");

		return "Hello, " + input + "!<br><br>I am running ";

		/*
		 * String serverInfo = getServletContext().getServerInfo(); String
		 * userAgent = getThreadLocalRequest().getHeader("User-Agent");
		 * 
		 * // Escape data from the client to avoid cross-site script
		 * vulnerabilities. input = escapeHtml(input); userAgent =
		 * escapeHtml(userAgent);
		 * 
		 * return "Hello, " + input + "!<br><br>I am running " + serverInfo +
		 * ".<br><br>It looks like you are using:<br>" + userAgent;
		 */
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

	/*
	 * @Transactional(readOnly=true) public void get(UsersAD product) {
	 * System.out.println("******************************** start"); UsersAD
	 * usersAD = dao.get(new Long(13));
	 * System.out.println("******************************** finish " +
	 * usersAD.getAccount() + "  " + usersAD.getDepartment() +"  " +
	 * usersAD.getName()); }
	 */

	@Transactional
	public void get(int i) {
		System.out.println("******************************** start : " + i);
		UsersAD usersAD = dao.get(new Long(i));
		System.out.println("******************************** finish "
				+ usersAD.getAccount() + "  " + usersAD.getDepartment() + "  "
				+ usersAD.getName());
	}

	/*
	 * @Transactional(readOnly=false)
	 * 
	 * @Override public void delete(ECMProduct product) { dao.delete(product); }
	 * 
	 * @Transactional(readOnly=true)
	 * 
	 * @Override public ECMProduct get(Long id) { ECMProduct product =
	 * dao.get(id); if(product != null) {
	 * product.setComponents(GWTUtil.makeGWTSafe(product.getComponents())); }
	 * return product; }
	 */
}
