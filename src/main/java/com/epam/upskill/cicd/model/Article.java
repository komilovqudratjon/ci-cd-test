package com.epam.upskill.cicd.model;

import lombok.*;

import javax.persistence.*;

/**
 * @description: TODO
 * @date: 20 October 2023 $
 * @time: 6:54 PM 33 $
 * @author: Qudratjon Komilov
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
}
