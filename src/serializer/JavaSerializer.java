package serializer;

import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class JavaSerializer {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private String PropSeparator = System.getProperty("file.separator");
    private String PropUser = System.getProperty("user.dir");
    private String Path = PropUser + PropSeparator + "resources" + PropSeparator + "JsonFormat.data";      //Для того, что бы запускалось на люброй ОС

    private File file = new File(Path); //Priavate

    public boolean isIndent(){
        //…
        return false;
    }

    public void setIndent(boolean indent){
        //…
    }

    public String serialize(Object obj) throws new IllegalStateException() {
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
}
