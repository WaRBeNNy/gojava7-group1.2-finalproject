package writer;

import java.io.IOException;
import java.io.Writer;

public class JsonWriter {
   Writer writer;

    protected static final char OBJ_BEGIN = '{';                              //
    protected static final char OBJ_END = '}';                                //
    protected static final char ARR_BEGIN = '[';                              //
    protected static final char ARR_END = ']';                                //
    protected static final char SEPARATOR = ',';                              // для простоты действий)
    protected static final char PROP_SEPARATOR = ':';                         //
    protected static final char STR_SEPARATOR = '\"';                         //
    protected static final String NULL = "null";                              //

    protected boolean separatorLast;

    public JsonWriter(Writer writer) {
        this.writer = writer;
    }

    public Writer getWriter() {
        return writer;
    }

    public void writeObjectBegin(){
        try {
            writer.write('{');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeObjectEnd(){
        try {
            //if(writer.toString().endsWith(",")) {
                writer.write("\b");
            //}
            writer.write('}');
        } catch (IOException e) {
            e.printStackTrace();
        }
        //– если предыдущий символ – запятая, удаляет его
    }

    public void writeArrayBegin() {
        try {
            writer.write('[');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeArrayEnd() {
        try {
            //if(writer.toString().endsWith(",")) {
                writer.write("\b");
            //}
            writer.write(']');
        } catch (IOException e) {
            e.printStackTrace();
        }//– если предыдущий символ – запятая, удаляет его
    }

    public void writeString(String string) {
        try {
            writer.write("\"" + string + "\"");
        } catch (IOException e) {
            e.printStackTrace();
        }//– данный метод принимает стрингу, при необходимости ескейпит внутри символы, добавляет с обеих сторон «“»
    }

    public void writeNumber(Number n) {
        try {
            switch (n.getClass().getSimpleName()){
        	case ("Integer"):
        	    writer.write(n.toString());
        		break;
        	case ("Short"):
        	    writer.write(n.toString());
        		break;
        	case ("Byte"):
        	    writer.write(n.toString());
        		break;
        	case ("Long"):
        	    writer.write(n.toString());
        		break;
        	case ("Float"):
        	    writer.write(n.toString());
        		break;
        	case ("Double"):
        	    writer.write(n.toString());
        		break;
        	}
            
        } catch (IOException e) {
            e.printStackTrace();
        }// – записывает в низ лежащий поток число
    }

    public void writeSeparator() {
        try {
            writer.write(",");
        } catch (IOException e) {
            e.printStackTrace();
        }// – добавляет запятую
    }

    public void writePropertySeparator() {
        try {
            writer.write(':');
        } catch (IOException e) {
            e.printStackTrace();
        }//– добавляет двоеточие «:»
    }

    public void writeBoolean(Boolean bool) {
        try {
            if (bool)
        	writer.write("true");
            else
        	writer.write("false");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeNull() {
        try {
            writer.write("null");
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
