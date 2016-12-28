package com.swkj.zebra.config;//package com.amaz.core.conf;

import com.amaz.core.common.PropertiesUtils;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration implements EnvironmentAware {

    private Environment environment;
    private RelaxedPropertyResolver datasourcePropertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        this.datasourcePropertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        System.out.println("-------------------- spring.datasource init ---------------------");
        return DataSourceBuilder.create().build();
    }


//    //datasource
//    @Bean(initMethod = "init", destroyMethod = "close")
//    public DataSource dataSource() throws SQLException {
//        if (StringUtils.isEmpty(datasourcePropertyResolver.getProperty("url"))) {
//            System.out.println("Your database connection pool configuration is incorrect!" +
//                    " Please check your Spring profile, current profiles are:" +
//                    Arrays.toString(environment.getActiveProfiles()));
//            throw new ApplicationContextException("Database connection pool is not configured correctly");
//        }
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl(datasourcePropertyResolver.getProperty("url"));
//        druidDataSource.setUsername(datasourcePropertyResolver.getProperty("username"));
//        druidDataSource.setPassword(datasourcePropertyResolver.getProperty("password"));
//        druidDataSource.setInitialSize(1);
//        druidDataSource.setMinIdle(1);
//        druidDataSource.setMaxActive(20);
//        druidDataSource.setMaxWait(60000);
//        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
//        druidDataSource.setMinEvictableIdleTimeMillis(300000);
//        druidDataSource.setValidationQuery("SELECT　'x'");
//        druidDataSource.setTestWhileIdle(true);
//        druidDataSource.setTestOnBorrow(false);
//        druidDataSource.setTestOnReturn(false);
//        return druidDataSource;
//    }

    @Inject
    HibernateProperties hibernateProperties;
    //sessionFactory
    @Bean
    public LocalSessionFactoryBean sessionFactory() throws SQLException {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(this.dataSource());
        localSessionFactoryBean.setPhysicalNamingStrategy(new SpringPhysicalNamingStrategy());
        Properties properties = PropertiesUtils.get(hibernateProperties.getProperties());
        localSessionFactoryBean.setHibernateProperties(properties);
        localSessionFactoryBean.setPackagesToScan("*");
        return localSessionFactoryBean;
    }

    //txManager事务开启
    @Bean
    public HibernateTransactionManager txManager() throws SQLException {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
        return hibernateTransactionManager;
    }
}