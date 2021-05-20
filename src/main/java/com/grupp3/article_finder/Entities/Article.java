package com.grupp3.article_finder.Entities;

import javax.persistence.*;

@Entity
@Table( name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private String tokenTree;
    private String path;

    public Article() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTokenTree() {
        return tokenTree;
    }

    public void setTokenTree(String tokenTree) {
        this.tokenTree = tokenTree;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", tokenTree='" + tokenTree + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
