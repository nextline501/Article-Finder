package com.grupp3.article_finder.Entities;

import javax.persistence.Entity;

// Osäker på om den ska finnas - tror att vi ska ha trots ingen databas-koppling

@Entity
public class SearchText{

    private String searchText;
    private String tokentree;

    // Constructor

    public SearchText() {

    }

    // Getters and setters

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getTokentree() {
        return tokentree;
    }

    public void setTokentree(String tokentree) {
        this.tokentree = tokentree;
    }

    // ToString

    @Override
    public String toString() {
        return "Text{" +
                "searchText='" + searchText + '\'' +
                ", tokentree='" + tokentree + '\'' +
                '}';
    }
}
