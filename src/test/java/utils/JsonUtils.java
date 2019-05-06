// We have brought this class to the test pacakge otherwise autowire would be out of scope in the java package
// any class with annotation @Component will be trated as a bean an initiated
// this will then be a singleton class thoughout the session
// on initial load classes that you speicfy for component scan will be scanned and if annotaion of component is
// found it will initiate that bean
// In this instance the compponent scan is done at Appconfig class

package utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import io.restassured.response.Response;
import net.serenitybdd.rest.RestRequests;
import org.hamcrest.collection.IsCollectionWithSize;
import org.springframework.beans.factory.annotation.Autowired;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Option;

import org.springframework.stereotype.Component;
import restAssuredUtils.ResponseMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Component
public class JsonUtils {

	@Autowired
	private ResponseMap responseMap;

	public JsonUtils() {
		super();
	}
	
	public Boolean isValueInResponse(String node, String value)
	{
		Configuration conf = Configuration.defaultConfiguration();
		conf.addOptions(Option.ALWAYS_RETURN_LIST);
		
		List<String> nodeValues = com.jayway.jsonpath.JsonPath.read(responseMap.getResponseBody(), "$.." + node);
		System.out.println(Arrays.toString(nodeValues.toArray()));
		
		System.out.println("Value : " + value  + "  Node Value: " + Arrays.toString(nodeValues.toArray()));
		//return value.equals(Arrays.toString(nodeValues.toArray()));
		return nodeValues.contains(value);
		
	}

	public void getStaticJSON(String filepath) throws IOException {

		File file = (new File(filepath));
		String sampleResponse = org.apache.commons.io.FileUtils.readFileToString(file);
		responseMap.setStatusCode(200);
		responseMap.setResponseBody(sampleResponse);
		System.out.println("Response body from static: " + responseMap.getResponseBody());
		//sampleDTO.sample s = responseMap.getResponseBody().as(sampleDTO.sample.class);
	}



	public void secondTest()
	{
		Response response = RestRequests.
				get("/maps/api/place/textsearch/json").then().extract().response();

		System.out.println("Response: " + response.getBody().asString());
		sampleDTO.sample s = response.getBody().as(sampleDTO.sample.class);
	}

}
