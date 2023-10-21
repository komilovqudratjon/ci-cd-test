package com.epam.upskill.cicd.component;

import com.epam.upskill.cicd.model.Article;
import com.epam.upskill.cicd.repository.ArticleRepository;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @className: DataLoader  $
 * @description: TODO
 * @date: 21 October 2023 $
 * @time: 4:34 PM 55 $
 * @author: Qudratjon Komilov
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final ArticleRepository articleRepository;
    public final Lorem lorem = LoremIpsum.getInstance();

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading data...");

        for (long i = 0; i < 100; i++) {
            articleRepository.save(new Article( i, lorem.getTitle(10), lorem.getParagraphs(4, 7)));
        }

        log.info("...data loaded");

    }
}
