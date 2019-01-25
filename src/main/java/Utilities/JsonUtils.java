package Utilities;

import java.util.Arrays;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Option;

import io.restassured.path.json.JsonPath;

public class JsonUtils {
	
	
	public JsonUtils() {
		super();
	}
	
	public Boolean isValueInResponse(String node, String value)
	{
		
		Configuration conf = Configuration.defaultConfiguration();
		conf.addOptions(Option.ALWAYS_RETURN_LIST);
		
		List<String> nodeValues = com.jayway.jsonpath.JsonPath.read(ResponseMap.getResponseBody(), "$.." + node);
		System.out.println(Arrays.toString(nodeValues.toArray()));
		
		System.out.println("Value : " + value  + "  Node Value: " + Arrays.toString(nodeValues.toArray()));
		return value.equals(Arrays.toString(nodeValues.toArray()));
		
	}

}
