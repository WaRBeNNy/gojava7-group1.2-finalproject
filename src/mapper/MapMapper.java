package mapper;

import java.util.Iterator;
import java.util.Map;

import serializer.JsonSerializer;
import writer.JsonWriter;

public class MapMapper implements JsonMapper{
    @Override
    public void write(Object obj, JsonWriter writer) {
		JsonSerializer jsonSer = JsonSerializer.getInstance();
    	writer.writeObjectBegin();
    	Map<Object, Object> map = (Map<Object, Object>) obj;
    	Iterator iterator = map.entrySet().iterator();
    	while(iterator.hasNext()) {
    		Map.Entry entry = (Map.Entry) iterator.next();
    		Object key = entry.getKey();
    		writer.writeString(key.toString());
    		writer.writePropertySeparator();
    		Object value = entry.getValue();
    		jsonSer.serialize(value, writer.getWriter());
    		if(iterator.hasNext()) {
				writer.writeSeparator();
			}
    	}
    	writer.writeObjectEnd();
    }
}
