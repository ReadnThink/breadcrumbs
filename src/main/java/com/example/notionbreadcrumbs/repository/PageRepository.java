package com.example.notionbreadcrumbs.repository;

import com.example.notionbreadcrumbs.domain.Page;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface PageRepository {
    Page getPageById(Long pageId) throws ClassNotFoundException, SQLException;
}
