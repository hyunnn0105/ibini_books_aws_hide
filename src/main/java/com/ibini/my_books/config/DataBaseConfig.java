package com.ibini.my_books.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

// DB 관련 설정 클래스
@Configuration
@ComponentScan(basePackages = "com.ibini.my_books")
@PropertySource("classpath:db_info.properties")
@Getter
public class DataBaseConfig {

    // value -> spring pramework
    @Value("${aws.rds_user_name}")
    private String username;

    @Value("${aws.rds_password}")
    private String password;

    @Value("${aws.rds_url}")
    private String url;

    // DB접속 정보 설정 (DataSource설정)
    @Bean
    public DataSource dataSource() {

        HikariConfig config = new HikariConfig();

        // 공용 설정
        config.setUsername(username);
        config.setPassword(password);
        config.setJdbcUrl(url);
        config.setDriverClassName("org.mariadb.jdbc.Driver");

        // 현정 노트북 설정
//        config.setUsername("root");
//        config.setPassword("mariadb1234");
//        config.setJdbcUrl("jdbc:mariadb://localhost:3306/ibini");
//        config.setDriverClassName("org.mariadb.jdbc.Driver");


        return new HikariDataSource(config);
    }
}
