package com.example.notionbreadcrumbs;

import com.example.notionbreadcrumbs.domain.PageInfo;
import com.example.notionbreadcrumbs.service.PageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@Slf4j
@RestController
public class PageController {

    private final PageService pageService;


    public PageController(final PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/get/{id}")
    public PageInfo getList(@PathVariable Long id) throws SQLException, ClassNotFoundException {
        return pageService.getPageInfo(id);
    }
}
