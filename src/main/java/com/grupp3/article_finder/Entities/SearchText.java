package com.grupp3.article_finder.Entities;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class SearchText {

    private String searchText;
    private List<Article> articles;

    public SearchText() {
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "DataToSanic{" +
                "searchText='" + searchText + '\'' +
                ", articles=" + articles +
                '}';
    }
}
