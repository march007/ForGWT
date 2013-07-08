package ru.vrn.rusap.client.frontend;

import java.util.List;

import ru.vrn.rusap.client.GreetingService;
import ru.vrn.rusap.client.GreetingServiceAsync;
import ru.vrn.rusap.shared.FieldVerifier;
import ru.vrn.rusap.shared.model.ListOfMonitoring;
import ru.vrn.rusap.shared.model.UsersAD;
import ru.vrn.rusap.shared.transfer.ListOfMonitoringTransfer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
/*
	Предназначен для предоставления и изменения информации по IT ресурсам сети.
	
	@autor marchenko
	
	@create 10.06.2013

*/
public class MainPanel extends Composite implements HasText {

	private static MainPanelUiBinder uiBinder = GWT
			.create(MainPanelUiBinder.class);

	@UiField
	ListBox listBoxUsers;
	@UiField
	TextBox textBoxForUser;
	@UiField
	Button addNetworksRules;
	@UiField
	ListBox listBox;
	@UiField
	TabLayoutPanel tabLayoutPanel;
	@UiField
	ListBox listBoxVersions;
	@UiField
	PasswordTextBox passwordTextBox;
	@UiField
	PasswordTextBox passwordTextBox_1;
	@UiField
	TextBox textBoxServer;
	@UiField
	TextBox textBoxHostUser;
	@UiField
	TextBox textBoxRef;
	@UiField
	TextBox textBoxUserForConnect;
	@UiField
	TextBox textBoxDomain;
	@UiField
	Button button_1;
	@UiField
	ListBox listBox_2;
	@UiField
	Button button_2;
	@UiField
	Button buttonSave;
	@UiField
	Button button_4;
	@UiField
	Label labelServer;
	@UiField
	Label labelRef;
	@UiField
	Label labelVersions;
	@UiField
	Label labelDomain;
	@UiField
	Label labelUser1C;
	@UiField
	Label labelPass1;
	@UiField
	Label labelUserForTextBox;
	@UiField
	Label labelPass2;
	@UiField
	Button button;
	@UiField
	TextArea textArea;

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	final DialogBox dialogBox = new DialogBox();
	final Button closeButton = new Button("Close");
	final Label textToServerLabel = new Label();
	final HTML serverResponseLabel = new HTML();
	VerticalPanel dialogVPanel = new VerticalPanel();
	private boolean bool = false;
	ListOfMonitoring existBase;
	List<UsersAD> list;
	List<String> listDbs;

	ListOfMonitoringTransfer transfer;

	interface MainPanelUiBinder extends UiBinder<Widget, MainPanel> {
	}

	public MainPanel() {
		initWidget(uiBinder.createAndBindUi(this));

		textArea.setReadOnly(true);

		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);

		closeButton.getElement().setId("closeButton");
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Ответ сервера:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		listBox.setMultipleSelect(false);
		listBoxUsers.setMultipleSelect(false);

		button_1.setEnabled(true);
		button_2.setEnabled(false);
		button_4.setEnabled(false);

		closeButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				dialogBox.hide();
			}
		});

		// Получение пользователей Active Directory.		
		greetingService.getListUsersAD(new AsyncCallback<List<UsersAD>>() {

			@Override
			public void onSuccess(List<UsersAD> result) {

				// rootLogger.log(Level.SEVERE,
				// "getListUsersAD is Successfull ");
				list = result;
				for (UsersAD usersAD : result) {
					String str = usersAD.getName() + "  :  "
							+ usersAD.getDescription();
					listBox.addItem(str);
					listBoxUsers.addItem(usersAD.getName());
				}
			}

			@Override
			public void onFailure(Throwable caught) {

				dialogBox.setText("Remote Procedure Call");
				serverResponseLabel.removeStyleName("serverResponseLabelError");
				serverResponseLabel
						.setHTML("Произошла ошибка, обновите страницу!");
				dialogBox.center();
				closeButton.setFocus(true);
			}
		});
		listBox.setSelectedIndex(0);
		listBoxUsers.setSelectedIndex(0);

		textBoxServer.setVisible(false);
		textBoxHostUser.setVisible(false);
		textBoxRef.setVisible(false);
		textBoxUserForConnect.setVisible(false);
		textBoxDomain.setVisible(false);
		passwordTextBox.setVisible(false);
		passwordTextBox_1.setVisible(false);
		listBoxVersions.setVisible(false);
		buttonSave.setVisible(false);

		labelDomain.setVisible(false);
		labelPass1.setVisible(false);
		labelPass2.setVisible(false);
		labelRef.setVisible(false);
		labelServer.setVisible(false);
		labelUser1C.setVisible(false);
		labelUserForTextBox.setVisible(false);
		labelVersions.setVisible(false);
	}

	public MainPanel(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

	
	//Получение баз данных 1С.
	@UiHandler("button_1")
	void onButton_1Click(ClickEvent event) {

		listBoxVersions.addItem("V80Driver");
		listBoxVersions.addItem("V81Driver");
		listBoxVersions.addItem("V82Driver");

		greetingService.getDbs(new AsyncCallback<List<String>>() {

			@Override
			public void onSuccess(List<String> result) {
				listDbs = result;
				for (String listOfMonitoring : result) {
					listBox_2.addItem(listOfMonitoring);

				}
			}

			@Override
			public void onFailure(Throwable caught) {

				dialogBox.setText("Remote Procedure Call");
				serverResponseLabel.removeStyleName("serverResponseLabelError");
				serverResponseLabel
						.setHTML("Неудачная попытка свзааться с сервером!");
				dialogBox.center();
				closeButton.setFocus(true);
			}
		});
		button_1.setEnabled(false);
		button_2.setEnabled(true);
		button_4.setEnabled(true);
	}

	
	@UiHandler("button_2")
	void onButton_2Click(ClickEvent event) {

		removeStyleAtLabels();

		bool = false;
		textBoxServer.setVisible(true);
		textBoxHostUser.setVisible(true);
		textBoxRef.setVisible(true);
		textBoxUserForConnect.setVisible(true);
		textBoxDomain.setVisible(true);
		passwordTextBox.setVisible(true);
		passwordTextBox_1.setVisible(true);
		listBoxVersions.setVisible(true);
		buttonSave.setVisible(true);

		labelDomain.setVisible(true);
		labelPass1.setVisible(true);
		labelPass2.setVisible(true);
		labelRef.setVisible(true);
		labelServer.setVisible(true);
		labelUser1C.setVisible(true);
		labelUserForTextBox.setVisible(true);
		labelVersions.setVisible(true);

		textBoxServer.setText("");
		textBoxHostUser.setText("");
		textBoxRef.setText("");
		textBoxUserForConnect.setText("");
		textBoxDomain.setText("");
		passwordTextBox.setText("");
		passwordTextBox_1.setText("");
		listBoxVersions.setSelectedIndex(0);

	}

	
	@UiHandler("buttonSave")
	void onButtonSaveClick(ClickEvent event) {

		removeStyleAtLabels();

		if (bool) {

			if (isValidAllFields()) {
				transfer.setDomain(textBoxDomain.getText().trim());
				transfer.setSrv(textBoxServer.getText().trim());
				transfer.setHost(textBoxServer.getText().split(":")[0]);
				transfer.setHostPassword(passwordTextBox.getText());
				transfer.setVersion(listBoxVersions.getItemText(listBoxVersions
						.getSelectedIndex()));
				transfer.setProgram1cPassword(passwordTextBox_1.getText()
						.trim());
				transfer.setUser(textBoxUserForConnect.getText().trim());
				transfer.setRef(textBoxRef.getText().trim());
				transfer.setHostUser(textBoxHostUser.getText().trim());

				greetingService.changeExistBase(transfer,
						new AsyncCallback<Boolean>() {

							@Override
							public void onSuccess(Boolean result) {
								dialogBox.setText("Remote Procedure Call");
								// serverResponseLabel
								// .removeStyleName("serverResponseLabelError");
								serverResponseLabel
										.setHTML("Изменение прошло удачно!");
								dialogBox.center();
								closeButton.setFocus(true);
							}

							@Override
							public void onFailure(Throwable caught) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel
										.setHTML("Неудачная попытка свзааться с сервером!");
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			} else {
				dialogBox.setText("Remote Procedure Call");
				serverResponseLabel.removeStyleName("serverResponseLabelError");
				serverResponseLabel.setHTML("Поле пустое!!!");
				dialogBox.center();
				closeButton.setFocus(true);
			}

		} else {

			if (isValidAllFields()) {

				dialogBox.setText("Remote Procedure Call");
				serverResponseLabel.removeStyleName("serverResponseLabelError");
				serverResponseLabel.setHTML("everything is allrigths");
				dialogBox.center();
				closeButton.setFocus(true);

				ListOfMonitoring baseForMonitoring = new ListOfMonitoring();

				baseForMonitoring.setDomain(textBoxDomain.getText().trim());
				baseForMonitoring.setSrv(textBoxServer.getText().trim());
				baseForMonitoring
						.setHost(textBoxServer.getText().split(":")[0]);
				baseForMonitoring.setHostPassword(passwordTextBox.getText());
				baseForMonitoring.setVersion(listBoxVersions
						.getItemText(listBoxVersions.getSelectedIndex()));
				baseForMonitoring.setProgram1cPassword(passwordTextBox_1
						.getText().trim());
				baseForMonitoring.setUser(textBoxUserForConnect.getText()
						.trim());
				baseForMonitoring.setRef(textBoxRef.getText().trim());
				baseForMonitoring.setHostUser(textBoxHostUser.getText().trim());

				greetingService.addBase(baseForMonitoring,
						new AsyncCallback<Boolean>() {

							@Override
							public void onSuccess(Boolean result) {
								dialogBox.setText("Remote Procedure Call");
								// serverResponseLabel
								// .removeStyleName("serverResponseLabelError");
								serverResponseLabel
										.setHTML("Добавление прошло удачно!!");
								dialogBox.center();
								closeButton.setFocus(true);
							}

							@Override
							public void onFailure(Throwable caught) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel
										.setHTML("Неудачная попытка свзааться с сервером!");
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			} else {
				dialogBox.setText("Remote Procedure Call");
				serverResponseLabel.removeStyleName("serverResponseLabelError");
				serverResponseLabel.setHTML("Поле пустое!");
				dialogBox.center();
				closeButton.setFocus(true);
			}
		}
	}

	
	/*
	    Предназнчена для удаления стиля ошибок. 
	    
	     Стиль ошибок: 
	     
	     <code>
	     .serverResponseLabelError {
			  color: red;
		 }
		</code>
	*/
	private void removeStyleAtLabels() {
		labelDomain.removeStyleName("serverResponseLabelError");
		labelPass1.removeStyleName("serverResponseLabelError");
		labelPass2.removeStyleName("serverResponseLabelError");
		labelRef.removeStyleName("serverResponseLabelError");
		labelServer.removeStyleName("serverResponseLabelError");
		labelUser1C.removeStyleName("serverResponseLabelError");
		labelUserForTextBox.removeStyleName("serverResponseLabelError");
		labelVersions.removeStyleName("serverResponseLabelError");
	}

	/*
		Проверка полей ввода на заполненность.
		
		@see  ru.vrn.rusap.shared.FieldVerifier
	
	*/
	private boolean isValidAllFields() {

		boolean boo = true;

		if (!FieldVerifier.isValidField(textBoxServer.getText())) {
			labelServer.addStyleName("serverResponseLabelError");
			boo = false;
		}

		if (!FieldVerifier.isValidField(textBoxRef.getText())) {
			labelRef.addStyleName("serverResponseLabelError");
			boo = false;
		}

		if (!FieldVerifier.isValidField(textBoxDomain.getText())) {
			labelDomain.addStyleName("serverResponseLabelError");
			boo = false;
		}

		if (!FieldVerifier.isValidField(textBoxHostUser.getText())) {
			labelUser1C.addStyleName("serverResponseLabelError");
			boo = false;
		}

		if (!FieldVerifier.isValidField(textBoxUserForConnect.getText())) {
			labelUserForTextBox.addStyleName("serverResponseLabelError");
			boo = false;
		}

		if (!FieldVerifier.isValidField(passwordTextBox.getText())) {
			labelPass1.addStyleName("serverResponseLabelError");
			boo = false;
		}

		if (!FieldVerifier.isValidField(passwordTextBox_1.getText())) {
			labelPass2.addStyleName("serverResponseLabelError");
			boo = false;
		}

		if (listBoxVersions.getItemText(listBoxVersions.getSelectedIndex())
				.equals("")) {
			boo = false;
		}

		if (boo) {
			return true;
		}

		return false;
	}

	@UiHandler("button_4")
	void onButton_4Click(ClickEvent event) {

		textBoxServer.setVisible(true);
		textBoxHostUser.setVisible(true);
		textBoxRef.setVisible(true);
		textBoxUserForConnect.setVisible(true);
		textBoxDomain.setVisible(true);
		passwordTextBox.setVisible(true);
		passwordTextBox_1.setVisible(true);
		listBoxVersions.setVisible(true);
		buttonSave.setVisible(true);

		labelDomain.setVisible(true);
		labelPass1.setVisible(true);
		labelPass2.setVisible(true);
		labelRef.setVisible(true);
		labelServer.setVisible(true);
		labelUser1C.setVisible(true);
		labelUserForTextBox.setVisible(true);
		labelVersions.setVisible(true);

		bool = true;
		greetingService.getDbByString(
				listDbs.get(listBox_2.getSelectedIndex()),
				new AsyncCallback<ListOfMonitoringTransfer>() {

					@Override
					public void onSuccess(ListOfMonitoringTransfer result) {
						// existBase = result;
						transfer = result;
						textBoxServer.setText(result.getSrv());
						textBoxRef.setText(result.getRef());
						textBoxDomain.setText(result.getDomain());
						textBoxHostUser.setText(result.getHostUser());
						textBoxUserForConnect.setText(result.getUser());
					}

					@Override
					public void onFailure(Throwable caught) {
						dialogBox.setText("Remote Procedure Call");
						serverResponseLabel
								.removeStyleName("serverResponseLabelError");
						serverResponseLabel
								.setHTML("Неудачная попытка свзааться с сервером!");
						dialogBox.center();
						closeButton.setFocus(true);
					}
				});
	}

	/*
		Предназначена для добавления новых сетевых правил. 
	
	
	
	*/
	@UiHandler("addNetworksRules")
	void onAddNetworksRulesClick(ClickEvent event) {
		String rule = textBoxForUser.getText();

		if (FieldVerifier.isValidField(rule)) {
			greetingService.addNetworkRule(rule,
					list.get(listBoxUsers.getSelectedIndex()),
					new AsyncCallback<Boolean>() {

						@Override
						public void onSuccess(Boolean result) {
							dialogBox.setText("Remote Procedure Call");
							serverResponseLabel
									.removeStyleName("serverResponseLabelError");
							serverResponseLabel
									.setHTML("Правило добавлено успешно!");
							dialogBox.center();
							closeButton.setFocus(true);
						}

						@Override
						public void onFailure(Throwable caught) {
							dialogBox.setText("Remote Procedure Call");
							serverResponseLabel
									.removeStyleName("serverResponseLabelError");
							serverResponseLabel
									.setHTML("Неудачная попытка свзааться с сервером!");
							dialogBox.center();
							closeButton.setFocus(true);
						}
					});
		} else {
			dialogBox.setText("Remote Procedure Call");
			serverResponseLabel.removeStyleName("serverResponseLabelError");
			serverResponseLabel.setHTML("Пустое поле!");
			dialogBox.center();
			closeButton.setFocus(true);
		}

	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		greetingService.getInformationByUser(
				list.get(listBox.getSelectedIndex()),
				new AsyncCallback<String>() {
					@Override
					public void onFailure(Throwable caught) {
						dialogBox.setText("Remote Procedure Call");
						serverResponseLabel
								.removeStyleName("serverResponseLabelError");
						serverResponseLabel
								.setHTML("Неудачная попытка свзааться с сервером!");
						dialogBox.center();
						closeButton.setFocus(true);
					}

					@Override
					public void onSuccess(String result) {
						String[] masString = result.split(";");
						StringBuilder info = new StringBuilder();

						for (String string : masString) {
							info.append(string + "\n");
						}

						textArea.setText(info.toString());
					}
				});
	}
}
