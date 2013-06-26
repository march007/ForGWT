package ru.vrn.rusap.client.frontend;

import com.google.gwt.resources.client.ResourcePrototype;
import com.google.gwt.core.client.GWT;

public class ru_vrn_rusap_client_frontend_MainPanel_MainPanelUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements ru.vrn.rusap.client.frontend.MainPanel_MainPanelUiBinderImpl_GenBundle {
  public ru.vrn.rusap.client.frontend.MainPanel_MainPanelUiBinderImpl_GenCss_style style() {
    if (style == null) {
      style = new ru.vrn.rusap.client.frontend.MainPanel_MainPanelUiBinderImpl_GenCss_style() {
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
          return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".Gkn5jh1I{font-weight:" + ("bold")  + ";}.Gkn5jh1G{width:" + ("100%")  + ";}.Gkn5jh1F{margin:" + ("1em"+ " " +"0"+ " " +"0.5em"+ " " +"0")  + ";font-weight:" + ("normal")  + ";position:" + ("relative")  + ";text-shadow:" + ("0"+ " " +"-1px"+ " " +"rgba(0,0,0,0.6)")  + ";font-size:" + ("28px")  + ";line-height:" + ("40px")  + ";background:" + ("#355681")  + ";background:" + ("rgba(53,86,129,0.8)")  + ";border:") + (("1px"+ " " +"solid"+ " " +"#fff")  + ";padding:" + ("5px"+ " " +"15px")  + ";color:" + ("white")  + ";border-radius:" + ("0"+ " " +"10px"+ " " +"0"+ " " +"10px")  + ";box-shadow:" + ("inset"+ " " +"0"+ " " +"0"+ " " +"5px"+ " " +"rgba(53,86,129,0.5)")  + ";font-family:" + ("\"Muli\""+ ","+ " " +"sans-serif")  + ";}.Gkn5jh1H{padding:" + ("15px")  + ";}")) : ((".Gkn5jh1I{font-weight:" + ("bold")  + ";}.Gkn5jh1G{width:" + ("100%")  + ";}.Gkn5jh1F{margin:" + ("1em"+ " " +"0"+ " " +"0.5em"+ " " +"0")  + ";font-weight:" + ("normal")  + ";position:" + ("relative")  + ";text-shadow:" + ("0"+ " " +"-1px"+ " " +"rgba(0,0,0,0.6)")  + ";font-size:" + ("28px")  + ";line-height:" + ("40px")  + ";background:" + ("#355681")  + ";background:" + ("rgba(53,86,129,0.8)")  + ";border:") + (("1px"+ " " +"solid"+ " " +"#fff")  + ";padding:" + ("5px"+ " " +"15px")  + ";color:" + ("white")  + ";border-radius:" + ("0"+ " " +"10px"+ " " +"0"+ " " +"10px")  + ";box-shadow:" + ("inset"+ " " +"0"+ " " +"0"+ " " +"5px"+ " " +"rgba(53,86,129,0.5)")  + ";font-family:" + ("\"Muli\""+ ","+ " " +"sans-serif")  + ";}.Gkn5jh1H{padding:" + ("15px")  + ";}"));
        }
        public java.lang.String TopLabel(){
          return "Gkn5jh1F";
        }
        public java.lang.String TopVerticalPanel(){
          return "Gkn5jh1G";
        }
        public java.lang.String htmlPanel(){
          return "Gkn5jh1H";
        }
        public java.lang.String important(){
          return "Gkn5jh1I";
        }
      }
      ;
    }
    return style;
  }
  private static ru.vrn.rusap.client.frontend.MainPanel_MainPanelUiBinderImpl_GenCss_style style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      style(), 
    };
  }
  public native ResourcePrototype getResource(String name) /*-{
    switch (name) {
      case 'style': return this.@ru.vrn.rusap.client.frontend.MainPanel_MainPanelUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
