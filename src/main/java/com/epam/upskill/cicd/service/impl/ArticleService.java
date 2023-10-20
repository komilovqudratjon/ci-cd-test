package com.epam.upskill.cicd.service.impl;


import com.epam.upskill.cicd.model.Article;
import com.epam.upskill.cicd.model.ArticleDTO;

import java.util.List;
import java.util.Optional;
/**
 * @description: TODO
 * @date: 20 October 2023 $
 * @time: 6:54 PM 33 $
 * @author: Qudratjon Komilov
 */
public interface ArticleService {
    ArticleDTO createArticle(Article article);

    ArticleDTO getArticleById(Long id);

    List<ArticleDTO> getAllArticles();

    ArticleDTO updateArticle(Article article);

    void deleteArticle(Long id);
}