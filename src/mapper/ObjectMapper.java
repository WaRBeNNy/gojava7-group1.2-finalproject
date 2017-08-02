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
		for (Field field : fields) {
			try {
				int mods = field.getModifiers();
				Object value = field.get(obj);
				if (field.isAnnotationPresent(JsonProperty.class)) {
					if(!field.getAnnotation(JsonProperty.class).name().isEmpty()) {
						writer.writeString(field.getAnnotation(JsonProperty.class).name());
					} else {
						writer.writeString(field.getName());
					}
					writer.writePropertySeparator();
					jsonSerializer.serialize(value, writer.getWriter());
					writer.writeSeparator();
				} else if (field.isAnnotationPresent(JsonIgnore.class)) {
					continue;
				} else if (Modifier.isPrivate(mods) || Modifier.isTransient(mods)) {
					continue;
				} else {
					writer.writeString(field.getName());
					writer.writePropertySeparator();
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

}
