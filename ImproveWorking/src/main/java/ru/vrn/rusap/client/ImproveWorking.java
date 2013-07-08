package ru.vrn.rusap.client;

import ru.vrn.rusap.client.frontend.LogonForm;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ImproveWorking implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	
	public void onModuleLoad() {
		
		
		RootPanel.get().addStyleName("rootPanel");
		
		
//		RootPanel.get("container").add(new LogonForm());
		
		RootPanel.get("main").add(new LogonForm());
		
	/*	final Button sendButton = new Button("Вход");
		sendButton.addStyleName("gwtSendButton");
		sendButton.setStyleName("gwtSendButton");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();
		
		//*****************************************************	
		
		
		HorizontalPanel panel1 = new HorizontalPanel();
		panel1.setPixelSize(258, 34);
		HorizontalPanel panel2 = new HorizontalPanel();
		panel2.setPixelSize(258, 34);
		
		
		
		VerticalPanel verticalPanel1 = new VerticalPanel();
		verticalPanel1.setPixelSize(70, 30);
		VerticalPanel verticalPanel1_1 = new VerticalPanel();
		verticalPanel1_1.setPixelSize(145, 30);
		
		VerticalPanel verticalPanel2 = new VerticalPanel();
		verticalPanel2.setPixelSize(70, 30);
		VerticalPanel verticalPanel2_1 = new VerticalPanel();
		verticalPanel2_1.setPixelSize(145, 30);
		
		panel1.add(verticalPanel1);
		panel1.add(verticalPanel1_1);
		
		panel2.add(verticalPanel2);
		panel2.add(verticalPanel2_1);
		
		final Label loginLabel = new Label("Логин   ");
		loginLabel.addStyleName("gwtlabel");
		loginLabel.setStyleName("gwtlabel");
		loginLabel.setPixelSize(66, 18);
		verticalPanel1.add(loginLabel);
		
//		RootPanel.get("label_test_login").add(loginLabel);
		
		final TextBox textBox = new TextBox();
		textBox.setVisibleLength(50);
		textBox.setVisible(true);
		textBox.setPixelSize(135, 30);
		textBox.setFocus(true);
		verticalPanel1_1.add(textBox);
		
		final Label passwordLabel = new Label("Пароль    ");
		passwordLabel.addStyleName("gwtlabel");
		passwordLabel.setStyleName("gwtlabel");
		passwordLabel.setPixelSize(66, 18);
		verticalPanel2.add(passwordLabel);
//		RootPanel.get("label_test_login").add(passwordLabel);
		
		final PasswordTextBox passwordTextBox  = new PasswordTextBox();
//		passwordTextBox.setVisibleLength(70);
		passwordTextBox.setVisible(true);
		passwordTextBox.setPixelSize(135, 30);
		verticalPanel2_1.add(passwordTextBox);
		RootPanel.get("label_test_login").add(panel1);
		RootPanel.get("label_test_login").add(panel2);
		sendButton.addStyleName("sendButton");
		
			final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});		
		
		
		RootPanel.get("screen").add(sendButton);
		textBox.setFocus(true);
		
		sendButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("main").add(new MainPanel());
			}
		});
		*/
		
//		66.18
//		135.15
		
//		HorizontalPanel panel = new HorizontalPanel();
		
		
		
//		panel.add(loginLabel);
//		panel.add(textBox);
		
		
		
		//*****************************************************
		
//		HorizontalPanel panelForPassword = new HorizontalPanel();
		
		
		
		
//		panelForPassword.add(passwordLabel);
//		panelForPassword.add(passwordTextBox);
//		
//		RootPanel.get("label_test_password").add(panelForPassword);
		
//		verticalPanel.add(loginLabel);
//		verticalPanel.add(passwordLabel);
//		
//		verticalPanel1.add(textBox);
//		verticalPanel1.add(passwordTextBox);
		
		
		
//		RootPanel.get("nameFieldContainer").add(panel);
	/*	final TextBox textBox = new TextBox();
		
		textBox.setVisibleLength(50);
		textBox.setVisible(true);
		RootPanel.get("divLogin").add(textBox);
		
		final DialogBox dialogBox555 = new DialogBox();
		dialogBox555.setText("Remote Procedure Call");
		dialogBox555.setAnimationEnabled(true);	
		dialogBox555.setVisible(true);
		
		
		final Button sendButton1 = new Button("alalalala");
		sendButton1.setSize("50", "20");
		sendButton1.setVisible(true);
		RootPanel.get("support-note").add(sendButton1);
		
		RootPanel.get("divLogin").add(sendButton1);
		
		final Button sendButton123 = new Button("Send");
		sendButton1.setVisible(true);
		RootPanel.get().add(sendButton123);
		
		sendButton123.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				dialogBox555.center();
				dialogBox555.show();
			}
		});*/
		// We can add style names to widgets
		

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		
		
		
//		RootPanel.get("nameFieldContainer").add(nameField);
//		RootPanel.get("support-note").add(sendButton);
//		RootPanel.get("errorLabelContainer").add(errorLabel);
		
	
		

		// Focus the cursor on the name field when the app loads
		/*nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

		
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);*/
	}
}