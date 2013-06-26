package ru.vrn.rusap.client.frontend;

import ru.vrn.rusap.client.GreetingService;
import ru.vrn.rusap.client.GreetingServiceAsync;
import ru.vrn.rusap.client.frontend.dialog.DlgBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class TabInformer extends Composite implements HasText {

	private static TabInformerUiBinder uiBinder = GWT
			.create(TabInformerUiBinder.class);
	

	@UiField Button button;

	interface TabInformerUiBinder extends UiBinder<Widget, TabInformer> {
	}

	public TabInformer() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public TabInformer(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {	
	}
	
}
