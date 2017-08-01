package mapper;

import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotation;

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
	        		if (isSeriazable(field)) {
		        		writer.writeString(field.getName());
		        		writer.writePropertySeparator();
	        			Object value = field.get(obj);
	        			jsonSerializer.serialize(value, writer.getWriter());
		           		writer.writeSeparator();
	        		}
				} catch (IllegalStateException | IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        writer.writeObjectEnd();
    	}
    
    public boolean isSeriazable(Field field) {
    	if (Modifier.field.getModifiers().isPrivate()) {
    		if(isAnnotatable(field)){
    			return true;
    		}
    		else return false;
    	}
    	if(Modifier.field.getModifiers().isTransient){
    		if(isAnnotatable(field)){
    			return true;
    		}
    		else return false;
    	}
    	return true;
    }
    
    public boolean isAnnotatable(Field field){
    	Annotation[] annotations = (Annotation[]) field.getAnnotations();
    	for (Annotation annotation : annotations){
    		if (annotation.toString().equals("JsonProperty"));
    			return true;
    		}
    		return false;
    }
}
