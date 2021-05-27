package com.grupp3.article_finder.Services;

import com.grupp3.article_finder.Entities.Article;
import com.grupp3.article_finder.Entities.SearchText;
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
    SearchText searchText;

    String url = "http://localhost:5000/nlpPost";

    RestTemplate restTemplate = new RestTemplate();
//    Map<String, String> map = new HashMap<>();
//    Map<String, List<Article>> map = new HashMap<>();
    Map<String, SearchText> map = new HashMap<>();

    public List<Article> getAllArticles(){
        System.out.println("Database stuff: " + (List<Article>)articleRepository.findAll());
        return (List<Article>) articleRepository.findAll();
    }

    // Alternative 1, not able to deconstruct string of articles in sanic
//    public Map sendDataToSanic(String vueText) {
//        System.out.println("vue text proof: " + vueText);
//        map.put("searchText", vueText);
//        map.put("dataBaseArticles", getAllArticles().toString());
//
//        for (Map.Entry<String, String> e : map.entrySet())
//            System.out.println(e.getKey() + " " + e.getValue());
//
//        Map test =  restTemplate.postForObject(url, map, Map.class);
//        System.out.println("Tessssst: " + test);
//        return test;
//    }

    // Alternative 3, works to get all article data in Sanic
//    public Map sendDataToSanic(String vueText) {
//        System.out.println("vue text proof: " + vueText);
////        map.put("searchText", vueText);
//        map.put("dataBaseArticles", getAllArticles());
//
//        Map test =  restTemplate.postForObject(url, map, Map.class);
//        System.out.println("Tessssst: " + test);
//        return test;
//    }

    // Alternative 4
    public void sendDataToSanic(String vueText) {
        System.out.println("vue text proof: " + vueText);

//        SearchText searchText = new SearchText();
        searchText.setSearchText(vueText);
        searchText.setArticles(getAllArticles());
//        map.put("dataToSanic", dataToSanic );

//        Map test =  restTemplate.postForObject(url, map, Map.class);
        restTemplate.postForObject(url, searchText, SearchText.class);

//        System.out.println("Tessssst: " + test);
//        return test;
    }

//    // Alternative 2, can access all data in sanic
//    public Map sendDataToSanic(String vueText) {
//        System.out.println("vue text proof: " + vueText);
//        List<Article> list = getAllArticles();
//        Map<String, String> map3 = new HashMap<>();
//        List<Map> maplist = new ArrayList<>();
//
//        for(Article article: list){
//            map3 = new HashMap<>();
//            map3.put("searchText", vueText);
//            map3.put("id",String.valueOf(article.getId()));
//            map3.put("text", article.getText());
//            map3.put("tokentree", article.getTokentree());
//            map3.put("path", article.getPath());
//            map3.put("title", article.getTitle());
//            map3.put("summary", article.getSummary());
//
//            maplist.add(map3);
//        }
//
//        Map test =  restTemplate.postForObject(url, maplist, Map.class);
//        System.out.println("Tessssst: " + test);
//        return test;
//    }

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
