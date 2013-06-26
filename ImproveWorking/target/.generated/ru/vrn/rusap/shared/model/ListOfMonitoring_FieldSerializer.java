package ru.vrn.rusap.shared.model;

@SuppressWarnings("deprecation")
public class ListOfMonitoring_FieldSerializer {
  private static native java.lang.String getVersion(ru.vrn.rusap.shared.model.ListOfMonitoring instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::Version;
  }-*/;
  
  private static native void  setVersion(ru.vrn.rusap.shared.model.ListOfMonitoring instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::Version = value;
  }-*/;
  
  private static native java.util.Set getAccessFor1CDetail(ru.vrn.rusap.shared.model.ListOfMonitoring instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::accessFor1CDetail;
  }-*/;
  
  private static native void  setAccessFor1CDetail(ru.vrn.rusap.shared.model.ListOfMonitoring instance, java.util.Set value) /*-{
    instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::accessFor1CDetail = value;
  }-*/;
  
  private static native java.lang.String getDomain(ru.vrn.rusap.shared.model.ListOfMonitoring instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::domain;
  }-*/;
  
  private static native void  setDomain(ru.vrn.rusap.shared.model.ListOfMonitoring instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::domain = value;
  }-*/;
  
  private static native java.lang.String getHost(ru.vrn.rusap.shared.model.ListOfMonitoring instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::host;
  }-*/;
  
  private static native void  setHost(ru.vrn.rusap.shared.model.ListOfMonitoring instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::host = value;
  }-*/;
  
  private static native java.lang.String getHostPassword(ru.vrn.rusap.shared.model.ListOfMonitoring instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::hostPassword;
  }-*/;
  
  private static native void  setHostPassword(ru.vrn.rusap.shared.model.ListOfMonitoring instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::hostPassword = value;
  }-*/;
  
  private static native java.lang.String getHostUser(ru.vrn.rusap.shared.model.ListOfMonitoring instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::hostUser;
  }-*/;
  
  private static native void  setHostUser(ru.vrn.rusap.shared.model.ListOfMonitoring instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::hostUser = value;
  }-*/;
  
  private static native java.lang.String getPath(ru.vrn.rusap.shared.model.ListOfMonitoring instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::path;
  }-*/;
  
  private static native void  setPath(ru.vrn.rusap.shared.model.ListOfMonitoring instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::path = value;
  }-*/;
  
  private static native java.lang.String getProgram1cPassword(ru.vrn.rusap.shared.model.ListOfMonitoring instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::program1cPassword;
  }-*/;
  
  private static native void  setProgram1cPassword(ru.vrn.rusap.shared.model.ListOfMonitoring instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::program1cPassword = value;
  }-*/;
  
  private static native java.lang.String getRef(ru.vrn.rusap.shared.model.ListOfMonitoring instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::ref;
  }-*/;
  
  private static native void  setRef(ru.vrn.rusap.shared.model.ListOfMonitoring instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::ref = value;
  }-*/;
  
  private static native boolean getSqlActive(ru.vrn.rusap.shared.model.ListOfMonitoring instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::sqlActive;
  }-*/;
  
  private static native void  setSqlActive(ru.vrn.rusap.shared.model.ListOfMonitoring instance, boolean value) /*-{
    instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::sqlActive = value;
  }-*/;
  
  private static native java.lang.String getSrv(ru.vrn.rusap.shared.model.ListOfMonitoring instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::srv;
  }-*/;
  
  private static native void  setSrv(ru.vrn.rusap.shared.model.ListOfMonitoring instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::srv = value;
  }-*/;
  
  private static native java.lang.String getUser(ru.vrn.rusap.shared.model.ListOfMonitoring instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::user;
  }-*/;
  
  private static native void  setUser(ru.vrn.rusap.shared.model.ListOfMonitoring instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.ListOfMonitoring::user = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, ru.vrn.rusap.shared.model.ListOfMonitoring instance) throws com.google.gwt.user.client.rpc.SerializationException{
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-3", streamReader.readString());
    setVersion(instance, streamReader.readString());
    setAccessFor1CDetail(instance, (java.util.Set) streamReader.readObject());
    setDomain(instance, streamReader.readString());
    setHost(instance, streamReader.readString());
    setHostPassword(instance, streamReader.readString());
    setHostUser(instance, streamReader.readString());
    setPath(instance, streamReader.readString());
    setProgram1cPassword(instance, streamReader.readString());
    setRef(instance, streamReader.readString());
    setSqlActive(instance, streamReader.readBoolean());
    setSrv(instance, streamReader.readString());
    setUser(instance, streamReader.readString());
    
  }
  
  public static native ru.vrn.rusap.shared.model.ListOfMonitoring instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @ru.vrn.rusap.shared.model.ListOfMonitoring::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, ru.vrn.rusap.shared.model.ListOfMonitoring instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-3"));
    streamWriter.writeString(getVersion(instance));
    streamWriter.writeObject(getAccessFor1CDetail(instance));
    streamWriter.writeString(getDomain(instance));
    streamWriter.writeString(getHost(instance));
    streamWriter.writeString(getHostPassword(instance));
    streamWriter.writeString(getHostUser(instance));
    streamWriter.writeString(getPath(instance));
    streamWriter.writeString(getProgram1cPassword(instance));
    streamWriter.writeString(getRef(instance));
    streamWriter.writeBoolean(getSqlActive(instance));
    streamWriter.writeString(getSrv(instance));
    streamWriter.writeString(getUser(instance));
    
  }
  
}
