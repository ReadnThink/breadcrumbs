package com.example.notionbreadcrumbs.dao;

import com.example.notionbreadcrumbs.domain.Page;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class TestDaoTest {
    @Test
    void addAndGet() throws SQLException, ClassNotFoundException {
        TestDao testDao = new TestDao();
        Page page = new Page();
        testDao.add(page);
    }
}