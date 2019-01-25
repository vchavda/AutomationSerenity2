package restAssured;

import java.util.concurrent.TimeUnit;

import Utilities.ParamsBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReusableSpecifications {
	public static RequestSpecBuilder rspec;
	public static RequestSpecification requestSpecBuilder;

	public static RequestSpecification getGenericRequestSpec() {

		rspec = new RequestSpecBuilder();
		rspec.setContentType(ContentType.JSON);
		ParamsBuilder.iterateMap();
		rspec.addParams(ParamsBuilder.getParam());
		requestSpecBuilder = rspec.build();
		return requestSpecBuilder;
	}
	
	public static  ResponseSpecification getGenericResponseSpec() {
		ResponseSpecBuilder rqs = new ResponseSpecBuilder();
		rqs.expectResponseTime(org.hamcrest.Matchers.lessThan(5L), TimeUnit.SECONDS);
		return rqs.build();

	}
}
