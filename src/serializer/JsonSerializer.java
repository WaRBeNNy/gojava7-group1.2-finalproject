package serializer;

import mapper.*;
import writer.JsonWriter;

import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;

public class JsonSerializer {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private String PropSeparator = System.getProperty("file.separator");
    private String PropUser = System.getProperty("user.dir");
    private String Path = PropUser + PropSeparator + "resources" + PropSeparator + "JsonFormat.data";      //Для того, что бы запускалось на люброй ОС

    private File file = new File(Path); //Priavate

    Map<Class, JsonMapper> mappersCache;

    public JsonSerializer() {
        this.mappersCache.put(Boolean.class, new BooleanMapper());
        this.mappersCache.put(Collection.class, new CollectionMapper());
        this.mappersCache.put(Map.class, new MapMapper());
        this.mappersCache.put(Number.class, new NumberMapper());
        this.mappersCache.put(Object[].class, new ObjectArrayMapper());
        this.mappersCache.put(Object[].class, new PrimitiveArrayMapper());
        this.mappersCache.put(String.class, new StringMapper());
    }

    public boolean isIndent(){
        //…
        return false;
    }

    public void setIndent(boolean indent){
        //…
    }

    public String serialize(Object obj) throws IllegalStateException {
        //…
        return " ";
    }

    public void serialize(Object obj, OutputStream stream){

        serialize(obj,stream, DEFAULT_CHARSET);
    }

    public void serialize(Object obj, OutputStream stream, Charset charset){
        serialize(obj, new OutputStreamWriter(stream, charset));
    }

    public void serialize(Object obj, Writer writer){
        //…
    }

    protected void serialize(Object object, JsonWriter writer) {
        getMapper(String.class);
    }

    protected JsonMapper getMapper(Class clazz) {
        return new StringMapper();
    }
}
