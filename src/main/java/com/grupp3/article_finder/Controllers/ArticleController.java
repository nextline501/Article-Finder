package com.grupp3.article_finder.Controllers;

import com.grupp3.article_finder.Entities.Article;
import com.grupp3.article_finder.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/api/articles")
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }



}
