package Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yecht.Data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HeaderBuilder {

    static Logger logger = LoggerFactory.getLogger(HeaderBuilder.class);

    public static final HashMap<String, String> headerBuilder = new HashMap<>();

    public static void addHeader(String Key, String Value) {
        headerBuilder .put(Key, Value);
    }

    public static Integer getSize() {
        return headerBuilder.size();
    }

    public static void clear() {
        logger.info("header cleared");
        headerBuilder.clear();
    }


    public static boolean  checkKeyExists (String key) {
        return headerBuilder.containsKey(key);
    }

    public static void itersteMap() {
        Set set = headerBuilder.entrySet();
        Iterator iterstor = set.iterator();
        while (iterstor.hasNext()) {
            Map.Entry entry = (Map.Entry) iterstor.next();
            logger.info("Key is : " + entry.getKey() + " value is " + entry.getValue());
        }
    }
}