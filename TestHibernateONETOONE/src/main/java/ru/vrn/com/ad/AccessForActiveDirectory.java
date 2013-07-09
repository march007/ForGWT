package ru.vrn.com.ad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import ru.vrn.com.ad.exchange.AccessForExchange.UserRecExchange;

/**
 * Предназначен для взаимодействия с Active Directory.
 * 
 * 
 * @author marchenko
 * 
 * @create 15.06.2013
 */
public class AccessForActiveDirectory {
	private String domain;
	private String ldapHostAndPort;
	private String baseNode;
	List<UserRec> list = new ArrayList<UserRec>();

	public List<UserRec> getList() {
		return list;
	}

	/**
	 * Предназначена для получения только аккаунтов пользователей Active
	 * Directory.
	 * 
	 * @return Vector<String> - вектор аккаунтов пользователей Active Directory
	 * 
	 */
	public Vector<String> getOnlyAccounts() {

		Vector<String> listString = new Vector<String>(getList().size());
		for (UserRec u : getList()) {

			int start = u.getDescription().toString().indexOf("account");
			int finish = u.getDescription().toString().indexOf(",", start);

			String masString = u.getDescription().substring(start, finish);
			String strForAdd = masString.substring(masString.indexOf("=") + 2);
			listString.add(strForAdd);
		}
		return listString;

	}

	public void setList(List<UserRec> list) {
		this.list = list;
	}

	/**
	 * Парметры подключения к Active Directory
	 */
	public AccessForActiveDirectory() {
		this.domain = "rusap.local";
		this.ldapHostAndPort = "ldap://vrn-pdc.rusap.local:389";
		this.baseNode = "OU=Russkiy Appetit,DC=rusap,DC=local";
	}

	public AccessForActiveDirectory(String domain, String host, String dn) {
		this.domain = domain;
		this.ldapHostAndPort = host;
		this.baseNode = dn;
	}

	/**
	 * Предназначена для получения контекста параметров подключения к Active
	 * Directory
	 * 
	 * @param LdapContext
	 *            - интерфейс обеспечивает поддержку LDAP v3 контроля.
	 * 
	 * @see javax.naming.ldap.LdapContext
	 */
	public LdapContext getLDAPContext(String user, String pass)
			throws NamingException {
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, ldapHostAndPort);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, user + "@" + domain);
		env.put(Context.SECURITY_CREDENTIALS, pass);

		LdapContext ctxGC = null;

		ctxGC = new InitialLdapContext(env, null);

		return ctxGC;
	}

	/**
	 * @param user - пользователь с правами доступа к Active Directory.
	 * @param password - пароль для пользователя user.
	 * 
	 * 
	 * @return  StringBuilder содержит различную информацию (email,
	 *         username...) на пользователей, содержащихся в Active Directory дереве
	 * @throws NamingException
	 */
	public StringBuilder listAllUsers(String user, String password)
			throws NamingException {
		// Создание и инициализация DirContext с помощью LDAPContext.
		DirContext ctx = this.getLDAPContext(user, password);

		// Получение всего списка пользователей  и их членства		
		StringBuilder tailRecursion = new StringBuilder(1000);
		this.listSubContext(ctx, this.baseNode, tailRecursion);
		return tailRecursion;
	}

	private void listSubContext(DirContext ctx, String nm,
			StringBuilder tailRecursion) throws NamingException {
		String[] attributeNames = { "memberOf", "userAccountControl", "mail",
				"name", "sAMAccountName", "objectClass", "wWWHomePage",
				"description", "department" };
		NamingEnumeration contentsEnum = ctx.list(nm);
		while (contentsEnum.hasMore()) {
			NameClassPair ncp = (NameClassPair) contentsEnum.next();
			String userName = ncp.getName();

			Attributes attr1 = ctx.getAttributes(userName + "," + nm,
					new String[] { "objectClass" });
			if (attr1.get("objectClass").toString().indexOf("user") == -1) {
				listSubContext(ctx, userName + "," + nm, tailRecursion);
			} else {
				UserRec rec = new UserRec();
				Attributes attrs = ctx.getAttributes(userName + "," + nm,
						attributeNames);
				Attribute groupsAttribute = attrs.get("memberOf");
				Attribute bitsAttribute = attrs.get("userAccountControl");
				Attribute mailAttribute = attrs.get("mail");
				Attribute nameAttribute = attrs.get("name");
				Attribute accountAttribute = attrs.get("sAMAccountName");
				Attribute accountAttributeClass = attrs.get("objectClass");
				Attribute accountAttributeDepartment = attrs.get("department");
				Attribute accountAttributeDescription = attrs
						.get("description");
				Attribute accountAttributeExt = attrs.get("wWWHomePage");

				if (accountAttributeClass != null) {
					for (int i = 0; i < accountAttributeClass.size(); i++) {
						rec.objectClass = (String) accountAttributeClass.get(i);
					}
				}
				if (accountAttributeDepartment != null) {
					for (int i = 0; i < accountAttributeDepartment.size(); i++) {
						rec.department = (String) accountAttributeDepartment
								.get(i);
					}
				}
				if (accountAttributeDescription != null) {
					for (int i = 0; i < accountAttributeDescription.size(); i++) {
						rec.description1 = (String) accountAttributeDescription
								.get(i);
					}
				}
				if (accountAttributeExt != null) {
					for (int i = 0; i < accountAttributeExt.size(); i++) {
						rec.extension = (String) accountAttributeExt.get(i);
					}
				}

				if (accountAttribute != null) {
					for (int i = 0; i < accountAttribute.size(); i++) {
						String account = (String) accountAttribute.get(i);
						rec.account = account;
					}
				}
				if (groupsAttribute != null) {
					for (int i = 0; i < groupsAttribute.size(); i++) {
						rec.groups.add((String) groupsAttribute.get(i));
					}
				}
				if (bitsAttribute != null) {
					long lng = Long.parseLong(bitsAttribute.get(0).toString());
					long secondBit = lng & 2; // get bit 2
					if (secondBit == 0) {
						rec.enabled = true;
					}
				}
				if (mailAttribute != null) {
					for (int i = 0; i < mailAttribute.size(); i++) {
						rec.email = (String) mailAttribute.get(i);
					}
				}
				if (nameAttribute != null) {
					for (int i = 0; i < nameAttribute.size(); i++) {
						rec.name = (String) nameAttribute.get(i);
					}
				}
				list.add(rec);
				tailRecursion.append(rec.getDescription()).append("\n\n");
			}
		}
	}

	/**
	 * 
	 * Предназначен для хранения данных о пользователе Active Directory
	 */
	public class UserRec {

		public String description1;

		public String getDescription1() {
			return description1;
		}

		public void setDescription1(String description1) {
			this.description1 = description1;
		}

		String account;
		String name;
		List groups;

		String email;
		boolean enabled;
		String objectClass;
		String department;
		String description;
		String extension;

		public UserRec() {
			groups = new ArrayList();
			// acount = new ArrayList();
		}

		public StringBuilder getDescription() {
			StringBuilder sb = new StringBuilder(200);
			sb.append("{ name = ");
			sb.append(this.name);
			sb.append(", enabled = ");
			sb.append(this.enabled);
			sb.append(", email = ");
			sb.append(this.email);
			sb.append(", account = ");
			sb.append(this.account);
			sb.append(", groups = ");
			sb.append(this.groups);
			sb.append(", objectClass = ");
			sb.append(this.objectClass);
			sb.append(", department = ");
			sb.append(this.department);
			sb.append(", description = ");
			sb.append(this.description);
			sb.append(", wWWHomePage = ");
			sb.append(this.extension);
			sb.append(" }");
			return sb;
		}

		@Override
		public String toString() {
			return this.getDescription().toString();
		}

		public String getAccount() {
			return account;
		}

		public void setAccount(String account) {
			this.account = account;
		}

		public String getExtension() {
			return extension;
		}

		public void setExtension(String extension) {
			this.extension = extension;
		}

		public String getName() {
			return name;
		}

		public List getGroups() {
			return groups;
		}

		public String getEmail() {
			return email;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public String getObjectClass() {
			return objectClass;
		}

		public String getDepartment() {
			return department;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setGroups(List groups) {
			this.groups = groups;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public void setObjectClass(String objectClass) {
			this.objectClass = objectClass;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	}
}