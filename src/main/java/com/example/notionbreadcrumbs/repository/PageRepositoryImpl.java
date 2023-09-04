package com.example.notionbreadcrumbs.repository;

import com.example.notionbreadcrumbs.dao.DatabaseConnector;
import com.example.notionbreadcrumbs.domain.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class PageRepositoryImpl implements PageRepository {

    @Value("${spring.datasource.url}")
    private String URL;
    @Value("${spring.datasource.username}")
    private String USERNAME;
    @Value("${spring.datasource.password}")
    private String PASSWORD;

    @Override
    public Page getPageById(final Long pageId) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
