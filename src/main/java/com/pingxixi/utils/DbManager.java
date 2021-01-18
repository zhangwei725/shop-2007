package com.pingxixi.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.cj.protocol.Resultset;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 */
public class DbManager {
    private static DataSource dataSource;
    public static final String PROPERTIES_NAME = "db.properties";
    static {
        Properties properties = new Properties();
        try {
            properties.load(DbManager.class.getClassLoader().getResourceAsStream(PROPERTIES_NAME));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(ResultSet rs, Connection connection, Statement statement) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static void close(Connection connection, Statement statement) throws SQLException {
        close(null, connection, statement);
    }

}
