package restAssuredUtils;

import config.Appconfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import restAssured.ReusableSpecifications;

//have to make this class component otherwise Responsemap will be nullwhen autowired.
@Component
public class RestAssuredUtils {

	@Autowired
	private ResponseMap responseMap;
	
	public void makeAPICall(String path)
	{
		RestAssured.baseURI = responseMap.getBaseURL();
		Response response = SerenityRest.
		given(ReusableSpecifications.getGenericRequestSpec()).
		 expect().spec(ReusableSpecifications.getGenericResponseSpec()).
		   when().
		   get(path).
        then().
           extract().response();
		

		System.out.println(response.asString());
		System.out.println(response.getStatusCode());

		if (responseMap == null){
			System.out.println("NO AUTOWIRED !");
		}

		System.out.println("response,statusCode = " + response.statusCode());
		System.out.println("response.asString = " + response.asString());
		responseMap.setStatusCode(response.statusCode());
		responseMap.setResponseBody(response.asString());
		
	}
	
}
	