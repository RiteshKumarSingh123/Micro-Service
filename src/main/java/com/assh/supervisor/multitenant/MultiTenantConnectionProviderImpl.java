package com.assh.supervisor.multitenant;

//@SuppressWarnings({ "serial", "rawtypes" })
//@Component
//public class MultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider {
//
//    private final Map<String, DataSource> dataSources = new HashMap<>();
//
//    @Autowired
//    public MultiTenantConnectionProviderImpl(Environment env) {
//        addTenantDataSource(env, "tenant1", "multi-tenancy.datasources.tenant1");
//        addTenantDataSource(env, "tenant2", "multi-tenancy.datasources.tenant2");
//    }
//
//    private void addTenantDataSource(Environment env, String tenantId, String prefix) {
//        try {
//            DataSource ds = createDataSource(env, prefix);
//            dataSources.put(tenantId, ds);
//            System.out.println(">>> DataSource registered for tenant: " + tenantId);
//        } catch (IllegalArgumentException e) {
//            throw new RuntimeException("Failed to create datasource for tenant '" + tenantId + "': " + e.getMessage(), e);
//        }
//    }
//
//    private DataSource createDataSource(Environment env, String prefix) {
//        String url = env.getProperty(prefix + ".url");
//        String username = env.getProperty(prefix + ".username");
//        String password = env.getProperty(prefix + ".password");
////        String driver = env.getProperty(prefix + ".driver-class-name", "com.mysql.cj.jdbc.Driver");
//        String driver = env.getProperty(prefix + ".driver-class-name", "oracle.jdbc.OracleDriver");
//
//        if (url == null || username == null || password == null) {
//            throw new IllegalArgumentException("Missing database configuration for prefix: " + prefix);
//        }
//
//        HikariConfig config = new HikariConfig();
//        System.out.println(url+username+password+driver);
//        config.setJdbcUrl(url);
//        config.setUsername(username);
//        config.setPassword(password);
//        config.setDriverClassName(driver);
//
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
//    @Override
//    public boolean supportsAggressiveRelease() {
//        return false;
//    }
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
//    public Connection getConnection(Object tenantIdentifier) throws SQLException {
//    	 System.out.println(">>> Trying to get connection for tenant: " + tenantIdentifier);
//        DataSource dataSource = dataSources.get(String.valueOf(tenantIdentifier));
//        if (dataSource != null) {
//            return dataSource.getConnection();
//        } else {
//            throw new SQLException("No DataSource found for tenant: " + tenantIdentifier);
//        }
//    }
////    @Override
////    public Connection getConnection(Object tenantIdentifier) throws SQLException {
////        System.out.println(">>> Trying to get connection for tenant: " + tenantIdentifier);
////        DataSource dataSource = dataSources.get(String.valueOf(tenantIdentifier));
////        if (dataSource != null) {
////            Connection conn = dataSource.getConnection();
////            System.out.println(">>> SUCCESS: Got connection for tenant " + tenantIdentifier);
////            return conn;
////        } else {
////            throw new SQLException("No DataSource found for tenant: " + tenantIdentifier);
////        }
////    }
//
//    public void releaseConnection(Object tenantIdentifier, Connection connection) throws SQLException {
//        if (connection != null) {
//            connection.close();
//        }
//    }
//}



//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
//import org.hibernate.service.UnknownUnwrapTypeException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
////@SuppressWarnings({"serial"})
//@Component
//public class MultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider {
//
//    private final Map<String, DataSource> dataSources = new HashMap<>();
//
//    @Autowired
//    public MultiTenantConnectionProviderImpl(Environment env) {
//        addTenantDataSource(env, "tenant1", "multi-tenancy.datasources.tenant1");
//        addTenantDataSource(env, "tenant2", "multi-tenancy.datasources.tenant2");
//    }
//
//    private void addTenantDataSource(Environment env, String tenantId, String prefix) {
//        try {
//            DataSource ds = createDataSource(env, prefix);
//            dataSources.put(tenantId, ds);
//            System.out.println(">>> DataSource registered for tenant: " + tenantId);
//        } catch (IllegalArgumentException e) {
//            throw new RuntimeException("Failed to create datasource for tenant '" + tenantId + "': " + e.getMessage(), e);
//        }
//    }
//
//    private DataSource createDataSource(Environment env, String prefix) {
//        String url = env.getProperty(prefix + ".url");
//        String username = env.getProperty(prefix + ".username");
//        String password = env.getProperty(prefix + ".password");
//        String driver = env.getProperty(prefix + ".driver-class-name", "oracle.jdbc.OracleDriver");
//
//        if (url == null || username == null || password == null) {
//            throw new IllegalArgumentException("Missing database configuration for prefix: " + prefix);
//        }
//
//        HikariConfig config = new HikariConfig();
//        System.out.println(url+username+password+driver);
//        config.setJdbcUrl(url);
//        config.setUsername(username);
//        config.setPassword(password);
//        config.setDriverClassName(driver);
//
//        return new HikariDataSource(config);
//    }
//
//    // Hibernate 6 required methods
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
//    @Override
//    public Connection getConnection(String tenantIdentifier) throws SQLException {
//        System.out.println(">>> Trying to get connection for tenant: " + tenantIdentifier);
//        DataSource dataSource = dataSources.get(tenantIdentifier);
//        if (dataSource != null) {
//            Connection conn = dataSource.getConnection();
//            System.out.println(">>> SUCCESS: Got connection for tenant " + tenantIdentifier);
//            return conn;
//        } else {
//            throw new SQLException("No DataSource found for tenant: " + tenantIdentifier);
//        }
//    }
//
//    @Override
//    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
//        if (connection != null) {
//            connection.close();
//        }
//    }
//
//    @Override
//    public boolean supportsAggressiveRelease() {
//        return false;
//    }
//
//    @Override
//    public boolean isUnwrappableAs(Class unwrapType) {
//        return MultiTenantConnectionProvider.class.equals(unwrapType) ||
//                MultiTenantConnectionProviderImpl.class.isAssignableFrom(unwrapType);
//    }
//
//    @Override
//    public <T> T unwrap(Class<T> unwrapType) {
//        if (isUnwrappableAs(unwrapType)) {
//            return (T) this;
//        }
//        throw new UnknownUnwrapTypeException(unwrapType);
//    }
//}
//

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.service.UnknownUnwrapTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings({"serial"})
@Component
public class MultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider {

    private final Map<String, DataSource> dataSources = new HashMap<>();
    private final Map<String, String> tenantDialects = new HashMap<>();

    @Autowired
    public MultiTenantConnectionProviderImpl(Environment env) {
        addTenantDataSource(env, "tenant1", "multi-tenancy.datasources.tenant1",
                "org.hibernate.dialect.OracleDialect");
        addTenantDataSource(env, "tenant2", "multi-tenancy.datasources.tenant2",
                "org.hibernate.dialect.PostgreSQLDialect");
    }

    private void addTenantDataSource(Environment env, String tenantId, String prefix, String dialect) {
        try {
            DataSource ds = createDataSource(env, prefix);
            dataSources.put(tenantId, ds);
            tenantDialects.put(tenantId, dialect);
            System.out.println(">>> DataSource registered for tenant: " + tenantId + " with dialect " + dialect);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Failed to create datasource for tenant '" + tenantId + "': " + e.getMessage(), e);
        }
    }

    private DataSource createDataSource(Environment env, String prefix) {
        String url = env.getProperty(prefix + ".url");
        String username = env.getProperty(prefix + ".username");
        String password = env.getProperty(prefix + ".password");
        String driver = env.getProperty(prefix + ".driver-class-name", "oracle.jdbc.OracleDriver");
        
        System.out.println(url+username+password+driver+"###############################");

        if (url == null || username == null || password == null) {
            throw new IllegalArgumentException("Missing database configuration for prefix: " + prefix);
        }

        HikariConfig config = new HikariConfig();
        System.out.println(">>> Creating DataSource: " + url + " | user=" + username + " | driver=" + driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);

        return new HikariDataSource(config);
    }

    // === New helper method ===
    public String getDialectForTenant(String tenantId) {
        return tenantDialects.getOrDefault(tenantId, "org.hibernate.dialect.OracleDialect");
    }
    
    public boolean tenantExists(String tenantId) {
        return dataSources.containsKey(tenantId);
    }

    public Map<String, DataSource> getAllDataSources() {
        return Collections.unmodifiableMap(dataSources);
    }

    // === Hibernate 6 required methods ===

    @Override
    public Connection getAnyConnection() throws SQLException {
        return dataSources.values().iterator().next().getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        System.out.println(">>> Trying to get connection for tenant: " + tenantIdentifier);
        DataSource dataSource = dataSources.get(tenantIdentifier);
        if (dataSource != null) {
            Connection conn = dataSource.getConnection();
            System.out.println(">>> SUCCESS: Got connection for tenant " + tenantIdentifier);
            return conn;
        } else {
            throw new SQLException("No DataSource found for tenant: " + tenantIdentifier);
        }
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public boolean isUnwrappableAs(Class unwrapType) {
        return MultiTenantConnectionProvider.class.equals(unwrapType) ||
                MultiTenantConnectionProviderImpl.class.isAssignableFrom(unwrapType);
    }

    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        if (isUnwrappableAs(unwrapType)) {
            return (T) this;
        }
        throw new UnknownUnwrapTypeException(unwrapType);
    }
}

