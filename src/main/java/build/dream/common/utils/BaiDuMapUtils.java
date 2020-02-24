package build.dream.common.utils;

import build.dream.common.models.baidumap.GeoConvModel;
import build.dream.common.tuples.Tuple2;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaiDuMapUtils {
    public static List<Tuple2<Double, Double>> geoConv(GeoConvModel geoConvModel) {
        String coords = geoConvModel.getCoords();
        String ak = geoConvModel.getAk();
        String from = geoConvModel.getFrom();
        String to = geoConvModel.getTo();
        String sn = geoConvModel.getSn();
        String output = geoConvModel.getOutput();

        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("coords", coords);
        requestParameters.put("ak", ak);
        requestParameters.put("from", String.valueOf(from));
        requestParameters.put("to", String.valueOf(to));
        if (StringUtils.isNotBlank(sn)) {
            requestParameters.put("sn", sn);
        }

        if (StringUtils.isNotBlank(output)) {
            requestParameters.put("output", output);
        }

        String url = "http://api.map.baidu.com/geoconv/v1/";
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(OutUtils.doGet(url, requestParameters), String.class, Object.class);

        int status = MapUtils.getIntValue(resultMap, "status");
        ValidateUtils.isTrue(status == 0, MapUtils.getString(resultMap, "message"));

        List<Map<String, Object>> result = (List<Map<String, Object>>) resultMap.get("result");

        List<Tuple2<Double, Double>> tuple2s = new ArrayList<Tuple2<Double, Double>>();
        for (Map<String, Object> map : result) {
            tuple2s.add(TupleUtils.buildTuple2(MapUtils.getDoubleValue(map, "x"), MapUtils.getDoubleValue(map, "y")));
        }
        return tuple2s;
    }
}
