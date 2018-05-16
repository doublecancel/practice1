package test.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by Administrator on 2017/11/14.
 */
@Data
@Document(indexName = "article_index", type = "article", shards = 5, replicas = 1, indexStoreType = "fs", refreshInterval = "-1")
public class LogInfo {
}
