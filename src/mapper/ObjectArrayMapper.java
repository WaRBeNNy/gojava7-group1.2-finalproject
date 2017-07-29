package mapper;

import serializer.JsonSerializer;
import writer.JsonWriter;

public class ObjectArrayMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) {
    	writer.writeArrayBegin();
    	Object[] arrayObject = (Object[]) obj;
    	for(int i = 0; i < arrayObject.length; i++){
    		JsonSerializer jsonSer = new JsonSerializer();
    		jsonSer.serialize(arrayObject[i]);
    	}
    	writer.writeArrayEnd();
    }
}
