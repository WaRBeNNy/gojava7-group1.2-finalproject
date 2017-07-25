package mapper;

import java.io.Writer;
import java.lang.reflect.Field;

import serializer.JsonSerializer;
import writer.JsonWriter;

public class ObjectMapper implements JsonMapper {

    @Override
    public void write(Object obj, JsonWriter writer) {
	// TODO Auto-generated method stub
    		writer.writeObjectBegin();
    		Field[] fields = obj.getClass().getFields();
	        for (int i = 0; i < fields.length; i++) {
	        	JsonSerializer jsonSer = new JsonSerializer();
	        	try {
	        		writer.writeString(fields[i].getName());
	        		writer.writePropertySeparator();
					jsonSer.serialize(fields[i].get(fields[i].getDeclaringClass()));
				} catch (IllegalStateException | IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        writer.writeObjectEnd();
    	}
}
