package mapper;

import writer.JsonWriter;

public class BooleanMapper implements JsonMapper{
    @Override
    public void write(Object obj, JsonWriter writer) {
	
        writer.writeString("\"" + obj.getClass().getSimpleName() + "\"");
        writer.writePropertySeparator();
        writer.writeString(" \"");
	writer.writeBoolean((Boolean) obj);
        writer.writeString(" \"");
    }
}
