package build.dream.common.utils;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.util.List;
import java.util.Map;

public class ElasticsearchUtils {
    private static TransportClient transportClient;

    public static TransportClient obtainTransportClient() {
        if (transportClient == null) {
            transportClient = ApplicationHandler.getBean(TransportClient.class);
        }
        return transportClient;
    }

    public static IndexResponse index(String index, String type, BasicDomain domain) {
        return index(index, type, domain, Constants.DEFAULT_DATE_PATTERN);
    }

    public static IndexResponse index(String index, String type, BasicDomain domain, String datePattern) {
        Map<String, Object> map = JacksonUtils.readValueAsMap(JacksonUtils.writeValueAsString(domain, datePattern), String.class, Object.class);
        XContentBuilder contentBuilder = buildXContentBuilder(map);
        IndexResponse indexResponse = obtainTransportClient().prepareIndex(index, type, domain.getId().toString()).setSource(contentBuilder).get();
        return indexResponse;
    }

    public static void indexAll(String index, String type, List<? extends BasicDomain> domains) {
        for (BasicDomain domain : domains) {
            index(index, type, domain);
        }
    }

    public static XContentBuilder buildXContentBuilder(Map<String, Object> map) {
        try {
            XContentBuilder contentBuilder = XContentFactory.jsonBuilder().startObject();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                contentBuilder.field(entry.getKey(), entry.getValue());
            }
            contentBuilder.endObject();
            return contentBuilder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DeleteResponse delete(String index, String type, String id) {
        return obtainTransportClient().prepareDelete(index, type, id).get();
    }
}
