package mapper;

import java.util.Collection;

import serializer.JsonSerializer;
import writer.JsonWriter;

public class CollectionMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) {
    	writer.writeArrayBegin();
    	Collection collection = (Collection) obj;
    	for(Object element : collection) {
    		JsonSerializer jsonSer = JsonSerializer.getInstance();
    		jsonSer.serialize(element);
    	}
    	writer.writeArrayEnd();
    }
}
