package mapper;

import writer.JsonWriter;

public interface JsonMapper<T> {
    void write(T obj, JsonWriter writer);
}
