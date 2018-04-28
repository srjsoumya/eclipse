package java_example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RetriveProperties {
	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
			FileInputStream io = new FileInputStream("src/java_example/config.properties");
			prop.load(io);
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String pass = prop.getProperty("password");
			System.out.println(url);
			System.out.println(user);
			System.out.println(pass);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
