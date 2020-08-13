package requests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Get_1 {
	
	public static Properties prop;
	public static FileInputStream ip;
	
	@BeforeSuite
	public void setUp() {
		prop = new Properties();

		try {
			ip = new FileInputStream(
					"E:\\java eclipse selenium + java\\RestAssureProject\\src\\test\\java\\configProperty\\Config.Property");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_01()
	{
		Response response=get(prop.getProperty("url"));
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void test_02()
	{
		given()
			.get(prop.getProperty("url"))
		.then()
			.statusCode(Integer.parseInt(prop.getProperty("code")))
			.body("data.id[0]", equalTo(Integer.parseInt(prop.getProperty("id"))));
			
	}

}
