package ru.vrn.rusap.client.frontend.dialog;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DlgBox extends DialogBox {
	VerticalPanel dialogVPanel;
	
	public DlgBox(String str) {
		
		dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(setupTextDlgBox(str));
		this.setAnimationEnabled(true);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		this.setWidget(dialogVPanel);
	}
	
	public DlgBox() {
		
		dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
//		dialogVPanel.add(setupTextDlgBox(str));
		this.setAnimationEnabled(true);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		this.setWidget(dialogVPanel);
	}
	
	public void setText(String str){
		dialogVPanel.add(setupTextDlgBox(str));
	}
	
	private HTML setupTextDlgBox(String str){
		HTML html = new HTML("<b>"+ str + "</b>");
		return html;
	}
	public void setWidjet(Button button) {
		dialogVPanel.add(button);
	}
	
	
}
