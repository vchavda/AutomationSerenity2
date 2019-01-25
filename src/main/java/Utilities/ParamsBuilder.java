package Utilities;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ParamsBuilder {
	
	static Logger logger = LoggerFactory.getLogger(ParamsBuilder.class);
	
	private static final HashMap<String, String> paramsBuilder = new HashMap<String, String>();

	public static void addParams(String key, String value)
	{
		paramsBuilder.put(key, value);
	}

	public static Integer getSize() {
		return paramsBuilder.size();
	}
	
	public static void clear() {
		logger.info("");
		paramsBuilder.clear();
	}
	
	public static Map<String, String> getParam() {
		return paramsBuilder;
	}
	
	public static void iterateMap() {
		
		System.out.println("iterateMap ...");
		Set set = paramsBuilder.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			Map.Entry mEntry = (Map.Entry)iterator.next();
			logger.info("key is : " + mEntry.getKey() +  " Value is : " + mEntry.getValue());
			System.out.println("key is : " + mEntry.getKey() +  " Value is : " + mEntry.getValue());
		}		
	}
	
}
