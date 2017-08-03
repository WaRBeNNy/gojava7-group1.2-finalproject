package mapper;

import java.util.*;

import serializer.JsonSerializer;
import writer.JsonWriter;

public class CollectionMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) {
		JsonSerializer jsonSer = JsonSerializer.getInstance();
    	writer.writeArrayBegin();
    	Collection collection = (Collection) obj;
    	Iterator<Object> iterator = collection.iterator();
    	while(iterator.hasNext()) {
    		jsonSer.serialize(iterator.next(), writer.getWriter());
    		if(iterator.hasNext()) {
				writer.writeSeparator();
			}
    	}
    	writer.writeArrayEnd();
    }
}
