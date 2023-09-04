package com.example.notionbreadcrumbs.service;

import com.example.notionbreadcrumbs.domain.Breadcrumb;
import com.example.notionbreadcrumbs.domain.Page;
import com.example.notionbreadcrumbs.domain.PageInfo;
import com.example.notionbreadcrumbs.repository.PageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PageService {

    private PageRepository pageRepository;

    public PageService(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    public PageInfo getPageInfo(Long pageId) throws SQLException, ClassNotFoundException {
        Page page = pageRepository.getPageById(pageId);

        if (page == null) {
            return null;
        }

        List<Breadcrumb> breadcrumbs = generateBreadcrumbs(page);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < breadcrumbs.size(); i++) {
            sb.append(breadcrumbs.get(i).getPageId());
            if (i != breadcrumbs.size()-1) sb.append(" -> ");
        }


        return new PageInfo(page.getId(), page.getTitle(), page.getParentPageId(), sb.toString());
    }

    private List<Breadcrumb> generateBreadcrumbs(Page page) throws SQLException, ClassNotFoundException {
        List<Breadcrumb> breadcrumbs = new ArrayList<>();

        while (page != null) {
            Breadcrumb breadcrumb = new Breadcrumb(page.getId(), page.getTitle());
            // 같은 페이지 없다고 가정
            if (!breadcrumbs.isEmpty() && breadcrumbs.get(0).getPageId() == page.getId()) {
                break;
            }
            breadcrumbs.add(0, breadcrumb); // 리스트의 처음에 추가하여 순서를 뒤집음
            page = pageRepository.getPageById(page.getParentPageId());
        }

        return breadcrumbs;
    }
}
