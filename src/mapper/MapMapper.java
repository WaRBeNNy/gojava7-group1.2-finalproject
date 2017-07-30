package mapper;

import java.util.Map;

import serializer.JsonSerializer;
import writer.JsonWriter;

public class MapMapper implements JsonMapper{
    @Override
    public void write(Object obj, JsonWriter writer) {
		JsonSerializer jsonSer = JsonSerializer.getInstance();
    	writer.writeObjectBegin();
    	Map<Object, Object> map = (Map<Object, Object>) obj;
    	for (Map.Entry<Object, Object> pair : map.entrySet()) {
    		Object key = pair.getKey();
    		writer.writeString(key.toString());
    		writer.writeSeparator();
    		Object value = pair.getValue();
    		jsonSer.serialize(value, writer.getWriter());

    	}
    	writer.writeObjectEnd();
    }
}
