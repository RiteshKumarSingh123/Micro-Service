package com.assh.supervisor.multitenant;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

//@Configuration
//@EnableTransactionManagement
//public class HibernateConfig {
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//            MultiTenantConnectionProviderImpl multiTenantConnectionProvider,
//            CurrentTenantIdentifierResolverImpl tenantResolver) {
//
//        Map<String, Object> props = new HashMap<>();
//        props.put("hibernate.multiTenancy", "SCHEMA");
//        props.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProvider);
//        props.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, tenantResolver);
//        props.put(Environment.DIALECT, "org.hibernate.dialect.OracleDialect");
//
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setPackagesToScan("com.assh.supervisor"); 
//        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        emf.setJpaPropertyMap(props);
//
//        return emf;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(
//            EntityManagerFactory emf) {
//        return new JpaTransactionManager(emf);
//    }
//}

//@Configuration
//public class HibernateConfig {
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//            MultiTenantConnectionProviderImpl multiTenantConnectionProvider,
//            CurrentTenantIdentifierResolverImpl currentTenantIdentifierResolver) {
//
//        Map<String, Object> props = new HashMap<>();
//        props.put("hibernate.multiTenancy", "DATABASE"); // ✅ correct in Hibernate 6
//        props.put("hibernate.multi_tenant_connection_provider", multiTenantConnectionProvider);
//        props.put("hibernate.tenant_identifier_resolver", currentTenantIdentifierResolver);
//
//        return builder
//                .dataSource(defaultDataSource()) // optional fallback datasource
//                .packages("com.assh.supervisor.model") // your entity package
//                .properties(props)
//                .build();
//    }
//
//    @Bean
//    public DataSource defaultDataSource() {
//        // fallback datasource if needed
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:oracle:thin:@//192.168.10.231:1521/orcl");
//        config.setUsername("trainee");
//        config.setPassword("trainee");
//        config.setDriverClassName("oracle.jdbc.OracleDriver");
//        return new HikariDataSource(config);
//    }
//}


@Configuration
public class HibernateConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            MultiTenantConnectionProviderImpl multiTenantConnectionProvider,
            CurrentTenantIdentifierResolverImpl currentTenantIdentifierResolver) {

        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.multiTenancy", "DATABASE");
        props.put("hibernate.multi_tenant_connection_provider", multiTenantConnectionProvider);
        props.put("hibernate.tenant_identifier_resolver", currentTenantIdentifierResolver);

        // 👇 NEW: Hook dialect dynamically per tenant
        props.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect"); 

        return builder
                .dataSource(defaultDataSource()) // fallback
                .packages("com.assh.supervisor.model") // shared entities
                .properties(props)
                .build();
    }

    @Bean
    public DataSource defaultDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:oracle:thin:@//192.168.10.231:1521/orcl");
        config.setUsername("trainee");
        config.setPassword("trainee");
        config.setDriverClassName("oracle.jdbc.OracleDriver");
        return new HikariDataSource(config);
    }
}



