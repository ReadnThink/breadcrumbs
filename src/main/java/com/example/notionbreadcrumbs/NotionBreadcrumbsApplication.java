package com.example.notionbreadcrumbs;

import com.example.notionbreadcrumbs.service.PageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class NotionBreadcrumbsApplication {

    public static void main(String[] args) {
        log.info("등장");
        SpringApplication.run(NotionBreadcrumbsApplication.class, args);
    }

}
