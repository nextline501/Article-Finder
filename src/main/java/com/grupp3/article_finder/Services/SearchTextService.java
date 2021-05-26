package com.grupp3.article_finder.Services;

import com.grupp3.article_finder.Entities.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchTextService {


    public List<Article> matchSearchText(String searchText) {
        // Collect all article from database
        // send the string and the article-list to sanic via REST template
        // get back the list of matching articles
        // return this list instead of null

        return null;
    }
}
