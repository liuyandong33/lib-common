package build.dream.common.utils;

import build.dream.common.constants.Constants;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyandong on 2017/3/23.
 */
public class GsonUtils {
    private static Gson instantiateGson(String datePattern, boolean serializeNulls) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(datePattern);
        gsonBuilder.disableHtmlEscaping();
        if (serializeNulls) {
            gsonBuilder.serializeNulls();
        }
        return gsonBuilder.create();
    }

    public static <T> T jsonToObject(String jsonString, Class<T> clazz, String datePattern) {
        return instantiateGson(datePattern, true).fromJson(jsonString, clazz);
    }

    public static <T> T jsonToObject(String jsonString, Class<T> clazz) {
        return jsonToObject(jsonString, clazz, Constants.DEFAULT_DATE_PATTERN);
    }

    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz, String datePattern) {
        Gson gson = instantiateGson(datePattern, true);
        Type type = new TypeToken<ArrayList<JsonObject>>() {
        }.getType();
        List<JsonObject> jsonObjects = gson.fromJson(jsonString, type);
        List<T> list = new ArrayList<T>();
        for (JsonObject jsonObject : jsonObjects) {
            list.add(gson.fromJson(jsonObject, clazz));
        }
        return list;
    }

    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        return jsonToList(jsonString, clazz, Constants.DEFAULT_DATE_PATTERN);
    }

    public static String toJson(Object object) {
        return instantiateGson(Constants.DEFAULT_DATE_PATTERN, true).toJson(object);
    }

    public static String toJson(Object object, String datePattern) {
        return instantiateGson(datePattern, true).toJson(object);
    }

    public static String toJson(Object object, boolean serializeNulls) {
        return instantiateGson(Constants.DEFAULT_DATE_PATTERN, serializeNulls).toJson(object);
    }

    public static String toJson(Object object, String datePattern, boolean serializeNulls) {
        return instantiateGson(datePattern, serializeNulls).toJson(object);
    }

    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        return instantiateGson(Constants.DEFAULT_DATE_PATTERN, true).fromJson(jsonString, clazz);
    }

    public static <T> T fromJson(String jsonString, Class<T> clazz, String datePattern) {
        return instantiateGson(datePattern, true).fromJson(jsonString, clazz);
    }

    public static <T> T fromJson(JsonElement jsonElement, Class<T> clazz) {
        return instantiateGson(Constants.DEFAULT_DATE_PATTERN, true).fromJson(jsonElement, clazz);
    }

    public static <T> T fromJson(JsonElement jsonElement, Class<T> clazz, String datePattern) {
        return instantiateGson(datePattern, true).fromJson(jsonElement, clazz);
    }

    public static <T> T fromJson(JSONObject jsonObject, Class<T> clazz) {
        return instantiateGson(Constants.DEFAULT_DATE_PATTERN, true).fromJson(jsonObject.toString(), clazz);
    }

    public static <T> T fromJson(JSONObject jsonObject, Class<T> clazz, String datePattern) {
        return instantiateGson(datePattern, true).fromJson(jsonObject.toString(), clazz);
    }

    public static JsonObject parseJsonObject(String jsonString) {
        JsonParser jsonParser = new JsonParser();
        return jsonParser.parse(jsonString).getAsJsonObject();
    }

    public static JsonArray parseJsonArray(String jsonString) {
        JsonParser jsonParser = new JsonParser();
        return jsonParser.parse(jsonString).getAsJsonArray();
    }
}
