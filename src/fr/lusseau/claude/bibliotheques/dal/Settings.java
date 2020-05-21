package fr.lusseau.claude.bibliotheques.dal;

import java.util.Properties;

/**
 * @author Claude Lusseau
 *
 */
public class Settings {
	private static Properties properties;

	static {
		properties = new Properties();
		try {
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getPropery(String key) {
		return properties.getProperty(key);
	}

}
