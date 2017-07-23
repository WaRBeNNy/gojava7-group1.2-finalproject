package mapper;

import java.io.Writer;
import java.lang.reflect.Field;

import writer.JsonWriter;

public class ObjectMapper implements JsonMapper {

    @Override
    public void write(Object obj, JsonWriter writer) {
	// TODO Auto-generated method stub
	        writer.writeString("\"" + obj.getClass().getSimpleName() + "\"");
	        writer.writePropertySeparator();
	        writer.writeString(" \"");
	        
	        Field[] fields = obj.getClass().getFields();
		for (int i = 0; i < fields.length; i++) {
		    JsonMapper mapper = classDefiner(fields[i].getDeclaringClass());
		    mapper.write(fields[i].getDeclaringClass(), writer);
		}
	        writer.writeString(" \"");
    	}
    
    public JsonMapper classDefiner(Object obj) {
	switch (obj.getClass().getSimpleName()){
    		case ("Byte"):
    		case ("Short"):
    		case ("Integer"):
    		case ("Long"):
    		case ("Float"):
    		case ("Double"):
    		    return new NumberMapper();
    		case ("String"):
    		    return new StringMapper();
    		case ("Boolean"):
    		    return new BooleanMapper();
    		default :
    		    return new ObjectMapper();
		}
    	}
}
