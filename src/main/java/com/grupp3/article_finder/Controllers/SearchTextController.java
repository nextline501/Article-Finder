package com.grupp3.article_finder.Controllers;

import com.grupp3.article_finder.Entities.Article;
import com.grupp3.article_finder.Services.SearchTextService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; 

import java.util.List;
import java.util.Map;

@RestController
public class SearchTextController {

    @Autowired
    SearchTextService searchTextService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/data")
    public Map matchSearchText(@RequestBody String searchText){
        System.out.println("Controll: " + searchText);
        return searchTextService.matchSearchText(searchText);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/read")
    public Map matchSimilarArticles(@RequestBody String id){
//        System.out.println("Controll: " + searchText);
        return searchTextService.matchSimilarArticles(id);
    }
}
