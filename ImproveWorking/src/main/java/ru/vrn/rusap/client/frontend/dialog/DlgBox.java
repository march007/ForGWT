package ru.vrn.rusap.client.frontend.dialog;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * Предназначен для Создания диалоговых окон.
 * 
 * @autor marchenko
 * 
 * @create 11.06.2013
 * 
 */
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
		// dialogVPanel.add(setupTextDlgBox(str));
		this.setAnimationEnabled(true);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		this.setWidget(dialogVPanel);
	}

	public void setText(String str) {
		dialogVPanel.add(setupTextDlgBox(str));
	}

	/**
	 * Преднзначена для добавления текста на кнопку закрытия диалогового окна.
	 * 
	 * @param str
	 *            - строка, для отображения на кнопке закрытия диалогового окна.
	 * @return HTML - HTML разметка для отображения на строке кнопки закрытия
	 *         дилогового окна.
	 * 
	 */
	private HTML setupTextDlgBox(String str) {
		HTML html = new HTML("<b>" + str + "</b>");
		return html;
	}

	/**
	 * Предназначена для устанвоки кнопки закрытия далогового окна.
	 * 
	 * @param button
	 *            - кнопка закрытия диалогового окна.
	 * 
	 */
	public void setWidjet(Button button) {
		dialogVPanel.add(button);
	}

}
