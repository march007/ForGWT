package ru.vrn.rusap.client;

import java.util.List;

import ru.vrn.rusap.shared.model.ListOfMonitoring;
import ru.vrn.rusap.shared.model.User;
import ru.vrn.rusap.shared.model.UsersAD;
import ru.vrn.rusap.shared.transfer.ListOfMonitoringTransfer;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("ecm/productService")
public interface GreetingService extends RemoteService {
	String greetServer(String name) throws IllegalArgumentException;
	public void get(int i);
	public List<UsersAD> getListUsersAD();
	public String getInformationByUser(UsersAD usersAD);
	public List<String> getDbs();
	public ListOfMonitoringTransfer getDbByString(String string);
	public boolean addBase(ListOfMonitoring base );
	public boolean changeExistBase(ListOfMonitoringTransfer base);
	public boolean addNetworkRule(String rule, UsersAD usersAD);
	public boolean checkUser(User person);
}
