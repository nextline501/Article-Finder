package com.grupp3.article_finder.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/data")
    public void ceateArticle(@RequestBody String test){
        System.out.println(test);
        System.out.println("post ok");
    }
}
