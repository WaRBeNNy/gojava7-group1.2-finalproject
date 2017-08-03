package mapper;

import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import annotations.JsonIgnore;
import annotations.JsonProperty;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotation;

import serializer.JsonSerializer;
import writer.JsonWriter;

public class ObjectMapper implements JsonMapper {

	@Override
	public void write(Object obj, JsonWriter writer) {
		// TODO Auto-generated method stub
		JsonSerializer jsonSerializer = JsonSerializer.getInstance();
		writer.writeObjectBegin();
		Field[] fields = obj.getClass().getDeclaredFields();
		Field.setAccessible(fields, true);
		for (int i = 0; i < fields.length; i++) {
			try {
				int mods = fields[i].getModifiers();
				Object value = fields[i].get(obj);
				if (fields[i].isAnnotationPresent(JsonProperty.class)) {
					if(!fields[i].getAnnotation(JsonProperty.class).name().isEmpty()) {
						writer.writeString(fields[i].getAnnotation(JsonProperty.class).name());
					} else {
						writer.writeString(fields[i].getName());
					}
					writer.writePropertySeparator();
					jsonSerializer.serialize(value, writer.getWriter());
					if( i != fields.length - 1) {
						writer.writeSeparator();
					}
				} else if (fields[i].isAnnotationPresent(JsonIgnore.class)) {
					continue;
				} else if (Modifier.isPrivate(mods) || Modifier.isTransient(mods)) {
					continue;
				} else {
					writer.writeString(fields[i].getName());
					writer.writePropertySeparator();
					jsonSerializer.serialize(value, writer.getWriter());
					if(i != fields.length - 1){
						writer.writeSeparator();
					}
				}
			} catch (IllegalStateException | IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		writer.writeObjectEnd();
	}

}
