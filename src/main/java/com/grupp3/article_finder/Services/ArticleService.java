package com.grupp3.article_finder.Services;

import com.grupp3.article_finder.Entities.Article;
import com.grupp3.article_finder.Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;


    public List<Article> getAllArticles() {
        return (List<Article>) articleRepository.findAll();
    }
}
