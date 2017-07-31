package writer;

import java.io.IOException;
import java.io.Writer;

public class JsonWriter {

    protected static final char OBJ_BEGIN = '{';                              //
    protected static final char OBJ_END = '}';                                //
    protected static final char ARR_BEGIN = '[';                              //
    protected static final char ARR_END = ']';                                //
    protected static final char SEPARATOR = ',';                              // для простоты действий)
    protected static final char PROP_SEPARATOR = ':';                         //
    protected static final char STR_SEPARATOR = '\"';                         //
    protected static final String NULL = "null";                              //

    protected Writer writer;

    protected boolean separatorLast;

    public JsonWriter(Writer writer) {
        this.writer = writer;
    }

    public Writer getWriter() {
        return writer;
    }

    public void writeObjectBegin() {
        try {
            writer.write(OBJ_BEGIN);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeObjectEnd() {
        try {
            //if(writer.toString().endsWith(",")) {
            writer.write("\b");
            //}
            writer.write(OBJ_END);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //– если предыдущий символ – запятая, удаляет его
    }

    public void writeArrayBegin() {
        try {
            writer.write(ARR_BEGIN);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeArrayEnd() {
        try {
            //if(writer.toString().endsWith(",")) {
            writer.write("\b");
            //}
            writer.write(ARR_END);
        } catch (IOException e) {
            e.printStackTrace();
        }//– если предыдущий символ – запятая, удаляет его
    }

    public void writeString(String StringValue) {
        try {
            writer.append(STR_SEPARATOR).append(StringValue).append(STR_SEPARATOR);
        } catch (IOException e) {
            e.printStackTrace();
        }//– данный метод принимает стрингу, при необходимости ескейпит внутри символы, добавляет с обеих сторон «“»
    }

    public void writeNumber(Number number) {
        try {
            writer.write(number.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }// – записывает в низ лежащий поток число
    }

    public void writeSeparator() {
        try {
            writer.write(SEPARATOR);
        } catch (IOException e) {
            e.printStackTrace();
        }// – добавляет запятую
    }

    public void writePropertySeparator() {
        try {
            writer.write(PROP_SEPARATOR);
        } catch (IOException e) {
            e.printStackTrace();
        }//– добавляет двоеточие «:»
    }

    public void writeBoolean(Boolean BooleanValue) {
        try {
            writer.write(BooleanValue.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeNull() {
        try {
            writer.write(NULL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flush() {
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}