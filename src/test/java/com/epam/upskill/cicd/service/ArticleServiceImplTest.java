package com.epam.upskill.cicd.service;

import com.epam.upskill.cicd.exception.EntityNotFoundException;
import com.epam.upskill.cicd.model.Article;
import com.epam.upskill.cicd.model.ArticleDTO;
import com.epam.upskill.cicd.model.ArticleDTOMapper;
import com.epam.upskill.cicd.repository.ArticleRepository;
import com.epam.upskill.cicd.service.impl.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class) // Sets up Mockito, a popular mocking framework
public class ArticleServiceImplTest {

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private ArticleDTOMapper articleDTOMapper;

    @InjectMocks // Creates an instance of ArticleService and injects the mocks into it
    private ArticleServiceImpl articleService;

    private Article exampleArticle;
    private ArticleDTO exampleArticleDTO;

    @BeforeEach
    void setUp() {
        // Initialize your example Article and ArticleDTO with some dummy data
        exampleArticle = new Article(1L, "Example title", "Example content");
        exampleArticle.setId(1L);
        // ... other properties ...


        exampleArticleDTO = new ArticleDTO(1L, "Example title 1", "Example content 1");


        // Assuming your ArticleDTOMapper is a functional interface, you might need to define its behavior
        lenient().when(articleDTOMapper.apply(any(Article.class))).thenReturn(exampleArticleDTO);
        log.info("setUp() method called");
    }

    @Test
    void createArticle() {
        when(articleRepository.save(any(Article.class))).thenReturn(exampleArticle);

        ArticleDTO result = articleService.createArticle(exampleArticle);

        assertNotNull(result);
        // other assertions for the properties...
        verify(articleRepository).save(any(Article.class));
        log.info("createArticle() method called and test passed");
    }

    @Test
    void getArticleById_found() {
        when(articleRepository.findById(1L)).thenReturn(Optional.of(exampleArticle));

        ArticleDTO result = articleService.getArticleById(1L);

        assertNotNull(result);
        // other assertions for the properties...
        verify(articleRepository).findById(1L);
        log.info("getArticleById() method called and test passed");
    }

    @Test
    void getArticleById_notFound() {
        when(articleRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            articleService.getArticleById(1L);
        });

        verify(articleRepository).findById(1L);
        log.info("getArticleById() method called and test passed");
    }

    @Test
    void getAllArticles() {
        // Assuming ArticleRepository's findAll returns List<Article>
        when(articleRepository.findAll()).thenReturn(List.of(exampleArticle));

        List<ArticleDTO> result = articleService.getAllArticles();

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        // other assertions for the content of the result list...
        verify(articleRepository).findAll();
        log.info("getAllArticles() method called and test passed");
    }

    @Test
    void updateArticle() {
        // You should add more meaningful logic here related to how an article is updated
        when(articleRepository.save(any(Article.class))).thenReturn(exampleArticle);

        ArticleDTO result = articleService.updateArticle(exampleArticle);

        assertNotNull(result);
        // other assertions related to the update...
        verify(articleRepository).save(any(Article.class));
        log.info("updateArticle() method called and test passed");
    }

    @Test
    void deleteArticle() {
        // Here you can simulate the behavior of the delete operation. For instance, you don't need to return anything, but you might want to verify the interaction.
        doNothing().when(articleRepository).deleteById(1L);

        articleService.deleteArticle(1L);

        verify(articleRepository).deleteById(1L);
        log.info("deleteArticle() method called and test passed");
    }
}
