package build.dream.common.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CustomJsonSerializer extends JsonSerializer<Long> {
    private static final Long JS_LONG_MAX_VALUE = 999999999999999L;

    @Override
    public void serialize(Long value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (value > JS_LONG_MAX_VALUE) {
            jsonGenerator.writeString(value.toString());
            return;
        }

        jsonGenerator.writeNumber(value);
    }

    @Override
    public Class<Long> handledType() {
        return Long.class;
    }
}
