package config;

public class Config {

	private static final String KEY_BROWSER = "browser";
	private static final String KEY_BASE_URL = "baseUrl";
	private static final String KEY_GRID_URL = "gridUrl";
	private static final String KEY_EXECUTION_MODE = "executionMode";
	private static final String KEY_SOURCE = "source";
	private static final String KEY_TIMEOUT = "timeout";
	private static final String KEY_HEADLESS = "headless";

	private static final String DEFAULT_BROWSER = "chrome";
	private static final String DEFAULT_BASE_URL = "https://www.alaskatrips.com";
	private static final String DEFAULT_GRID_URL = "http://localhost:4444/wd/hub";
	private static final String DEFAULT_EXECUTION_MODE = "local";
	private static final String DEFAULT_SOURCE = "excel";
	private static final int DEFAULT_TIMEOUT = 10;
	private static final boolean DEFAULT_HEADLESS = false;

	private Config() {

	}

	public static String getBrowser() {
		return System.getProperty(KEY_BROWSER, DEFAULT_BROWSER).toLowerCase();
	}

	public static String getBaseUrl() {
		return System.getProperty(KEY_BASE_URL, DEFAULT_BASE_URL);
	}

	public static String getGridUrl() {
		return System.getProperty(KEY_GRID_URL, DEFAULT_GRID_URL);
	}

	public static String getExecutionMode() {
		return System.getProperty(KEY_EXECUTION_MODE, DEFAULT_EXECUTION_MODE).toLowerCase();
	}

	public static String getSource() {
		return System.getProperty(KEY_SOURCE, DEFAULT_SOURCE).toLowerCase();
	}

	public static int getTimeout() {
		try {
			return Integer.parseInt(System.getProperty(KEY_TIMEOUT, String.valueOf(DEFAULT_TIMEOUT)));
		} catch (NumberFormatException e) {
			return DEFAULT_TIMEOUT;
		}
	}

	public static boolean isHeadless() {
		return Boolean.parseBoolean(System.getProperty(KEY_HEADLESS, String.valueOf(DEFAULT_HEADLESS)));
	}

}
