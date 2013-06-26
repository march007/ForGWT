package ru.vrn.rusap.shared.model;

@SuppressWarnings("deprecation")
public class AccessFor1CDetail_FieldSerializer {
  private static native ru.vrn.rusap.shared.model.AccessFor1C getAccessFor1C(ru.vrn.rusap.shared.model.AccessFor1CDetail instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.AccessFor1CDetail::accessFor1C;
  }-*/;
  
  private static native void  setAccessFor1C(ru.vrn.rusap.shared.model.AccessFor1CDetail instance, ru.vrn.rusap.shared.model.AccessFor1C value) /*-{
    instance.@ru.vrn.rusap.shared.model.AccessFor1CDetail::accessFor1C = value;
  }-*/;
  
  private static native ru.vrn.rusap.shared.model.ListOfMonitoring getListOfMonitoring(ru.vrn.rusap.shared.model.AccessFor1CDetail instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.AccessFor1CDetail::listOfMonitoring;
  }-*/;
  
  private static native void  setListOfMonitoring(ru.vrn.rusap.shared.model.AccessFor1CDetail instance, ru.vrn.rusap.shared.model.ListOfMonitoring value) /*-{
    instance.@ru.vrn.rusap.shared.model.AccessFor1CDetail::listOfMonitoring = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, ru.vrn.rusap.shared.model.AccessFor1CDetail instance) throws com.google.gwt.user.client.rpc.SerializationException{
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-2", streamReader.readString());
    setAccessFor1C(instance, (ru.vrn.rusap.shared.model.AccessFor1C) streamReader.readObject());
    setListOfMonitoring(instance, (ru.vrn.rusap.shared.model.ListOfMonitoring) streamReader.readObject());
    
  }
  
  public static native ru.vrn.rusap.shared.model.AccessFor1CDetail instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @ru.vrn.rusap.shared.model.AccessFor1CDetail::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, ru.vrn.rusap.shared.model.AccessFor1CDetail instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-2"));
    streamWriter.writeObject(getAccessFor1C(instance));
    streamWriter.writeObject(getListOfMonitoring(instance));
    
  }
  
}
