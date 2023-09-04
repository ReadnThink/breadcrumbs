package com.example.notionbreadcrumbs.dao;

import com.example.notionbreadcrumbs.domain.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
class TestDaoTest {
    @Autowired
    DatabaseConnector databaseConnector;
    @Test
    void addAndGet() throws SQLException, ClassNotFoundException {
        TestDao testDao = new TestDao(databaseConnector);
        Page page = new Page();
        testDao.add(page);
    }
}