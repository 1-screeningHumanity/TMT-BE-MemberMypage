package ScreeningHumanity.MemberMypageServer.global.common.config.datasource;

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
                "ScreeningHumanity.MemberMypageServer.readonly.ranking"
        },
        entityManagerFactoryRef = "thirdDatabaseEntityManagerFactory",
        transactionManagerRef = "thirdDatabaseTransactionManager"
)
@Configuration
public class ThirdDatasourceConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean thirdDatabaseEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(thirdDatabaseDataSource());
        em.setPackagesToScan(
                "ScreeningHumanity.MemberMypageServer.readonly.ranking"
        );
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.third-datasource")
    public DataSource thirdDatabaseDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public PlatformTransactionManager thirdDatabaseTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(thirdDatabaseEntityManagerFactory().getObject());
        return transactionManager;
    }
}
