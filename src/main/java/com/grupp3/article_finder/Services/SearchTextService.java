package com.grupp3.article_finder.Services;

import com.grupp3.article_finder.Entities.Article;
import com.grupp3.article_finder.Repositories.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchTextService {

    @Autowired
    ArticleRepository articleRepository;

    String url = "http://localhost:5000/nlpPost";

    RestTemplate restTemplate = new RestTemplate();
    Map<String, String> map = new HashMap<>(); 
       
    public List<Article> getAllArticles(){
        System.out.println("Database stuff: " + (List<Article>)articleRepository.findAll());
        return (List<Article>) articleRepository.findAll();
    }
    /*
    public Map sendDataToSanic(String vueText) {
        System.out.println("vue text proof: " + vueText);

        map.put("searchText", vueText);
        map.put("dataBaseArticles", getAllArticles().toString());

        for (Map.Entry<String, String> e : map.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());

        return restTemplate.postForObject(url, map, Map.class);
    }
    */

    public String sendDataToSanic(String vueText){
        return restTemplate.postForObject(url, vueText, String.class);
        
    }

    public List<Article> matchSearchText(String searchText) {

        //Get string from vue
        //-> detta kan ske i SearchTextService.java 
        //  -> I SearchTextService:
        //  -> skickar in Sring som en parameter 
        //  -> hämtar data från data basen
        //  -> buntar ihop till en RestTemplate
        //  -> skickar RestTemplate som objekt till Sanic
        //      -> Sanic kör SpaCy Matching
        //      -> Sanic retunerar en lista med Artiklar till SearchTextService
        //  -> SearchTextService retunerar listan till SearchTextController
        
        //Detta är det sissta som ska ske, controllern skickar tillbaka listan till Vue. 

        sendDataToSanic(searchText);

        return null;
    }
}
