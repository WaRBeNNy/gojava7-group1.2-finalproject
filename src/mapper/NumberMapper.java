package mapper;

import writer.JsonWriter;

public class NumberMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) {
        writer.writeString("\"" + obj.getClass().getSimpleName() + "\"");
        writer.writePropertySeparator();
        writer.writeString(" \"");
        writer.writeNumber((Number) obj);
        writer.writeString(" \"");
    }
}
