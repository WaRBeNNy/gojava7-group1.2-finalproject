package writer;

public class JsonWriter {
   public void writeObjectBegin() {

   }

    public void writeObjectEnd() {
       //– если предыдущий символ – запятая, удаляет его
    }

    public void writeArrayBegin() {

    }

    public void writeArrayEnd() {
      //– если предыдущий символ – запятая, удаляет его
    }

    public void writeString(String string) {
       //– данный метод принимает стрингу, при необходимости ескейпит внутри символы, добавляет с обеих сторон «“»
    }

    public void writeNumber(Number n) {
     // – записывает в низ лежащий поток число
    }

    public void writeSeparator() {
       // – добавляет запятую
    }

    public void writePropertySeparator() {
       //– добавляет двоеточие «:»
    }

    public void writeBoolean() {

    }

    public void writeNull() {

    }
    public void flush() {

    }
}
