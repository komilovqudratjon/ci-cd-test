package com.epam.upskill.cicd.model;

import org.springframework.stereotype.Service;

import java.util.function.Function;
/**
 * @description: TODO
 * @date: 20 October 2023 $
 * @time: 6:54 PM 33 $
 * @author: Qudratjon Komilov
 */
@Service
public class ArticleDTOMapper implements Function<Article, ArticleDTO> {
    @Override
    public ArticleDTO apply(Article article) {
        return new ArticleDTO(article.getId(), article.getTitle(), article.getContent());
    }
}
