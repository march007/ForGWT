package ru.vrn.com.util;

import java.util.Collection;
import java.util.List;

import javax.naming.NamingException;

import ru.vrn.com.ad.AccessForActiveDirectory;
import ru.vrn.com.ad.AccessForActiveDirectory.UserRec;
import ru.vrn.com.ad.exchange.AccessForExchange;

/**
 * 
 * Предназначен для подключения к Active Directory дереву, а также к Exchange.
 * 
 * @author marchenko
 * 
 * @create 07.06.2013
 * 
 */
public class Assistent {
	public Assistent() {
	}

	/**
	 * 
	 * Предназначена для получения списка времеенных классов, которые хранят
	 * данные о пользователе Active Directory
	 * 
	 * @return List<UserRec> - Список классов, которые хранят в себе информацию
	 *         о пользователе Active Directory
	 * 
	 * @see ru.vrn.com.ad.UserRec
	 */
	public List<UserRec> getUserFromActiveDirectory() {
		AccessForActiveDirectory ada = new AccessForActiveDirectory();
		try {
			ada.listAllUsers("uadmin", "**********");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return ada.getList();
	}

	/**
	 * 
	 * Предназначена для получения списка строк, которые хранят данные о
	 * пользователе Exchange
	 * 
	 * @return Collection<String> - Коллекция строк, которые хранят в себе
	 *         информацию о пользователе Exchange
	 * 
	 */
	public Collection<String> getUserFromActiveDirectoryExchange() {
		AccessForExchange accessExchange = new AccessForExchange();
		try {
			accessExchange.listAllUsers("Administrator", "************");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return accessExchange.getOnlyAccounts();
	}
}
