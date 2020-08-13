package requests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ownApi {
	
	@Test
	public void test_get()
	{
		baseURI= "http://localhost:3000/";
		
		given().
			param("name", "Automation").
			get("/subjects").
		then().
			statusCode(200).
			log().all();
	}
	
	//@Test
	public void test_Post()
	{
		JSONObject request=new JSONObject();
		request.put("firstName", "Ashish");
		request.put("lastName", "Agarwal");
		request.put("subjectId", 4);
		
		baseURI= "http://localhost:3000/";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}
	
	//@Test
		public void test_Patch()
		{
			JSONObject request=new JSONObject();
			
			request.put("lastName", "Patel");
			
			
			baseURI= "http://localhost:3000/";
			
			given().
				header("Content-Type","application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).
			when().
				patch("/users/2").
			then().
				statusCode(200).
				log().all();
		}
	
	//@Test
	public void test_delete()
	{
		baseURI="http://localhost:3000/";
		when().
			delete("/users/4").
		then().
			statusCode(200);
	}

}
