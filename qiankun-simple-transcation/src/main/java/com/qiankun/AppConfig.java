package com.qiankun;

import com.mysql.cj.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Description:
 * @Date : 2023/12/18 8:53
 * @Auther : tiankun
 */
@Configuration
@ComponentScan("com.qiankun")
@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
public class AppConfig {

    @Bean
    public JdbcTemplate dbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public TransactionManager transactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&serverTimezone=Asia/Shanghai&allowMultiQueries=true&useSSL=false&allowMultiQueries=true");
        dataSource.setUsername("root");
        dataSource.setPassword("132714");
        return dataSource;
    }
}
