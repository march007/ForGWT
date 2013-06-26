package ru.vrn.rusap.client.frontend;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class LogonForm_LogonFormUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, ru.vrn.rusap.client.frontend.LogonForm>, ru.vrn.rusap.client.frontend.LogonForm.LogonFormUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final ru.vrn.rusap.client.frontend.LogonForm owner) {

    ru.vrn.rusap.client.frontend.LogonForm_LogonFormUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (ru.vrn.rusap.client.frontend.LogonForm_LogonFormUiBinderImpl_GenBundle) GWT.create(ru.vrn.rusap.client.frontend.LogonForm_LogonFormUiBinderImpl_GenBundle.class);
    ru.vrn.rusap.client.frontend.LogonForm_LogonFormUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.HTML f_HTML4 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel6 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.TextBox textBox = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel8 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel5 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label11 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel10 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.PasswordTextBox passwordTextBox = (com.google.gwt.user.client.ui.PasswordTextBox) GWT.create(com.google.gwt.user.client.ui.PasswordTextBox.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel12 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel9 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Button button = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel13 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel3 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel2 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel("<span id='" + domId0 + "'></span>");

    f_HTML4.setHTML("<h1>Авторизация</h1>");
    f_HTML4.setWordWrap(true);
    f_VerticalPanel3.add(f_HTML4);
    f_Label7.setStyleName("" + style.label() + "");
    f_Label7.setText("Логин");
    f_Label7.setHeight("40px");
    f_Label7.setWidth("114px");
    f_VerticalPanel6.add(f_Label7);
    f_VerticalPanel6.setCellHorizontalAlignment(f_Label7, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_VerticalPanel6.setCellVerticalAlignment(f_Label7, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_VerticalPanel6.setHeight("51px");
    f_VerticalPanel6.setWidth("116px");
    f_HorizontalPanel5.add(f_VerticalPanel6);
    textBox.setStyleName("" + style.input() + "");
    textBox.setText("Логин");
    textBox.setWidth("209px");
    f_VerticalPanel8.add(textBox);
    f_VerticalPanel8.setCellHorizontalAlignment(textBox, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_VerticalPanel8.setCellVerticalAlignment(textBox, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_VerticalPanel8.setHeight("52px");
    f_VerticalPanel8.setWidth("231px");
    f_HorizontalPanel5.add(f_VerticalPanel8);
    f_HorizontalPanel5.setHeight("57px");
    f_HorizontalPanel5.setWidth("314px");
    f_VerticalPanel3.add(f_HorizontalPanel5);
    f_Label11.setStyleName("" + style.label() + "");
    f_Label11.setText("Пароль");
    f_Label11.setHeight("40px");
    f_Label11.setWidth("117px");
    f_VerticalPanel10.add(f_Label11);
    f_VerticalPanel10.setCellHorizontalAlignment(f_Label11, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_VerticalPanel10.setCellVerticalAlignment(f_Label11, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_VerticalPanel10.setHeight("51px");
    f_VerticalPanel10.setWidth("116px");
    f_HorizontalPanel9.add(f_VerticalPanel10);
    passwordTextBox.setStyleName("" + style.input() + "");
    passwordTextBox.setText("Пароль");
    passwordTextBox.setWidth("209px");
    f_VerticalPanel12.add(passwordTextBox);
    f_VerticalPanel12.setCellHorizontalAlignment(passwordTextBox, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_VerticalPanel12.setCellVerticalAlignment(passwordTextBox, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_VerticalPanel12.setHeight("52px");
    f_VerticalPanel12.setWidth("231px");
    f_HorizontalPanel9.add(f_VerticalPanel12);
    f_HorizontalPanel9.setHeight("57px");
    f_HorizontalPanel9.setWidth("297px");
    f_VerticalPanel3.add(f_HorizontalPanel9);
    button.setStyleName("" + style.button() + "");
    button.setText("Вход");
    button.setHeight("39px");
    button.setWidth("381px");
    f_VerticalPanel13.add(button);
    f_VerticalPanel13.setCellHorizontalAlignment(button, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_VerticalPanel13.setCellVerticalAlignment(button, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_VerticalPanel13.setHeight("43px");
    f_VerticalPanel13.setWidth("231px");
    f_VerticalPanel3.add(f_VerticalPanel13);
    f_VerticalPanel3.setStyleName("" + style.form3() + "");
    f_VerticalPanel3.setHeight("161px");
    f_VerticalPanel3.setWidth("404px");
    f_VerticalPanel2.add(f_VerticalPanel3);
    f_VerticalPanel2.setHeight("263px");
    f_VerticalPanel2.setWidth("572px");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_VerticalPanel2, domId0Element);


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onButtonClick(event);
      }
    };
    button.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onTextBoxClick(event);
      }
    };
    textBox.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onPasswordTextBoxClick(event);
      }
    };
    passwordTextBox.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    owner.button = button;
    owner.passwordTextBox = passwordTextBox;
    owner.textBox = textBox;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
