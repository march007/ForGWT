package ru.vrn.rusap.client;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class GreetingService_Proxy extends RemoteServiceProxy implements ru.vrn.rusap.client.GreetingServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "ru.vrn.rusap.client.GreetingService";
  private static final String SERIALIZATION_POLICY ="7D74AE8E7E497903C03B2FD3537A686B";
  private static final ru.vrn.rusap.client.GreetingService_TypeSerializer SERIALIZER = new ru.vrn.rusap.client.GreetingService_TypeSerializer();
  
  public GreetingService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "ecm/productService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void addBase(ru.vrn.rusap.shared.model.ListOfMonitoring base, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.addBase", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("addBase");
      streamWriter.writeInt(1);
      streamWriter.writeString("ru.vrn.rusap.shared.model.ListOfMonitoring/736375175");
      streamWriter.writeObject(base);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.addBase", requestId, "requestSerialized"));
      doInvoke(ResponseReader.BOOLEAN, "GreetingService_Proxy.addBase", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void addNetworkRule(java.lang.String rule, ru.vrn.rusap.shared.model.UsersAD usersAD, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.addNetworkRule", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("addNetworkRule");
      streamWriter.writeInt(2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("ru.vrn.rusap.shared.model.UsersAD/748693587");
      streamWriter.writeString(rule);
      streamWriter.writeObject(usersAD);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.addNetworkRule", requestId, "requestSerialized"));
      doInvoke(ResponseReader.BOOLEAN, "GreetingService_Proxy.addNetworkRule", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void changeExistBase(ru.vrn.rusap.shared.transfer.ListOfMonitoringTransfer base, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.changeExistBase", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("changeExistBase");
      streamWriter.writeInt(1);
      streamWriter.writeString("ru.vrn.rusap.shared.transfer.ListOfMonitoringTransfer/2758543739");
      streamWriter.writeObject(base);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.changeExistBase", requestId, "requestSerialized"));
      doInvoke(ResponseReader.BOOLEAN, "GreetingService_Proxy.changeExistBase", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void checkUser(ru.vrn.rusap.shared.model.User person, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.checkUser", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("checkUser");
      streamWriter.writeInt(1);
      streamWriter.writeString("ru.vrn.rusap.shared.model.User/824130047");
      streamWriter.writeObject(person);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.checkUser", requestId, "requestSerialized"));
      doInvoke(ResponseReader.BOOLEAN, "GreetingService_Proxy.checkUser", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void get(int i, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.get", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("get");
      streamWriter.writeInt(1);
      streamWriter.writeString("I");
      streamWriter.writeInt(i);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.get", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "GreetingService_Proxy.get", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getDbByString(java.lang.String string, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.getDbByString", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getDbByString");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(string);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.getDbByString", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "GreetingService_Proxy.getDbByString", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getDbs(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.getDbs", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getDbs");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.getDbs", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "GreetingService_Proxy.getDbs", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getInformationByUser(ru.vrn.rusap.shared.model.UsersAD usersAD, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.getInformationByUser", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getInformationByUser");
      streamWriter.writeInt(1);
      streamWriter.writeString("ru.vrn.rusap.shared.model.UsersAD/748693587");
      streamWriter.writeObject(usersAD);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.getInformationByUser", requestId, "requestSerialized"));
      doInvoke(ResponseReader.STRING, "GreetingService_Proxy.getInformationByUser", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getListUsersAD(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.getListUsersAD", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getListUsersAD");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.getListUsersAD", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "GreetingService_Proxy.getListUsersAD", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void greetServer(java.lang.String input, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.greetServer", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("greetServer");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(input);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("GreetingService_Proxy.greetServer", requestId, "requestSerialized"));
      doInvoke(ResponseReader.STRING, "GreetingService_Proxy.greetServer", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
