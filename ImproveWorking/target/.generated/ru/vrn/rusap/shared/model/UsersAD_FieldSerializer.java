package ru.vrn.rusap.shared.model;

@SuppressWarnings("deprecation")
public class UsersAD_FieldSerializer {
  private static native java.lang.String getAccount(ru.vrn.rusap.shared.model.UsersAD instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.UsersAD::account;
  }-*/;
  
  private static native void  setAccount(ru.vrn.rusap.shared.model.UsersAD instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.UsersAD::account = value;
  }-*/;
  
  private static native java.lang.String getDepartment(ru.vrn.rusap.shared.model.UsersAD instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.UsersAD::department;
  }-*/;
  
  private static native void  setDepartment(ru.vrn.rusap.shared.model.UsersAD instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.UsersAD::department = value;
  }-*/;
  
  private static native java.lang.String getDescription(ru.vrn.rusap.shared.model.UsersAD instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.UsersAD::description;
  }-*/;
  
  private static native void  setDescription(ru.vrn.rusap.shared.model.UsersAD instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.UsersAD::description = value;
  }-*/;
  
  private static native java.lang.String getExtraAttribute1(ru.vrn.rusap.shared.model.UsersAD instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.UsersAD::extraAttribute1;
  }-*/;
  
  private static native void  setExtraAttribute1(ru.vrn.rusap.shared.model.UsersAD instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.UsersAD::extraAttribute1 = value;
  }-*/;
  
  private static native java.lang.String getExtraAttribute2(ru.vrn.rusap.shared.model.UsersAD instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.UsersAD::extraAttribute2;
  }-*/;
  
  private static native void  setExtraAttribute2(ru.vrn.rusap.shared.model.UsersAD instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.UsersAD::extraAttribute2 = value;
  }-*/;
  
  private static native java.lang.String getExtraAttribute3(ru.vrn.rusap.shared.model.UsersAD instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.UsersAD::extraAttribute3;
  }-*/;
  
  private static native void  setExtraAttribute3(ru.vrn.rusap.shared.model.UsersAD instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.UsersAD::extraAttribute3 = value;
  }-*/;
  
  private static native java.lang.String getExtraAttribute4(ru.vrn.rusap.shared.model.UsersAD instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.UsersAD::extraAttribute4;
  }-*/;
  
  private static native void  setExtraAttribute4(ru.vrn.rusap.shared.model.UsersAD instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.UsersAD::extraAttribute4 = value;
  }-*/;
  
  private static native java.lang.String getExtraAttribute5(ru.vrn.rusap.shared.model.UsersAD instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.UsersAD::extraAttribute5;
  }-*/;
  
  private static native void  setExtraAttribute5(ru.vrn.rusap.shared.model.UsersAD instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.UsersAD::extraAttribute5 = value;
  }-*/;
  
  private static native java.lang.String getName(ru.vrn.rusap.shared.model.UsersAD instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.UsersAD::name;
  }-*/;
  
  private static native void  setName(ru.vrn.rusap.shared.model.UsersAD instance, java.lang.String value) /*-{
    instance.@ru.vrn.rusap.shared.model.UsersAD::name = value;
  }-*/;
  
  private static native boolean getStatus(ru.vrn.rusap.shared.model.UsersAD instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.UsersAD::status;
  }-*/;
  
  private static native void  setStatus(ru.vrn.rusap.shared.model.UsersAD instance, boolean value) /*-{
    instance.@ru.vrn.rusap.shared.model.UsersAD::status = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, ru.vrn.rusap.shared.model.UsersAD instance) throws com.google.gwt.user.client.rpc.SerializationException{
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-2", streamReader.readString());
    setAccount(instance, streamReader.readString());
    setDepartment(instance, streamReader.readString());
    setDescription(instance, streamReader.readString());
    setExtraAttribute1(instance, streamReader.readString());
    setExtraAttribute2(instance, streamReader.readString());
    setExtraAttribute3(instance, streamReader.readString());
    setExtraAttribute4(instance, streamReader.readString());
    setExtraAttribute5(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setStatus(instance, streamReader.readBoolean());
    
  }
  
  public static native ru.vrn.rusap.shared.model.UsersAD instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @ru.vrn.rusap.shared.model.UsersAD::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, ru.vrn.rusap.shared.model.UsersAD instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-2"));
    streamWriter.writeString(getAccount(instance));
    streamWriter.writeString(getDepartment(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getExtraAttribute1(instance));
    streamWriter.writeString(getExtraAttribute2(instance));
    streamWriter.writeString(getExtraAttribute3(instance));
    streamWriter.writeString(getExtraAttribute4(instance));
    streamWriter.writeString(getExtraAttribute5(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeBoolean(getStatus(instance));
    
  }
  
}
