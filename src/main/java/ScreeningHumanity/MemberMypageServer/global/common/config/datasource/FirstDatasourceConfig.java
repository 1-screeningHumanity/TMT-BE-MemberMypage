package ScreeningHumanity.MemberMypageServer.global.common.config.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@EnableJpaRepositories(
        basePackages = {
                "ScreeningHumanity.MemberMypageServer.bookmark",
                "ScreeningHumanity.MemberMypageServer.subscribe"
        },
        entityManagerFactoryRef = "firstDatabaseEntityManagerFactory",
        transactionManagerRef = "firstDatabaseTransactionManager"
)
@Configuration
public class FirstDatasourceConfig {

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean firstDatabaseEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(FirstDatabaseDataSource());
        em.setPackagesToScan(
                "ScreeningHumanity.MemberMypageServer.bookmark",
                "ScreeningHumanity.MemberMypageServer.subscribe"
                );
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.first-datasource")
    public DataSource FirstDatabaseDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager firstDatabaseTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(firstDatabaseEntityManagerFactory().getObject());
        return transactionManager;
    }
}
