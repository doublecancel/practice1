package test.repo;

import com.google.common.base.Joiner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import test.App;
import test.entity.Article;

import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/11/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ArticleSearchRepositoryTest {

    @Autowired
    ArticleSearchRepository repository;

    @Autowired
    ElasticsearchTemplate template;


    @Before
    public void setUp() throws Exception {
    }

    /**
     * 测试添加
     */
    @Test
    public void testAdd(){

        IntStream.range(1, 100).forEach(a -> {
            Article article = new Article();
            article.setId(System.currentTimeMillis());
            article.setContent("文章" + a);
            article.setPostTime(System.currentTimeMillis());
            article.setTitle("标题" + a);
            repository.save(article);
        });
        Assert.assertTrue(true);
    }

    @Test
    public void testQuery(){
        System.out.println("----------------------------------------------------------");
//        Iterable<Article> ls = repository.findAll();//查询所有
//        Iterable<Article> ls = repository.findAll(Lists.newArrayList(1510565729530L, 1510566144174L, 1510566145580L));//根据id查询
        Iterable<Article> ls = repository.findAll(new PageRequest(2, 20));//分页显示
//        repository.search()
        System.out.println(Joiner.on("\n").join(ls));
        Assert.assertTrue(true);
    }




    @Test
    public void queryTerm(){


        boolean flag = template.createIndex("abc");
        System.out.println(flag);

    }


    @After
    public void tearDown() throws Exception {





    }

}