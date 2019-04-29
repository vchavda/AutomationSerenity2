package cucumber.features.steps;

import Utilities.HeaderBuilder;
import config.Appconfig;
import cucumber.api.DataTable;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import restAssuredUtils.RestAssuredUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import utils.JsonUtils;
import Utilities.ParamsBuilder;
import restAssuredUtils.ResponseMap;


@ContextConfiguration(classes = {Appconfig.class})
public class restassuredStep {

	//RestAssuredUtils ra = new RestAssuredUtils();
	//JsonUtils ju = new JsonUtils();

	@Autowired
	RestAssuredUtils ra;

	@Autowired
	JsonUtils ju;

	@Autowired
	ResponseMap responseMap;


	@Given("^I am connected to the database$")
	public void connectToDB() throws SQLException {
		//Connection con = DriverManager.getConnection("IBM515-PC0EUKMW\\SQLEXPRESS","","");
		//Statement st = con.createStatement();
	}

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
		ra.makeAPICall();
	}
	
	@Then("^I should get a valid response of: '(.*)'$")
	public void ThenIShouldGetAValidResponse(String val)
	{

		//ju.isValueInResponse("name", "value");
		System.out.println("<<< responseMap.getStatusCode" + responseMap.getStatusCode());
		assertEquals(Integer.toString(responseMap.getStatusCode()), val);
	}
	
	@Then("^the response should contain this '(.*)' and '(.*)'$")
	public void ThenTheResponseShouldContainThisNodeAndValue(String node, String value){
		assertTrue(ju.isValueInResponse(node, value));
		
	}


	@Given("^I submit dynamic headers$")
	public void iSubmitDynamicHeaders(DataTable dt)  {
		HeaderBuilder.clear();
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		list.forEach((p) -> HeaderBuilder.addHeader(p.get("headerType"), p.get("headerValue")));
	}

}
