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

import static net.serenitybdd.rest.SerenityRest.given;

public class RestAssuredUtils {


	
	public void makeAPICall()
	{
		RestAssured.baseURI = "https://community-open-weather-map.p.rapidapi.com";
		Response response = SerenityRest.
		given(ReusableSpecifications.getGenericRequestSpec()).
		 expect().spec(ReusableSpecifications.getGenericResponseSpec()).
		   when().
		   get("/forecast").
           //get("/maps/api/place/textsearch/json?query=Churchgate&key=AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg").
        then().
           extract().response();
		

		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		
		ResponseMap.setStatusCode(response.statusCode());
		ResponseMap.setResponseBody(response.asString());
		
	}
	
}
	