package com.tdd.blog.website.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author ：lilandong
 * @date ：2019/1/2
 * @desc 行政管理数据源
 */
@Configuration
@MapperScan(basePackages = DataSourceConfig.PACKAGE,sqlSessionFactoryRef = "SqlSessionFactory")
public class DataSourceConfig {

    static final String PACKAGE = "com.tdd.blog.website.dao";

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "venuesDataSource")
    public DataSource oaDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUsername(user);
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "venuesTransactionManager")
    public DataSourceTransactionManager oaTransactionManager() {
        return new DataSourceTransactionManager(oaDataSource());
    }

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory oaSqlSessionFactory(@Qualifier("venuesDataSource") DataSource oaDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(oaDataSource);
        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/*.xml");
        sessionFactory.setMapperLocations(resources);
        return sessionFactory.getObject();
    }
}
