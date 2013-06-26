package ru.vrn.rusap.client;

import java.util.List;

import ru.vrn.rusap.shared.model.ListOfMonitoring;
import ru.vrn.rusap.shared.model.User;
import ru.vrn.rusap.shared.model.UsersAD;
import ru.vrn.rusap.shared.transfer.ListOfMonitoringTransfer;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void get(int i, AsyncCallback<Void> callback);

	void getListUsersAD(AsyncCallback<List<UsersAD>> callback);

	void getInformationByUser(UsersAD usersAD, AsyncCallback<String> callback);

	void getDbs(AsyncCallback<List<String>> callback);

	void getDbByString(String string,
			AsyncCallback<ListOfMonitoringTransfer> callback);

	void changeExistBase(ListOfMonitoringTransfer base,
			AsyncCallback<Boolean> callback);

	void addBase(ListOfMonitoring base, AsyncCallback<Boolean> callback);

	void addNetworkRule(String rule, UsersAD usersAD,
			AsyncCallback<Boolean> callback);

	void checkUser(User person, AsyncCallback<Boolean> callback);

}
