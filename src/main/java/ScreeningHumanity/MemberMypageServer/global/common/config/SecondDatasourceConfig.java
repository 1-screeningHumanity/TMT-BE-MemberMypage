package ScreeningHumanity.MemberMypageServer.global.common.config;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@EnableJpaRepositories(
        basePackages = {
                "ScreeningHumanity.MemberMypageServer.readonly"
        },
        entityManagerFactoryRef = "secondDatabaseEntityManagerFactory",
        transactionManagerRef = "secondDatabaseTransactionManager"
)
@Configuration
public class SecondDatasourceConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean secondDatabaseEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(secondDatabaseDataSource());
        em.setPackagesToScan(
                "ScreeningHumanity.MemberMypageServer.readonly"
        );
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.second-datasource")
    public DataSource secondDatabaseDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public PlatformTransactionManager secondDatabaseTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(secondDatabaseEntityManagerFactory().getObject());
        return transactionManager;
    }
}