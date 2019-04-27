package utils;

import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;

import Utilities.ResponseMap;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Option;

import config.Appconfig;
import io.restassured.path.json.JsonPath;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@Component
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
		//return value.equals(Arrays.toString(nodeValues.toArray()));
		return nodeValues.contains(value);
		
	}

}
