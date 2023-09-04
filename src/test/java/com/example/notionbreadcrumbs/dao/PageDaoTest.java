package com.example.notionbreadcrumbs.dao;

import com.example.notionbreadcrumbs.domain.Page;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PageDaoTest {
    @Test
    void addAndGet() throws SQLException, ClassNotFoundException {
        PageDao pageDao = new PageDao();
        Page page = new Page();
        pageDao.add(page);
    }
}