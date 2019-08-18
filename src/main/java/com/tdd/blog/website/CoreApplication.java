package com.tdd.blog.website;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@MapperScan("com.tdd.blog.website.dao")
@SpringBootApplication
@EnableTransactionManagement
public class CoreApplication extends SpringBootServletInitializer
{

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

    /*@Bean
    public EmbeddedServletContainerFactory servletContainer() {
        //springboot版本不同可能下面的类名会不同或者类的包路径会不同
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    @Bean
    public Connector httpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        //监听http的端口号
        connector.setPort(80);
        connector.setSecure(false);
        //监听到http的端口号后转向到的https的端口号
        System.out.println("监听到了80端口");
        connector.setRedirectPort(8081);//这里的端口写成和配置文件一样的端口就Ok
        return connector;
    }*/

}
