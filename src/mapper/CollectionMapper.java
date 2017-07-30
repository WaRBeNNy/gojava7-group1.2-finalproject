package mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import serializer.JsonSerializer;
import writer.JsonWriter;

public class CollectionMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) {
		JsonSerializer jsonSer = JsonSerializer.getInstance();
    	writer.writeArrayBegin();
    	for(Object element : (Collection)obj) {
    		jsonSer.serialize(element, writer.getWriter());
    		writer.writeSeparator();
    	}
    	writer.writeArrayEnd();
    }
}
