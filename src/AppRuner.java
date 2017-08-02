import serializer.JsonSerializer;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppRuner {
    public static void main(String[] args) throws IOException {
        JsonSerializer jsonSerializer = JsonSerializer.getInstance();
        String result;

        Developer developer = new Developer("Ivan", 25, 1000.00, 500.00, true, true);
        Developer developer2 = new Developer("Petya", 27, 1000.00, 200.00, true, false);
        List devlist = new ArrayList();
        devlist.add(developer);
        devlist.add(developer2);

        jsonSerializer.setIndent(true);

        result = jsonSerializer.serialize(devlist);
        System.out.println(result);
    }
}
