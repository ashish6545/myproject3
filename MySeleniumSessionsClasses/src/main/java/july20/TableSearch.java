package july20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import june20the.TableSerachUtil;

public class TableSearch {

	// creating reference.
	public static Properties prop;
	public static FileInputStream ip;

	// reading property file.
	@BeforeMethod
	public void setUp() {
		prop = new Properties();

		try {
			ip = new FileInputStream(
					"C:\\Users\\Ashish\\Git\\myproject3\\MySeleniumSessionsClasses\\src\\main\\java\\june20thee\\TableConfig.Property");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// fetching data from excel sheet.
	@DataProvider
	public Object[][] getLogindata() throws Exception {
		Object data[][] = TableSerachUtil.getTestData("Test");
		return data;
	}

	// search method.
	@Test(dataProvider = "getLogindata")
	public void loginTest(String a, String b, String c) {
		String value = prop.getProperty("data");
		Double j = Double.parseDouble(b);
		Double data = Double.parseDouble(value);
		if (j.equals(data)) {
			System.out.println(c);
		}

	}

}
