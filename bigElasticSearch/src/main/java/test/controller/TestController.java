package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import test.entity.Article;
import test.repo.ArticleSearchRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ArticleSearchRepository repository;

    @RequestMapping("/all")
    @ResponseBody
    public List<Article> all() throws Exception {
        Iterable<Article> data = repository.findAll();
        List<Article> ds = new ArrayList<>();
        for (Article d : data) {
            ds.add(d);
        }
        return ds;
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        long time = System.currentTimeMillis();
        Article article = new Article();
        article.setId(time);
        article.setTitle("TEST:" + time);
        article.setContent("Content:" + time);
        article.setPostTime(time);
        this.repository.save(article);
        return "OK";
    }
}
