package build.dream.common.utils;

import build.dream.common.constants.Constants;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;

public class DateJsonValueProcessor implements JsonValueProcessor {
    private SimpleDateFormat simpleDateFormat = null;

    public DateJsonValueProcessor() {
        this(Constants.DEFAULT_DATE_PATTERN);
    }

    public DateJsonValueProcessor(String datePattern) {
        simpleDateFormat = new SimpleDateFormat(datePattern);
    }

    @Override
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return process(value);
    }

    @Override
    public Object processObjectValue(String json, Object value, JsonConfig jsonConfig) {
        return process(value);
    }

    private Object process(Object value) {
        return simpleDateFormat.format(value);
    }
}
