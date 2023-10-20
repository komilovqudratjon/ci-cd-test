package com.epam.upskill.cicd.service;


import com.epam.upskill.cicd.exception.EntityNotFoundException;
import com.epam.upskill.cicd.model.Article;
import com.epam.upskill.cicd.model.ArticleDTO;
import com.epam.upskill.cicd.model.ArticleDTOMapper;
import com.epam.upskill.cicd.repository.ArticleRepository;
import com.epam.upskill.cicd.service.impl.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @description: TODO
 * @date: 20 October 2023 $
 * @time: 6:54 PM 33 $
 * @author: Qudratjon Komilov
 */
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleDTOMapper articleDTOMapper;

    @Override
    public ArticleDTO createArticle(Article article) {
        return articleDTOMapper.apply(articleRepository.save(article));
    }

    @Override
    public ArticleDTO getArticleById(Long id) {
        return articleDTOMapper.apply(articleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("this article does not exist")));
    }

    @Override
    public List<ArticleDTO> getAllArticles() {
        return articleRepository.findAll().stream().map(articleDTOMapper).toList();
    }


    @Override
    public ArticleDTO updateArticle(Article article) {
        // Here, you should add logic to check if the article exists, typically using findById first.
        return articleDTOMapper.apply(articleRepository.save(article));
    }

    @Override
    public void deleteArticle(Long id) {
        // Consider checking if the article exists before deleting, to handle exceptions accordingly.
        articleRepository.deleteById(id);
    }
}
