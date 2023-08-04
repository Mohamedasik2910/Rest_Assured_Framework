package api.Testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Endpoints.UserEndpoints;
import api.Payloads.Users;
import io.restassured.response.Response;

public class Testuser {
	
	Faker fk;
	Users userpayloaddata;
	
	@BeforeClass
	public void setup()
	{
			fk=new Faker();
			userpayloaddata=new Users();
			
			userpayloaddata.setId(fk.idNumber().hashCode());
			userpayloaddata.setFirstName(fk.name().firstName());
			userpayloaddata.setLastName(fk.name().lastName());
			userpayloaddata.setUsername(fk.name().username());
			userpayloaddata.setPassword(fk.internet().password(5, 10));
			userpayloaddata.setPhone(fk.phoneNumber().cellPhone());
			userpayloaddata.setEmail(fk.internet().emailAddress());
	}
	
	@Test(priority = 1)
	public void postusers()
	{
		Response ures=UserEndpoints.createusers(userpayloaddata);
		ures.then().log().all();
		Assert.assertEquals(ures.statusCode(), 200);	
		
	}

	@Test(priority=2)
	public void Getusers()
	{
		Response ures=UserEndpoints.Getusers(userpayloaddata.getUsername());
		ures.then().log().all();
		Assert.assertEquals(ures.statusCode(), 200);
	}
	
	@Test(priority=3)
	public void Putusers()
	{
		userpayloaddata.setPassword(fk.internet().password(5, 10));
		userpayloaddata.setPhone(fk.phoneNumber().cellPhone());
		userpayloaddata.setEmail(fk.internet().emailAddress());
		Response ures=UserEndpoints.Putusers(userpayloaddata, userpayloaddata.getUsername());
		ures.then().log().all();
		Assert.assertEquals(ures.statusCode(), 200);
		//check the data
		
		Response cres=UserEndpoints.Putusers(userpayloaddata, userpayloaddata.getUsername());
		cres.then().log().all();
	}
	
	@Test(priority=3)
	public void Deleteusers()
	{
		Response ures=UserEndpoints.Deleteusers(userpayloaddata.getUsername());
		ures.then().log().all();
		Assert.assertEquals(ures.statusCode(), 200);
	}
}


