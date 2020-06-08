package AeroTaxi.utility;

import AeroTaxi.core.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Map;

public class CustomMapSerializer extends StdSerializer<Map<User,Integer>> {

    public CustomMapSerializer(Class<Map<User, Integer>> t) {
        super(t);
    }

    public CustomMapSerializer(StdSerializer<?> src) {
        super(src);
    }

    @Override
    public void serialize(Map<User, Integer> userIntegerMap, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString("");
    }
}
