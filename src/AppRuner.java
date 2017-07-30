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

        Boolean tr = true;
        Boolean fal = false;
        Developer dev = null;
        int[] num ={1, 2, 3, 4, 5};
        Developer developer = new Developer("Ivan", 63, 500.00);
        Developer developer2 = new Developer("Petya", 27, 1000.00);
        Developer[] devs = {developer, developer2};
        List devlist = new ArrayList();
        devlist.add(developer);
        devlist.add(developer2);
        Map<String, Developer> map = new HashMap<>();
        map.put("First", developer);
        map.put("Second", developer2);

        result = jsonSerializer.serialize(tr);
        System.out.println(result);

        result = jsonSerializer.serialize(fal);
        System.out.println(fal);

        result = jsonSerializer.serialize(dev);
        System.out.println(result);

        result = jsonSerializer.serialize(num);
        System.out.println(result);

        result = jsonSerializer.serialize(developer);
        System.out.println(result);

        result = jsonSerializer.serialize(devs);
        System.out.println(result);

        result = jsonSerializer.serialize(devlist);
        System.out.println(result);

        result = jsonSerializer.serialize(map);
        System.out.println(result);


    }
}
