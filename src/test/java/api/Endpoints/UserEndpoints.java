package api.Endpoints;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.matcher.RestAssuredMatchers.*;


import api.Payloads.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
	
	public static Response createusers(Users payload)
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Routes.user_PostURL);
				return res;
	}
	
	public static Response Getusers(String uname)
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.when()
				.get(Routes.user_GetURL);
				return res;
	}
	
	public static Response Putusers(Users payload, String uname)
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.body(payload)
				.when()
				.put(Routes.user_PutURL);
				return res;
	}

	public static Response Deleteusers(String uname)
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.when()
				.delete(Routes.user_DeleteURL);
				return res;
	}

}
