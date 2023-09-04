package com.example.notionbreadcrumbs.repository;

import com.example.notionbreadcrumbs.dao.DatabaseConnector;
import com.example.notionbreadcrumbs.domain.Page;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class PageRepositoryImpl implements PageRepository {

    private final DatabaseConnector databaseConnector;

    public PageRepositoryImpl(final DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public Page getPageById(final Long pageId) throws ClassNotFoundException, SQLException {
        Connection connection = connection = databaseConnector.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM page WHERE id = ?");
        preparedStatement.setLong(1, pageId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Page page = new Page();
            page.setId(resultSet.getLong("id"));
            page.setTitle(resultSet.getString("title"));
            page.setContent(resultSet.getString("content"));
            page.setParentPageId(resultSet.getLong("parent_page_id"));
            return page;
        }

        return null;
    }
}
