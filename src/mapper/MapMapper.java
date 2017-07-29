package mapper;

import java.util.Map;

import serializer.JsonSerializer;
import writer.JsonWriter;

public class MapMapper implements JsonMapper{
    @Override
    public void write(Object obj, JsonWriter writer) {
    	writer.writeObjectBegin();
    	Map<Object, Object> map = (Map<Object, Object>) obj;
    	for (Map.Entry<Object, Object> pair : map.entrySet()) {
    		JsonSerializer jsonSer = JsonSerializer.getInstance();
    		Object key = pair.getKey();
    		jsonSer.serialize(key);
    		Object value = pair.getValue();
    		jsonSer.serialize(value);
    	}
    	writer.writeObjectEnd();
    }
}
