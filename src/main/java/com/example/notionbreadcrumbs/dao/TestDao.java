package com.example.notionbreadcrumbs.dao;


import com.example.notionbreadcrumbs.domain.Page;

import java.sql.SQLException;

public class TestDao {

    private final DatabaseConnector databaseConnector;

    public TestDao(final DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public void add(Page page) throws ClassNotFoundException, SQLException {
        databaseConnector.getConnection();
    }
}
