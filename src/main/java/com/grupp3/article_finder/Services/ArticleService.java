package com.grupp3.article_finder.Services;

import com.grupp3.article_finder.Entities.Article;
import com.grupp3.article_finder.Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    String url = "http://localhost:5000/articlePost";
    RestTemplate restTemplate = new RestTemplate();

    public List<Article> getAllArticles() {
        return (List<Article>) articleRepository.findAll();
    }

    public Optional<Article> getArticleById(int id) {
        return articleRepository.findById(id);
    }

    public Article addNewArticle(Article article) {
        Article article_ = restTemplate.postForObject(url, article, Article.class);
        return articleRepository.save(article_);
    }

    public void deleteArticleById(int id) {
        articleRepository.deleteById(id);
    }

    public void deleteArticleByTitle(String title) {
        articleRepository.deleteByTitleIgnoreCase(title);
    }

    public void updateArticleById(int id, Article article) {
        if(articleRepository.existsById(id)){
            article.setId(id);
            articleRepository.save(article);
        }
    }
}
