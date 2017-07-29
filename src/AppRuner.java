import serializer.JsonSerializer;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class AppRuner {
    public static void main(String[] args) throws IOException {
        JsonSerializer jsonSerializer = JsonSerializer.getInstance();
        Writer writer = new StringWriter();
        String result;

        String test = "Some string";
        int n = 1000;
        Double d = 250.47;
        Developer developer = new Developer("Ivan", 63, 500.00);

        result = jsonSerializer.serialize(test);
        System.out.println(result);

        result = jsonSerializer.serialize(n);
        System.out.println(result);

        result = jsonSerializer.serialize(d);
        System.out.println(result);

        result = jsonSerializer.serialize(developer);
        System.out.println(result);


    }
}
