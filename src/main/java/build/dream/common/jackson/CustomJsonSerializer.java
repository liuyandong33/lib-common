package build.dream.common.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigInteger;

public class CustomJsonSerializer extends JsonSerializer<BigInteger> {
    private static final BigInteger JS_LONG_MAX_VALUE = BigInteger.valueOf(999999999999999L);

    @Override
    public void serialize(BigInteger value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value.compareTo(JS_LONG_MAX_VALUE) > 0) {
            gen.writeString(value.toString());
            return;
        }

        gen.writeNumber(value);
    }

    @Override
    public Class<BigInteger> handledType() {
        return BigInteger.class;
    }
}
