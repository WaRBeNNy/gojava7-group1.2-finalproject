package mapper;

import serializer.JsonSerializer;
import writer.JsonWriter;
import java.lang.reflect.Array;

public class PrimitiveArrayMapper implements JsonMapper{
    @Override
    public void write(Object obj, JsonWriter writer) {
		JsonSerializer jsonSer = JsonSerializer.getInstance();
    	writer.writeArrayBegin();
		for(int i = 0; i < Array.getLength(obj); i++){
    		jsonSer.serialize(Array.get(obj, i), writer.getWriter());
    		if( i != Array.getLength(obj) - 1) {
				writer.writeSeparator();
			}
    	}
    	writer.writeArrayEnd();
    }
}
