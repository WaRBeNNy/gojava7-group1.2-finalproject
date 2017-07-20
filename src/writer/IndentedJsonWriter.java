package writer;

import java.io.Writer;

public class IndentedJsonWriter extends JsonWriter{
    int indentSize;
    int currenLevel;

    public IndentedJsonWriter(Writer writer) {
        super(writer);
    }
}
