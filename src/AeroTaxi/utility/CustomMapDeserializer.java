package AeroTaxi.utility;

import AeroTaxi.core.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.util.HashMap;

public class CustomMapDeserializer extends StdDeserializer<HashMap<User,Integer>> {

    public CustomMapDeserializer()
    {
        this((JavaType) null);
    }

    public CustomMapDeserializer(Class<?> vc) {
        super(vc);
    }

    public CustomMapDeserializer(JavaType valueType) {
        super(valueType);
    }

    public CustomMapDeserializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public HashMap<User, Integer> deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        JsonDeserializer<Object> deserializer = dc.findRootValueDeserializer(dc.constructType(HashMap.class));
        HashMap<User,Integer> map = (HashMap<User,Integer>) deserializer.deserialize(jp,dc);
        return map;
    }
}
