package com.grupp3.article_finder.Entities;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private String tokentree;
    private String path;
    private String title;
    private String summary;

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

    public String getTokentree() {
        return tokentree;
    }

    public void setTokentree(String tokentree) {
        this.tokentree = tokentree;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", tokentree='" + tokentree + '\'' +
                ", path='" + path + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
