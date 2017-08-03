import serializer.JsonSerializer;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;

public class AppRuner {
    public static void main(String[] args) throws IOException {
        JsonSerializer jsonSerializer = JsonSerializer.getInstance();
        String result;

        Developer developer = new Developer("Ivan", 25, 1000.00, 500.00, true, true);
        Developer developer2 = new Developer("Petya", 27, 1000.00, 200.00, true, false);
        Developer developer3 = new Developer("?", 27, 1020.00, 200.00, false, true);

        Map<String, Developer> devlist = new TreeMap<>();

        devlist.put("Teamlead", developer);
        devlist.put("Slave1", developer2);
        devlist.put("Slave2", developer3);

        jsonSerializer.setIndent(true, 4);

        result = jsonSerializer.serialize(devlist);
        System.out.println(result);
    }
}
