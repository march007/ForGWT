package ru.vrn.rusap.shared.model.superclass;

@SuppressWarnings("deprecation")
public class Access_FieldSerializer {
  private static native ru.vrn.rusap.shared.model.UsersAD getHomeAddress(ru.vrn.rusap.shared.model.superclass.Access instance) /*-{
    return instance.@ru.vrn.rusap.shared.model.superclass.Access::homeAddress;
  }-*/;
  
  private static native void  setHomeAddress(ru.vrn.rusap.shared.model.superclass.Access instance, ru.vrn.rusap.shared.model.UsersAD value) /*-{
    instance.@ru.vrn.rusap.shared.model.superclass.Access::homeAddress = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, ru.vrn.rusap.shared.model.superclass.Access instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setHomeAddress(instance, (ru.vrn.rusap.shared.model.UsersAD) streamReader.readObject());
    
  }
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, ru.vrn.rusap.shared.model.superclass.Access instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getHomeAddress(instance));
    
  }
  
}
