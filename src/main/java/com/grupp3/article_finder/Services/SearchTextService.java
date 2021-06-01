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

    public List<Article> getAllArticles(){
        //System.out.println("Database stuff: " + (List<Article>)articleRepository.findAll());
        return (List<Article>) articleRepository.findAll();
    }

    public Map sendDataToSanic(String vueText) {

        Map map = new HashMap<>();
        System.out.println("vue text proof: " + vueText);
        map.put("searchText", vueText);
        map.put("dataBaseArticles", getAllArticles());
        map.put("typeOfSearch", 1);

        Map test = restTemplate.postForObject(url, map, Map.class);
        System.out.println("Tessssst: " + test);
        return test;
    }

    public Map matchSearchText(String searchText) {

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

        Map processedData = sendDataToSanic(searchText);

        return processedData;
    }

    public Map sendDataToSanicWithArticle(String myId) {
        // Change later !!!
        int id = 1;
        System.out.println("vue text proof: " + id);

        List<Article> articleList = getAllArticles();
        String tokenTree = "Not changed";

        for (int i = 0; i < articleList.size(); i++) {
            if(articleList.get(i).getId() == id){
                System.out.println("Inside loop");
                tokenTree = articleList.get(i).getTokentree();
            }
        }

        Map map = new HashMap<>();
//        System.out.println("Tokentree: " + tokenTree);
        map.put("searchText", tokenTree);
        map.put("dataBaseArticles", getAllArticles());
        map.put("typeOfSearch", 2);

        Map test = restTemplate.postForObject(url, map, Map.class);
        System.out.println("Tessssst: " + test);
        return test;
    }

    public Map matchSimilarArticles(String id) {
        Map processedData = sendDataToSanicWithArticle(id);
        // Change later !!!
        return null;
    }
}
