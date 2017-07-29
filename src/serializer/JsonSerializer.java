package serializer;

import mapper.*;
import writer.IndentedJsonWriter;
import writer.JsonWriter;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializer {
    private static volatile JsonSerializer instance = new JsonSerializer();
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private boolean indent;

    Map<Class, JsonMapper> mappersCache = new HashMap<>();

    private JsonSerializer() {
        this.mappersCache.put(Boolean.class, new BooleanMapper());
        this.mappersCache.put(Collection.class, new CollectionMapper());
        this.mappersCache.put(Map.class, new MapMapper());
        this.mappersCache.put(Number.class, new NumberMapper());
        this.mappersCache.put(Object[].class, new ObjectArrayMapper());
        this.mappersCache.put(Array.class, new PrimitiveArrayMapper());
        this.mappersCache.put(String.class, new StringMapper());
        this.mappersCache.put(Object.class, new ObjectMapper());
    }

    public static JsonSerializer getInstance() {
        return instance;
    }

    public boolean isIndent(){
        return indent;
    }

    public void setIndent(boolean indent){
        this.indent = indent;
    }

    public String serialize(Object obj) throws IllegalStateException {
        Writer stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        serialize(obj, jsonWriter);

        return stringWriter.toString();
    }

    public void serialize(Object obj, OutputStream stream){

        serialize(obj,stream, DEFAULT_CHARSET);
    }

    public void serialize(Object obj, OutputStream stream, Charset charset){
        serialize(obj, new OutputStreamWriter(stream, charset));
    }

    public void serialize(Object obj, Writer writer){
        JsonWriter jsonWriter;
        if(isIndent()) {
            jsonWriter = new IndentedJsonWriter(writer);
        } else {
            jsonWriter = new JsonWriter(writer);
        }


        serialize(obj, jsonWriter);
    }

    protected void serialize(Object object, JsonWriter writer) {
        JsonMapper mapper = getMapper(object.getClass());
        mapper.write(object, writer);
        writer.flush();
    }

    protected JsonMapper getMapper(Class clazz) {
        if (clazz.equals(Integer.class) || clazz.equals(Double.class) || clazz.equals(Float.class)
                || clazz.equals(Short.class) || clazz.equals(Long.class) || clazz.equals(Byte.class)) {
            return mappersCache.get(Number.class);
        } else if (mappersCache.containsKey(clazz)) {
            return mappersCache.get(clazz);
        }

        return mappersCache.get(Object.class);
    }
}
