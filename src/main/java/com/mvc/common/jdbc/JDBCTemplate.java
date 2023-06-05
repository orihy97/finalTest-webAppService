package com.mvc.common.jdbc;

import com.mvc.common.config.ConfigLocation;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection() {

        Connection con = null;

        Properties prop = new Properties();
        try {
            /* WEB-INF 하위에 config 폴더에 DB 접속 정보를 넣음
             * 해당 경로를 모든 계층의 클래스에 사용하기 위해서는 모든 접속을 할 시 상수 필드로 저장하여 공유
             * → 이를 필터에서 처리
             * */
            prop.load(new FileReader(ConfigLocation.CONNECTION_CONFIG_LOCATION));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            Class.forName(driver);

            con = DriverManager.getConnection(url, prop);

            /* autoCommit 설정 변경 */
            con.setAutoCommit(false);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void close(Connection con) {
        try {
            if(con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt) {
        try {
            if(stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rset) {
        try {
            if(rset != null && !rset.isClosed()) {
                rset.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit(Connection con) {
        try {
            if(con != null && !con.isClosed()) {
                con.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback(Connection con) {
        try {
            if(con != null && !con.isClosed()) {
                con.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

