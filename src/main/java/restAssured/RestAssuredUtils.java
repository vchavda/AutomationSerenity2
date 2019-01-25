package restAssured;

import net.serenitybdd.rest.SerenityRest;
import Utilities.ParamsBuilder;
import Utilities.ResponseMap;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestAssuredUtils {


	
	public void makeAPICall()
	{
		RestAssured.baseURI = "https://maps.googleapis.com";
		Response response = 
		RestAssured.given(ReusableSpecifications.getGenericRequestSpec()).
		 expect().spec(ReusableSpecifications.getGenericResponseSpec()).
		   when().
		   get("/maps/api/place/textsearch/json").
           //get("/maps/api/place/textsearch/json?query=Churchgate&key=AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg").
        then().
           extract().response();
		

		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		
		ResponseMap.setStatusCode(response.statusCode());
		ResponseMap.setResponseBody(response.asString());
		
	}
	
}
	