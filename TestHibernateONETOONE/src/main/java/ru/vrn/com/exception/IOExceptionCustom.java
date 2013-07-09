package ru.vrn.com.exception;

import java.io.IOException;

public class IOExceptionCustom extends IOException {

	private int i = 0;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	

}
