package ru.vrn.rusap.client.frontend;

import ru.vrn.rusap.client.GreetingService;
import ru.vrn.rusap.client.GreetingServiceAsync;
import ru.vrn.rusap.client.frontend.dialog.DlgBox;
import ru.vrn.rusap.shared.FieldVerifier;
import ru.vrn.rusap.shared.model.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LogonForm extends Composite implements HasText {

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	private static LogonFormUiBinder uiBinder = GWT
			.create(LogonFormUiBinder.class);
	@UiField Button button;
	@UiField TextBox textBox;
	@UiField PasswordTextBox passwordTextBox;

	interface LogonFormUiBinder extends UiBinder<Widget, LogonForm> {
	}

	public LogonForm() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public LogonForm(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		if (FieldVerifier.isValidName(textBox.getText()) && (FieldVerifier.isValidName(passwordTextBox.getText()))) {
			
			User person = new User();
			person.setLogin(textBox.getText());
			person.setPassword(passwordTextBox.getText());
			
			greetingService.checkUser(person, new AsyncCallback<Boolean>() {
				
				@Override
				public void onSuccess(Boolean result) {
					
					if (result.booleanValue()){
						RootPanel.get("main").clear();
						RootPanel.get("main").add(new MainPanel());
					}else{
						Button button = new Button("Закрыть");
						
						final DlgBox box = new DlgBox();
						box.setText("Данные введены некорректно. Повторите ввод!!!");
						box.setWidjet(button);
						box.center();
						box.show();
						
						button.addClickHandler(new ClickHandler() {
							
							@Override
							public void onClick(ClickEvent event) {
								box.hide();
							}
						});
					}
//					Button button = new Button("Закрыть");
//					
//					final DlgBox box = new DlgBox();
//					box.setText("Все отлично");
//					box.setWidjet(button);
//					box.center();
//					box.show();
//					
//					button.addClickHandler(new ClickHandler() {
//						
//						@Override
//						public void onClick(ClickEvent event) {
//							box.hide();
//						}
//					});					
				}
				
				@Override
				public void onFailure(Throwable caught) {
					Button button = new Button("Закрыть");
					
					final DlgBox box = new DlgBox();
					box.setText("Данные введены некорректно. Повторите ввод!");
					box.setWidjet(button);
					box.center();
					box.show();
					
					button.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							box.hide();
						}
					});
				}
			});
			
			
		}else{
//			сообщени об ошибке ввода
			
			Button button = new Button("Закрыть");
			
			final DlgBox box = new DlgBox();
			box.setText("Данные введены некорректно. Повторите ввод!");
			box.setWidjet(button);
			box.center();
			box.show();
			
			button.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					box.hide();
				}
			});
			
		}	
		
	}
	
	@UiHandler("textBox")
	void onTextBoxClick(ClickEvent event) {
	}
	@UiHandler("passwordTextBox")
	void onPasswordTextBoxClick(ClickEvent event) {
	}
}
