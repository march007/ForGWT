package ru.vrn.com;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/**
 * 
 * Предназначен для логгирования информации
 * 
 * @author marchenko
 * 
 * @create 13.06.2013
 * 
*/
public class LogIt {
	private static final String logForLinux = "/home/base/log.properties";
	private static final String logForWindows = "D:/log111111.properties";
	private static String PATH;
	private static Logger logger1 = Logger.getLogger(LogIt.class.getName());

	static {
		if (isUnix()) {
			PATH = logForLinux;
		} else if (isWindows()) {
			PATH = logForWindows;
		}
		try {
			FileHandler handler = new FileHandler(PATH, true);
			handler.setFormatter(new SimpleFormatter());
			logger1 = Logger.getLogger(LogIt.class.getName());
			logger1.addHandler(handler);

		} catch (IOException ioe) {
			logger1.log(Level.SEVERE,
					"Не удалось создать файл лога из-за ошибки ввода-вывода.",
					ioe);
		} catch (SecurityException e) {
			logger1
					.log(
							Level.SEVERE,
							"Не удалось создать файл лога из-за политики безопасности.",
							e);
		}
	}

	public static void log(String className, Level lvl, String msg, Exception e) {
		Logger.getLogger(className).log(lvl, msg, e);
	}

	public static void log(Level lvl, String msg, Exception e) {
		log(LogIt.class.getName(), lvl, msg, e);
	}

	public static void log(String msg, Exception e) {
		log(Level.SEVERE, msg, e);
	}

	public static void log(Exception e) {
		log("Ошибка", e);
	}

	public static void log(String className, Level lvl, String msg) {
		Logger.getLogger(className).log(lvl, msg);
	}

	public static void log(Level lvl, String msg) {
		log(LogIt.class.getName(), lvl, msg);
	}

	public static void log(String msg) {
		log(Level.INFO, msg);
	}

	public static void log(String msg, String i) {
		logger1.log(Level.INFO, msg + " ----------------------------" + i
				+ "  ");
	}

	public static boolean isWindows() {
		String os = System.getProperty("os.name").toLowerCase();
		// windows
		return (os.indexOf("win") >= 0);
	}

	public static boolean isUnix() {
		String os = System.getProperty("os.name").toLowerCase();
		// linux or unix
		return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);
	}
}
