package com.grupp3.article_finder.Controllers;

import com.grupp3.article_finder.Entities.Article;
import com.grupp3.article_finder.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/api/articles")
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @GetMapping("/api/articles/{id}")
    public Optional<Article> getArticleById(@PathVariable int id){
        return articleService.getArticleById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/articles")
    public Article addNewArticle(@RequestBody Article article){
        return articleService.addNewArticle(article);
    }

    @DeleteMapping("/api/articles/{id}")
    public void deleteArticleById(@PathVariable int id){
        articleService.deleteArticleById(id);
    }

    // Exist only for testing purposes with Postman, to be able to delete a created mock article,
    // not by auto increment id (don't work for testing), but by a mock title.
    @DeleteMapping("/api/articles/title/{title}")
    public void deleteArticleByTitle(@PathVariable String title){
        articleService.deleteArticleByTitle(title);
    }

    @PutMapping("/api/articles/{id}")
    public void updateArticleById(@PathVariable int id, @RequestBody Article article ){
        articleService.updateArticleById(id, article);
    }
}
