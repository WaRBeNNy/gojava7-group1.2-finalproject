package mapper;

import writer.JsonWriter;

public class StringMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) {
        writer.writeString("\"Строка\"");
        writer.writePropertySeparator();
        writer.writeString(" \"");
        writer.writeString(obj.toString());
        writer.writeString("\"");
    }
}
