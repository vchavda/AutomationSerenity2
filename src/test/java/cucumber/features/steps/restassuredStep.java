package cucumber.features.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import restAssured.RestAssuredUtils;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import Utilities.JsonUtils;
import Utilities.ParamsBuilder;
import Utilities.ResponseMap;

public class restassuredStep {

	RestAssuredUtils ra = new RestAssuredUtils();
	JsonUtils ju = new JsonUtils();
	
	
	@Given("^I submit dynamic query parameters$")
	public void whenISubmitDynamicParameters(DataTable dt){
		ParamsBuilder.clear();
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		list.forEach((p) -> ParamsBuilder.addParams(p.get("queryParam"), p.get("queryParamValue")));
		list.forEach((p) -> System.out.println(p.get("queryParam") + " : " +  p.get("queryParamValue")));

	}
	
	@When("^user makes an API call then they get a valid status code back$")
	public void verifyValid_APICall()
	{
		assert(true);
	}

	@When("^I submit an API call$")
	public void query()
	{
		assert(true);
	}
	
	@Then("^I should get a valid response of: '(.*)'$")
	public void ThenIShouldGetAValidResponse(String val)
	{
		System.out.println("Request is: " + val);
		ra.makeAPICall();
		ju.isValueInResponse("name", "value");
		assertEquals(Integer.toString(ResponseMap.getStatusCode()), val);
	}
	
	@Then("^the response should contain this '(.*)' and '(.*)'$")
	public void ThenTheResponseShouldContainThisNodeAndValue(String node, String value){
		assertTrue(ju.isValueInResponse(node, value));
		
	}
	
	
}
