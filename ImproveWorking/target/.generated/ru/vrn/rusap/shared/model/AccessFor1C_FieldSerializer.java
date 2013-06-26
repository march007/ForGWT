package ru.vrn.rusap.shared.model;

@SuppressWarnings("deprecation")
public class AccessFor1C_FieldSerializer {
  private static native java.util.Set getAccessFor1CDetail(ru.vrn.rusap.shared.model.AccessFor1C instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.AccessFor1C::accessFor1CDetail;
  }-*/;
  
  private static native void  setAccessFor1CDetail(ru.vrn.rusap.shared.model.AccessFor1C instance, java.util.Set value) /*-{
    instance.@ru.vrn.rusap.shared.model.AccessFor1C::accessFor1CDetail = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, ru.vrn.rusap.shared.model.AccessFor1C instance) throws com.google.gwt.user.client.rpc.SerializationException{
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-4", streamReader.readString());
    setAccessFor1CDetail(instance, (java.util.Set) streamReader.readObject());
    
    ru.vrn.rusap.shared.model.superclass.Access_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native ru.vrn.rusap.shared.model.AccessFor1C instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @ru.vrn.rusap.shared.model.AccessFor1C::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, ru.vrn.rusap.shared.model.AccessFor1C instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-4"));
    streamWriter.writeObject(getAccessFor1CDetail(instance));
    
    ru.vrn.rusap.shared.model.superclass.Access_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
