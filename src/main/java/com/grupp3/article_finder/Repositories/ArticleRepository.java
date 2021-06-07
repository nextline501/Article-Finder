package com.grupp3.article_finder.Repositories;

import com.grupp3.article_finder.Entities.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {

    @Transactional
    void deleteByTitleIgnoreCase(String title);
}
