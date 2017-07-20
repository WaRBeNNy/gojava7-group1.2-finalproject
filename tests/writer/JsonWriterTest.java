package writer;

import org.junit.jupiter.api.Test;

import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest {
    JsonWriter writer = new JsonWriter(new StringWriter());

    @Test
    void writeObjectBegin() {
        writer.writeObjectBegin();
    }

    @Test
    void writeObjectEnd() {
        writer.writeObjectEnd();
    }

    @Test
    void writeArrayBegin() {
        writer.writeArrayBegin();
    }

    @Test
    void writeArrayEnd() {
        writer.writeArrayEnd();
    }

    @Test
    void writeString() {
        writer.writeString("Какая-то строка");
    }

    @Test
    void writeNumber() {
        writer.writeNumber(54.22);
    }

    @Test
    void writeSeparator() {
        writer.writeSeparator();
    }

    @Test
    void writePropertySeparator() {
        writer.writePropertySeparator();
    }

    @Test
    void writeBoolean() {
        writer.writeBoolean();
    }

    @Test
    void writeNull() {
        writer.writeNull();
    }

    @Test
    void flush() {
        writer.flush();
    }

}