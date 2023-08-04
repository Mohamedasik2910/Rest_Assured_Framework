package api.Endpoints;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ResourceBundle;

import static io.restassured.matcher.RestAssuredMatchers.*;


import api.Payloads.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {
	
	public static ResourceBundle Geturl()
	{
		ResourceBundle resource=ResourceBundle.getBundle("approutes");
		return resource;
	}
	
	
	public static Response createusers(Users payload)
	{  
		String Url=Geturl().getString("User_Post_Url");
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Url);
				return res;
	}
	
	public static Response Getusers(String uname)
	{
		String Url=Geturl().getString("User_Get_Url");
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.when()
				.get(Url);
				return res;
	}
	
	public static Response Putusers(Users payload, String uname)
	{
		String Url=Geturl().getString("User_Put_Url");
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.body(payload)
				.when()
				.put(Url);
				return res;
	}

	public static Response Deleteusers(String uname)
	{
		String Url=Geturl().getString("User_Delete_Url");
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.when()
				.delete(Url);
				return res;
	}

}
