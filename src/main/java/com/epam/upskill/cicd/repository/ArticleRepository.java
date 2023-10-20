package com.epam.upskill.cicd.repository;

import com.epam.upskill.cicd.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @description: TODO
 * @date: 20 October 2023 $
 * @time: 6:54 PM 33 $
 * @author: Qudratjon Komilov
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
