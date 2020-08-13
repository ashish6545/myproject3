package requests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Post_1 {
	
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
	public void post_1()
	{
		//creating a json object
//		JSONObject request=new JSONObject();
//		request.put("name", "Raghav");
//		request.put("job", "Teacher");
//		
		//System.out.println(request.toJSONString());

		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(payload.body()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201).
			log().all();
			
			
		
	}
	
	//@Test
	public void put_1()
	{
		//creating a json object
		JSONObject request=new JSONObject();
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200);
			
			
		
	}

	//@Test
	public void patch_1()
	{
		//creating a json object
		JSONObject request=new JSONObject();
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("https://reqres.in/api/users/2").
		then().
			statusCode(200);
			
			
		
	}
	
	//@Test
	public void delete_1()
	{
		when().
			delete("https://reqres.in/api/users/2").
		then().
			statusCode(204);
			
			
		
	}
	

}
