package api.Testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.Endpoints.UserEndpoints;
import api.Endpoints.UserEndpoints2;
import api.Payloads.Users;
import api.Utilities.Dataproviders;
import io.restassured.response.Response;

public class TestuserDD2 {
	
	Users userdata;

	@Test(priority=1, dataProvider = "data", dataProviderClass = Dataproviders.class)
	public void postusers(String exceldata[])
	{
		userdata =new Users();
		userdata.setId(Integer.parseInt(exceldata[0]));
		userdata.setFirstName(exceldata[1]);
		userdata.setLastName(exceldata[2]);
		userdata.setUsername(exceldata[3]);
		userdata.setPassword(exceldata[4]);
		userdata.setPhone(exceldata[5]);
		userdata.setPassword(exceldata[6]);
		
		Response ures=UserEndpoints2.createusers(userdata);
		ures.then().log().all();
		Assert.assertEquals(ures.getStatusCode(), 200);
		
	}
	
	@Test(priority=2, dataProvider = "username", dataProviderClass = Dataproviders.class)
	public void Getusers(String uname)
	{
		Response ures=UserEndpoints2.Getusers(uname);
		ures.then().log().all();
		Assert.assertEquals(ures.getStatusCode(), 200);
		
	}
	
	@Test(priority=3, dataProvider = "username", dataProviderClass = Dataproviders.class)
   public void Putusers(String uname)
   {
		userdata.setPassword("company");
		userdata.setPhone("1234567890");
		userdata.setEmail("welcome@gmail.com");
		Response ures=UserEndpoints2.Putusers(userdata, uname);
		ures.then().log().all();
		Assert.assertEquals(ures.getStatusCode(), 200);
   }

   @Test(priority=4, dataProvider = "username", dataProviderClass = Dataproviders.class)
   public void Deleteusers(String uname)
   {
	   Response ures=UserEndpoints2.Deleteusers(uname);
	   ures.then().log().all();
	   Assert.assertEquals(ures.getStatusCode(), 200);
   }
}


