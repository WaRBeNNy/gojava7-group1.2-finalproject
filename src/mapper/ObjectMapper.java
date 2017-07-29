package mapper;

import java.io.StringWriter;
import java.lang.reflect.Field;

import serializer.JsonSerializer;
import writer.JsonWriter;

public class ObjectMapper implements JsonMapper {


	@Override
    public void write(Object obj, JsonWriter writer) {
	// TODO Auto-generated method stub
		JsonSerializer jsonSerializer = JsonSerializer.getInstance();
    		writer.writeObjectBegin();
    		Field[] fields = obj.getClass().getFields();
    		Field.setAccessible(fields, true);
	        for (Field field : fields) {
	        	try {
	        		writer.writeString(field.getName());
	        		writer.writePropertySeparator();
	        		Object value = field.get(obj);
	        		jsonSerializer.serialize(value, writer.getWriter());
	        		writer.writeString(",");
				} catch (IllegalStateException | IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        writer.writeObjectEnd();
    	}
}
