package ru.vrn.rusap.client.frontend;

import com.google.gwt.resources.client.ResourcePrototype;
import com.google.gwt.core.client.GWT;

public class ru_vrn_rusap_client_frontend_LogonForm_LogonFormUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements ru.vrn.rusap.client.frontend.LogonForm_LogonFormUiBinderImpl_GenBundle {
  public ru.vrn.rusap.client.frontend.LogonForm_LogonFormUiBinderImpl_GenCss_style style() {
    if (style == null) {
      style = new ru.vrn.rusap.client.frontend.LogonForm_LogonFormUiBinderImpl_GenCss_style() {
        private boolean injected;
        public boolean ensureInjected() {
          if (!injected) {
            injected = true;
            com.google.gwt.dom.client.StyleInjector.inject(getText());
            return true;
          }
          return false;
        }
        public String getName() {
          return "style";
        }
        public String getText() {
          return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".Gkn5jh1C{font-weight:" + ("bold")  + ";}.Gkn5jh1B{font-family:" + ("\"Ubuntu\""+ ","+ " " +"\"Lato\""+ ","+ " " +"sans-serif")  + ";font-weight:" + ("400")  + ";width:" + ("300px")  + ";position:" + ("relative")  + ";margin:" + ("60px"+ " " +"auto"+ " " +"30px")  + ";padding:" + ("10px")  + ";overflow:" + ("hidden")  + ";background:" + ("#111")  + ";border-radius:" + ("0.4em")  + ";border:") + (("1px"+ " " +"solid"+ " " +"#191919")  + ";box-shadow:" + ("inset"+ " " +"0"+ " " +"0"+ " " +"2px"+ " " +"1px"+ " " +"rgba(255,255,255,0.08)"+ ","+ " " +"0"+ " " +"16px"+ " " +"10px"+ " " +"-8px"+ " " +"rgba(0,0,0,0.6)")  + ";}.Gkn5jh1D{width:" + ("50%")  + ";float:" + ("right")  + ";padding:" + ("8px"+ " " +"5px")  + ";margin-bottom:" + ("10px")  + ";font-size:" + ("12px")  + ";background:" + ("linear-gradient(#1f2124,#27292c)")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#000")  + ";box-shadow:" + ("0"+ " " +"1px"+ " " +"0"+ " " +"rgba(255,255,255,0.1)")  + ";border-radius:" + ("3px") ) + (";font-family:" + ("\"Ubuntu\""+ ","+ " " +"\"Lato\""+ ","+ " " +"sans-serif")  + ";color:" + ("#fff")  + ";background:" + ("#27292c")  + ";}.Gkn5jh1E{width:" + ("50%")  + ";float:" + ("right")  + ";padding-top:" + ("9px")  + ";color:" + ("#ddd")  + ";font-size:" + ("12px")  + ";text-transform:" + ("uppercase")  + ";letter-spacing:" + ("1px")  + ";text-shadow:") + (("0"+ " " +"1px"+ " " +"0"+ " " +"#000")  + ";text-indent:" + ("10px")  + ";font-weight:" + ("700")  + ";cursor:" + ("pointer")  + ";}.Gkn5jh1E :hover,.Gkn5jh1D :hover{background:" + ("#27292c")  + ";}.Gkn5jh1E:focus,.Gkn5jh1D:focus{box-shadow:" + ("inset"+ " " +"0"+ " " +"0"+ " " +"2px"+ " " +"#000")  + ";background:" + ("#494d54")  + ";border-color:" + ("#51cbee")  + ";outline:" + ("none")  + ";}.Gkn5jh1A{width:" + ("100%")  + ";padding:" + ("8px"+ " " +"5px") ) + (";border:" + ("1px"+ " " +"solid"+ " " +"#0273dd")  + ";border:" + ("1px"+ " " +"solid"+ " " +"rgba(0,0,0,0.4)")  + ";box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"0"+ " " +"rgba(255,255,255,0.3)"+ ","+ " " +"inset"+ " " +"0"+ " " +"10px"+ " " +"10px"+ " " +"rgba(255,255,255,0.1)")  + ";border-radius:" + ("3px")  + ";background:" + ("#38a6f0")  + ";cursor:" + ("pointer")  + ";font-family:" + ("\"Ubuntu\""+ ","+ " " +"\"Lato\""+ ","+ " " +"sans-serif")  + ";color:" + ("white")  + ";font-weight:" + ("700")  + ";font-size:" + ("15px")  + ";text-shadow:") + (("0"+ " " +"-1px"+ " " +"0"+ " " +"rgba(0,0,0,0.8)")  + ";}.Gkn5jh1A:hover{box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"0"+ " " +"rgba(255,255,255,0.6)")  + ";}.Gkn5jh1A:active{background:" + ("#287db5")  + ";box-shadow:" + ("inset"+ " " +"0"+ " " +"0"+ " " +"3px"+ " " +"rgba(0,0,0,0.6)")  + ";border-color:" + ("#000")  + ";border-color:" + ("rgba(0,0,0,0.9)")  + ";}")) : ((".Gkn5jh1C{font-weight:" + ("bold")  + ";}.Gkn5jh1B{font-family:" + ("\"Ubuntu\""+ ","+ " " +"\"Lato\""+ ","+ " " +"sans-serif")  + ";font-weight:" + ("400")  + ";width:" + ("300px")  + ";position:" + ("relative")  + ";margin:" + ("60px"+ " " +"auto"+ " " +"30px")  + ";padding:" + ("10px")  + ";overflow:" + ("hidden")  + ";background:" + ("#111")  + ";border-radius:" + ("0.4em")  + ";border:") + (("1px"+ " " +"solid"+ " " +"#191919")  + ";box-shadow:" + ("inset"+ " " +"0"+ " " +"0"+ " " +"2px"+ " " +"1px"+ " " +"rgba(255,255,255,0.08)"+ ","+ " " +"0"+ " " +"16px"+ " " +"10px"+ " " +"-8px"+ " " +"rgba(0,0,0,0.6)")  + ";}.Gkn5jh1D{width:" + ("50%")  + ";float:" + ("left")  + ";padding:" + ("8px"+ " " +"5px")  + ";margin-bottom:" + ("10px")  + ";font-size:" + ("12px")  + ";background:" + ("linear-gradient(#1f2124,#27292c)")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#000")  + ";box-shadow:" + ("0"+ " " +"1px"+ " " +"0"+ " " +"rgba(255,255,255,0.1)")  + ";border-radius:" + ("3px") ) + (";font-family:" + ("\"Ubuntu\""+ ","+ " " +"\"Lato\""+ ","+ " " +"sans-serif")  + ";color:" + ("#fff")  + ";background:" + ("#27292c")  + ";}.Gkn5jh1E{width:" + ("50%")  + ";float:" + ("left")  + ";padding-top:" + ("9px")  + ";color:" + ("#ddd")  + ";font-size:" + ("12px")  + ";text-transform:" + ("uppercase")  + ";letter-spacing:" + ("1px")  + ";text-shadow:") + (("0"+ " " +"1px"+ " " +"0"+ " " +"#000")  + ";text-indent:" + ("10px")  + ";font-weight:" + ("700")  + ";cursor:" + ("pointer")  + ";}.Gkn5jh1E :hover,.Gkn5jh1D :hover{background:" + ("#27292c")  + ";}.Gkn5jh1E:focus,.Gkn5jh1D:focus{box-shadow:" + ("inset"+ " " +"0"+ " " +"0"+ " " +"2px"+ " " +"#000")  + ";background:" + ("#494d54")  + ";border-color:" + ("#51cbee")  + ";outline:" + ("none")  + ";}.Gkn5jh1A{width:" + ("100%")  + ";padding:" + ("8px"+ " " +"5px") ) + (";border:" + ("1px"+ " " +"solid"+ " " +"#0273dd")  + ";border:" + ("1px"+ " " +"solid"+ " " +"rgba(0,0,0,0.4)")  + ";box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"0"+ " " +"rgba(255,255,255,0.3)"+ ","+ " " +"inset"+ " " +"0"+ " " +"10px"+ " " +"10px"+ " " +"rgba(255,255,255,0.1)")  + ";border-radius:" + ("3px")  + ";background:" + ("#38a6f0")  + ";cursor:" + ("pointer")  + ";font-family:" + ("\"Ubuntu\""+ ","+ " " +"\"Lato\""+ ","+ " " +"sans-serif")  + ";color:" + ("white")  + ";font-weight:" + ("700")  + ";font-size:" + ("15px")  + ";text-shadow:") + (("0"+ " " +"-1px"+ " " +"0"+ " " +"rgba(0,0,0,0.8)")  + ";}.Gkn5jh1A:hover{box-shadow:" + ("inset"+ " " +"0"+ " " +"1px"+ " " +"0"+ " " +"rgba(255,255,255,0.6)")  + ";}.Gkn5jh1A:active{background:" + ("#287db5")  + ";box-shadow:" + ("inset"+ " " +"0"+ " " +"0"+ " " +"3px"+ " " +"rgba(0,0,0,0.6)")  + ";border-color:" + ("#000")  + ";border-color:" + ("rgba(0,0,0,0.9)")  + ";}"));
        }
        public java.lang.String button(){
          return "Gkn5jh1A";
        }
        public java.lang.String form3(){
          return "Gkn5jh1B";
        }
        public java.lang.String important(){
          return "Gkn5jh1C";
        }
        public java.lang.String input(){
          return "Gkn5jh1D";
        }
        public java.lang.String label(){
          return "Gkn5jh1E";
        }
      }
      ;
    }
    return style;
  }
  private static ru.vrn.rusap.client.frontend.LogonForm_LogonFormUiBinderImpl_GenCss_style style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      style(), 
    };
  }
  public native ResourcePrototype getResource(String name) /*-{
    switch (name) {
      case 'style': return this.@ru.vrn.rusap.client.frontend.LogonForm_LogonFormUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
