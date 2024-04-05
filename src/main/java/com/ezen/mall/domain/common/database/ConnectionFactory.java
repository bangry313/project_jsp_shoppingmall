package com.ezen.mall.domain.common.database;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Connection 생성 및 반환 하는 팩토리 클래스
 * 싱글톤 디자인 패턴 적용
 * DB 연결 정보를 properties 설정 파일로 분리
 */
public class ConnectionFactory {
    private String driver;
    private String url;
    private String username ;
    private String password;

    private static ConnectionFactory instance = new ConnectionFactory();

    private DataSource dataSource;

    private ConnectionFactory(){
        loadProperties();
        createDataSource();
    }

    private void loadProperties() {
        Properties prop = new Properties();
        InputStream in = getClass().getResourceAsStream("/config/db.properties");
        try {
            prop.load(in);
            this.driver = prop.getProperty("database.driver");
            this.url = prop.getProperty("database.url");
            this.username = prop.getProperty("database.username");
            this.password = prop.getProperty("database.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createDataSource(){
        // DB 연결 설정 정보
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // 커넥션풀 설정 정보
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(10);
        dataSource.setMaxIdle(5);
        dataSource.setMaxWaitMillis(2000);
        this.dataSource = dataSource;
    }


    public static ConnectionFactory getInstance(){
        return  instance;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void main(String[] args) throws SQLException {
        // DAO 클래스 영역이라 가정
        ConnectionFactory factory = ConnectionFactory.getInstance();
        Connection con = factory.getConnection();
        System.out.println(con);

    }

}
