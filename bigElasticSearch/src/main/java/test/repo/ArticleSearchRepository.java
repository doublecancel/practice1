package test.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import test.entity.Article;

/**
 * Created by Administrator on 2017/11/13.
 * ArticleSearchRepository
 * F:\github\practice\bigElasticSearch\src\main\java\test\repo\ArticleSearchRepository.java
 * test.repo.ArticleSearchRepository
 * test.repo.ArticleSearchRepository
 *
 */
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {
}
