package serializer;

import org.junit.jupiter.api.Test;
import writer.JsonWriter;

import java.io.*;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

class JsonSerializerTest {
    JsonSerializer serializer = new JsonSerializer();

    @Test
    void isIndent() {
        serializer.isIndent();
    }

    @Test
    void setIndent() {
        serializer.setIndent(true);
    }

    @Test
    void serialize() {
        serializer.serialize(105);
    }

    @Test
    void serialize1() {
        try {
            serializer.serialize(150, new FileOutputStream("File.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void serialize2() {
        try {
            serializer.serialize(150, new FileOutputStream("File.txt"), Charset.forName("UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void serialize3() {
        try {
            serializer.serialize(15, new FileWriter("File.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void serialize4() {
        try {
            serializer.serialize(150, new JsonWriter(new FileWriter("File.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getMapper() {
        serializer.getMapper(Integer.class);
    }

}