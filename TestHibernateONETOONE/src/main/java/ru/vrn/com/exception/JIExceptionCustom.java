package ru.vrn.com.exception;

import org.jinterop.dcom.common.JIException;

public class JIExceptionCustom extends JIException {

	public JIExceptionCustom(int errorCode) {
		super(errorCode);
	}

	private int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}


}
