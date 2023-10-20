package com.epam.upskill.cicd.service;

import com.epam.upskill.cicd.exception.EntityNotFoundException;
import com.epam.upskill.cicd.model.Article;
import com.epam.upskill.cicd.model.ArticleDTO;
import com.epam.upskill.cicd.model.ArticleDTOMapper;
import com.epam.upskill.cicd.repository.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * @className: ArticleServiceImplTest  $
 * @description: TODO
 * @date: 20 October 2023 $
 * @time: 6:57 PM 46 $
 * @author: Qudratjon Komilov
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ArticleServiceImplTest {
    @Autowired // this creates a mock implementation for the repository
     ArticleRepository articleRepository;

    @Autowired // this creates a mock implementation for the mapper
     ArticleDTOMapper articleDTOMapper;

    @InjectMocks // this will inject the mocks into the ArticleServiceImpl
    private ArticleServiceImpl articleService;

    private Article article;
    private ArticleDTO articleDTO;

    @BeforeEach
    void setUp() {
        article = new Article(1L, "title", "content");
        articleDTO = new ArticleDTO(1L, "title", "content");

    }


    @Test
    void createArticle() {
        when(articleRepository.save(any(Article.class))).thenReturn(article);

        ArticleDTO result = articleService.createArticle(article);

        assertEquals(articleDTO, result);
        verify(articleRepository).save(article);
    }

    @Test
    void getArticleById_found() {
        Long articleId = 1L; // or any specific test ID
        when(articleRepository.findById(articleId)).thenReturn(Optional.of(article));

        ArticleDTO result = articleService.getArticleById(articleId);

        assertEquals(articleDTO, result);
        verify(articleRepository).findById(articleId);
    }

    @Test
    void getArticleById_notFound() {
        Long articleId = 1L;
        when(articleRepository.findById(articleId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            articleService.getArticleById(articleId);
        });

        assertEquals("this article does not exist", exception.getMessage());
    }

    // Similar methods would be written for 'getAllArticles', 'updateArticle', and 'deleteArticle'.

}