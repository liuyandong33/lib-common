package build.dream.common.utils;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ElasticsearchUtils {
    private static RestHighLevelClient restHighLevelClient;

    public static RestHighLevelClient obtainRestHighLevelClient() {
        if (Objects.isNull(restHighLevelClient)) {
            restHighLevelClient = ApplicationHandler.getBean(RestHighLevelClient.class);
        }
        return restHighLevelClient;
    }

    public static IndexResponse index(String index, BasicDomain domain) throws IOException {
        return index(index, domain, Constants.DEFAULT_DATE_PATTERN);
    }

    public static IndexResponse index(String index, BasicDomain domain, String datePattern) throws IOException {
        IndexRequest indexRequest = new IndexRequest(index);
        indexRequest.source(JacksonUtils.writeValueAsString(domain, datePattern), XContentType.JSON);
        indexRequest.id(domain.getId().toString());
        IndexResponse indexResponse = obtainRestHighLevelClient().index(indexRequest, RequestOptions.DEFAULT);
        return indexResponse;
    }

    public static void indexAll(String index, List<? extends BasicDomain> domains) throws IOException {
        for (BasicDomain domain : domains) {
            index(index, domain, Constants.DEFAULT_DATE_PATTERN);
        }
    }

    public static DeleteResponse delete(String index, String id) throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(index);
        deleteRequest.id(id);
        return obtainRestHighLevelClient().delete(deleteRequest, RequestOptions.DEFAULT);
    }
}
