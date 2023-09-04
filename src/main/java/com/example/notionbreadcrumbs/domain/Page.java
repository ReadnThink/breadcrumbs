package com.example.notionbreadcrumbs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    private Long id;
    private String title;
    private String content;
    private Long parentPageId;
}
