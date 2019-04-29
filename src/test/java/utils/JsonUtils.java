// We have brought this class to the test pacakge otherwise autowire would be out of scope in the java package
// any class with annotation @Component will be trated as a bean an initiated
// this will then be a singleton class thoughout the session
// on initial load classes that you speicfy for component scan will be scanned and if annotaion of component is
// found it will initiate that bean
// In this instance the compponent scan is done at Appconfig class

package utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Option;

import org.springframework.stereotype.Component;
import restAssuredUtils.ResponseMap;

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

}
