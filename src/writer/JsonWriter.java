package writer;

import java.io.IOException;
import java.io.Writer;

public class JsonWriter {
   Writer writer;

    public JsonWriter(Writer writer) {
        this.writer = writer;
    }

    public void writeObjectBegin(){
        try {
            writer.append('{');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeObjectEnd(){
        try {
            writer.append('}');
        } catch (IOException e) {
            e.printStackTrace();
        }
        //– если предыдущий символ – запятая, удаляет его
    }

    public void writeArrayBegin() {
        try {
            writer.append('[');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeArrayEnd() {
        try {
            writer.append(']');
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
        	    writer.write(n.intValue());
        		break;
        	case ("Short"):
        	    writer.write(n.shortValue());
        		break;
        	case ("Byte"):
        	    writer.write(n.byteValue());
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
            writer.append(',');
        } catch (IOException e) {
            e.printStackTrace();
        }// – добавляет запятую
    }

    public void writePropertySeparator() {
        try {
            writer.append(':');
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
