package mapper;

import writer.JsonWriter;

public class NumberMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) {
        writer.writeNumber((Number) obj);
    }
}
