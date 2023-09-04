package com.example.notionbreadcrumbs.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Breadcrumb {
    private Long pageId;
    private String title;

    public Breadcrumb() {
    }

    public Breadcrumb(final Long pageId, final String title) {
        this.pageId = pageId;
        this.title = title;
    }
}
