package test.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldIndex.analyzed;
import static org.springframework.data.elasticsearch.annotations.FieldIndex.not_analyzed;
import static org.springframework.data.elasticsearch.annotations.FieldType.Integer;
import static org.springframework.data.elasticsearch.annotations.FieldType.String;

/**
 * Created by Administrator on 2017/11/13.
 */
@Data
@Document(indexName = "article_index", type = "article", shards = 5, replicas = 1, indexStoreType = "fs", refreshInterval = "-1")
public class Article {
    private static final long serialVersionUID = 551589397625941750L;
    @Id
    private Long id;
    private String title;
    private String content;
    private Long postTime;
    @MultiField(
            mainField = @Field(type = String, index = analyzed),
            otherFields = {
                    @InnerField(suffix = "untouched", type = String, store = true, index = not_analyzed),
                    @InnerField(suffix = "sort", type = String, store = true, indexAnalyzer = "keyword")
            }
    )
    private List<String> authors = new ArrayList<String>();

    @Field(type = Integer, store = true)
    private List<Integer> publishedYears = new ArrayList<Integer>();

    @Field(type = String, store = true)
    private Collection<String> tags = new ArrayList<String>();
}
