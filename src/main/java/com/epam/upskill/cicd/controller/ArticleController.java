package com.epam.upskill.cicd.controller;

import com.epam.upskill.cicd.model.Article;
import com.epam.upskill.cicd.model.ArticleDTO;
import com.epam.upskill.cicd.service.impl.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @description: TODO
 * @date: 20 October 2023 $
 * @time: 6:54 PM 33 $
 * @author: Qudratjon Komilov
 */
@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/")
    public ResponseEntity<ArticleDTO> createArticle(@RequestBody Article article) {
        return ResponseEntity.ok(articleService.createArticle(article));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.getArticleById(id)); // This handles Optional appropriately
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateArticle( @RequestBody Article article) {
        return ResponseEntity.ok(articleService.updateArticle(article));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.ok().build(); // This can be changed based on how you want to communicate success
    }
}
