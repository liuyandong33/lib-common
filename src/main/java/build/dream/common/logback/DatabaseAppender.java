package build.dream.common.logback;

import build.dream.common.constants.ConfigurationKeys;
import build.dream.common.utils.ConfigurationUtils;
import ch.qos.logback.classic.db.DBAppender;
import ch.qos.logback.core.db.DataSourceConnectionSource;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang.StringUtils;

public class DatabaseAppender extends DBAppender {
    public DatabaseAppender() {
        String jdbcUrl = ConfigurationUtils.getConfiguration(ConfigurationKeys.DATASOURCE_HIKARI_LOG_JDBC_URL);
        String username = ConfigurationUtils.getConfiguration(ConfigurationKeys.DATASOURCE_HIKARI_LOG_USERNAME);
        String password = ConfigurationUtils.getConfiguration(ConfigurationKeys.DATASOURCE_HIKARI_LOG_PASSWORD);
        String driverClassName = ConfigurationUtils.getConfiguration(ConfigurationKeys.DATASOURCE_HIKARI_LOG_DRIVER_CLASS_NAME);
        String autoCommit = ConfigurationUtils.getConfiguration(ConfigurationKeys.DATASOURCE_HIKARI_LOG_AUTO_COMMIT);
        String minimumIdle = ConfigurationUtils.getConfiguration(ConfigurationKeys.DATASOURCE_HIKARI_LOG_MINIMUM_IDLE);
        String maximumPoolSize = ConfigurationUtils.getConfiguration(ConfigurationKeys.DATASOURCE_HIKARI_LOG_MAXIMUM_POOL_SIZE);
        String idleTimeout = ConfigurationUtils.getConfiguration(ConfigurationKeys.DATASOURCE_HIKARI_LOG_IDLE_TIMEOUT);
        String maxLifetime = ConfigurationUtils.getConfiguration(ConfigurationKeys.DATASOURCE_HIKARI_LOG_MAX_LIFETIME);
        String connectionTimeout = ConfigurationUtils.getConfiguration(ConfigurationKeys.DATASOURCE_HIKARI_LOG_CONNECTION_TIMEOUT);

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(jdbcUrl);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        hikariDataSource.setDriverClassName(driverClassName);
        if (StringUtils.isNotBlank(autoCommit)) {
            hikariDataSource.setAutoCommit(Boolean.parseBoolean(autoCommit));
        }
        if (StringUtils.isNotBlank(minimumIdle)) {
            hikariDataSource.setMinimumIdle(Integer.parseInt(minimumIdle));
        }
        if (StringUtils.isNotBlank(maximumPoolSize)) {
            hikariDataSource.setMaximumPoolSize(Integer.parseInt(maximumPoolSize));
        }
        if (StringUtils.isNotBlank(idleTimeout)) {
            hikariDataSource.setIdleTimeout(Long.parseLong(idleTimeout));
        }
        if (StringUtils.isNotBlank(maxLifetime)) {
            hikariDataSource.setMaxLifetime(Long.parseLong(maxLifetime));
        }
        if (StringUtils.isNotBlank(connectionTimeout)) {
            hikariDataSource.setConnectionTimeout(Long.parseLong(connectionTimeout));
        }

        DataSourceConnectionSource dataSourceConnectionSource = new DataSourceConnectionSource();
        dataSourceConnectionSource.setDataSource(hikariDataSource);
        dataSourceConnectionSource.discoverConnectionProperties();
        this.connectionSource = dataSourceConnectionSource;
    }
}
