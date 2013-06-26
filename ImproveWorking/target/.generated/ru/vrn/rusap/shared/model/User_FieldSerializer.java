package ru.vrn.rusap.shared.model;

@SuppressWarnings("deprecation")
public class User_FieldSerializer {
  private static native java.lang.String getLogin(ru.vrn.rusap.shared.model.User instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.User::login;
  }-*/;
  
  private static native void  setLogin(ru.vrn.rusap.shared.model.User instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.User::login = value;
  }-*/;
  
  private static native java.lang.String getMail(ru.vrn.rusap.shared.model.User instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.User::mail;
  }-*/;
  
  private static native void  setMail(ru.vrn.rusap.shared.model.User instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.User::mail = value;
  }-*/;
  
  private static native java.lang.String getPassword(ru.vrn.rusap.shared.model.User instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.User::password;
  }-*/;
  
  private static native void  setPassword(ru.vrn.rusap.shared.model.User instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.User::password = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, ru.vrn.rusap.shared.model.User instance) throws com.google.gwt.user.client.rpc.SerializationException{
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-2", streamReader.readString());
    setLogin(instance, streamReader.readString());
    setMail(instance, streamReader.readString());
    setPassword(instance, streamReader.readString());
    
  }
  
  public static native ru.vrn.rusap.shared.model.User instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @ru.vrn.rusap.shared.model.User::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, ru.vrn.rusap.shared.model.User instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-2"));
    streamWriter.writeString(getLogin(instance));
    streamWriter.writeString(getMail(instance));
    streamWriter.writeString(getPassword(instance));
    
  }
  
}
