package com.example.notionbreadcrumbs.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageInfo {
    private Long id;
    private String title;
    private List<Page> subPages;
    private Long parentId;
    private List<Breadcrumb> breadcrumbs;
    private String breadcrumbsString;

    public PageInfo() {
    }
    public PageInfo(final Long id, final String title, final List<Page> subPages, final List<Breadcrumb> breadcrumbs) {
        this.id = id;
        this.title = title;
        this.subPages = subPages;
        this.breadcrumbs = breadcrumbs;
    }

    public PageInfo(final Long id, final String title, final Long parentId, final List<Breadcrumb> breadcrumbs) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.breadcrumbs = breadcrumbs;
    }

    public PageInfo(final Long id, final String title, final Long parentId, final String breadcrumbs) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.breadcrumbsString = breadcrumbs;
    }


    @Override
    public String toString() {
        return "PageInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", parentId=" + parentId +
                ", breadcrumbs=" + breadcrumbs +
                '}';
    }
}
