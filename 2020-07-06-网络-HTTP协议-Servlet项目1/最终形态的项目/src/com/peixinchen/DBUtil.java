package com.peixinchen;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 懒汉单例 - Double Check
 * URL 的理解
 */
public class DBUtil {
    private static volatile DataSource dataSource = null;

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = initDataSource();
                }
            }
        }

        return dataSource.getConnection();
    }

    private static DataSource initDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/hjb2_0705?useSSL=false&characterEncoding=utf8");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");

        return mysqlDataSource;
    }
}
