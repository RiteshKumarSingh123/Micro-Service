package com.example.demo.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//@SuppressWarnings({ "serial", "rawtypes" })
//@Component
//public  class MultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider {
//    private final Map<String, DataSource> dataSources = new HashMap<>();
//
//    @Autowired
//    public MultiTenantConnectionProviderImpl(Environment env) {
//        dataSources.put("tenant1", createDataSource(env, "multi-tenancy.datasources.tenant1"));
//        dataSources.put("tenant2", createDataSource(env, "multi-tenancy.datasources.tenant2"));
//    }
//
//    private DataSource createDataSource(Environment env, String prefix) {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl(env.getProperty(prefix + ".url"));
//        config.setUsername(env.getProperty(prefix + ".username"));
//        config.setPassword(env.getProperty(prefix + ".password"));
//        return new HikariDataSource(config);
//    }
//
//    @Override
//    public Connection getAnyConnection() throws SQLException {
//        return dataSources.values().iterator().next().getConnection();
//    }
//
//    @Override
//    public void releaseAnyConnection(Connection connection) throws SQLException {
//        connection.close();
//    }
//
//    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
//        connection.close();
//    }
//
//    @Override
//    public boolean supportsAggressiveRelease() {
//        return false;
//    }
//
//
//    @Override
//    public boolean isUnwrappableAs(Class unwrapType) {
//        return false;
//    }
//
//    @Override
//    public <T> T unwrap(Class<T> unwrapType) {
//        return null;
//    }
//
//    @Override
//    public Connection getConnection(Object tenantIdentifier) throws SQLException {
//        DataSource dataSource = dataSources.get(String.valueOf(tenantIdentifier));
//        if (dataSource != null) {
//            return dataSource.getConnection();
//        } else {
//            throw new SQLException("No DataSource found for tenant: " + tenantIdentifier);
//        }
//    }
//
//
//    @Override
//    public void releaseConnection(Object tenantIdentifier, Connection connection) throws SQLException {
//        if (connection != null) {
//            connection.close();
//        }
//    }
//
//
//    
//}

@SuppressWarnings({ "serial", "rawtypes" })
@Component
public class MultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider {

    private final Map<String, DataSource> dataSources = new HashMap<>();

    @Autowired
    public MultiTenantConnectionProviderImpl(Environment env) {
        addTenantDataSource(env, "tenant1", "multi-tenancy.datasources.tenant1");
        addTenantDataSource(env, "tenant2", "multi-tenancy.datasources.tenant2");
    }

    private void addTenantDataSource(Environment env, String tenantId, String prefix) {
        try {
            DataSource ds = createDataSource(env, prefix);
            dataSources.put(tenantId, ds);
            System.out.println(">>> DataSource registered for tenant: " + tenantId);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Failed to create datasource for tenant '" + tenantId + "': " + e.getMessage(), e);
        }
    }

    private DataSource createDataSource(Environment env, String prefix) {
        String url = env.getProperty(prefix + ".url");
        String username = env.getProperty(prefix + ".username");
        String password = env.getProperty(prefix + ".password");
//        String driver = env.getProperty(prefix + ".driver-class-name", "com.mysql.cj.jdbc.Driver");
        String driver = env.getProperty(prefix + ".driver-class-name", "oracle.jdbc.OracleDriver");

        if (url == null || username == null || password == null) {
            throw new IllegalArgumentException("Missing database configuration for prefix: " + prefix);
        }

        HikariConfig config = new HikariConfig();
        System.out.println(url+username+password+driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);

        return new HikariDataSource(config);
    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        return dataSources.values().iterator().next().getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public boolean isUnwrappableAs(Class unwrapType) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        return null;
    }

    @Override
    public Connection getConnection(Object tenantIdentifier) throws SQLException {
    	 System.out.println(">>> Trying to get connection for tenant: " + tenantIdentifier);
        DataSource dataSource = dataSources.get(String.valueOf(tenantIdentifier));
        if (dataSource != null) {
            return dataSource.getConnection();
        } else {
            throw new SQLException("No DataSource found for tenant: " + tenantIdentifier);
        }
    }
//    @Override
//    public Connection getConnection(Object tenantIdentifier) throws SQLException {
//        System.out.println(">>> Trying to get connection for tenant: " + tenantIdentifier);
//        DataSource dataSource = dataSources.get(String.valueOf(tenantIdentifier));
//        if (dataSource != null) {
//            Connection conn = dataSource.getConnection();
//            System.out.println(">>> SUCCESS: Got connection for tenant " + tenantIdentifier);
//            return conn;
//        } else {
//            throw new SQLException("No DataSource found for tenant: " + tenantIdentifier);
//        }
//    }

    @Override
    public void releaseConnection(Object tenantIdentifier, Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}

