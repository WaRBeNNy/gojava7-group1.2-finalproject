import serializer.JsonSerializer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class AppRuner {
    public static void main(String[] args) throws IOException {
        JsonSerializer jsonSerializer = new JsonSerializer();
        Writer writer = new FileWriter("File.txt");

        jsonSerializer.serialize("Здесь был я!", writer);
    }
}
