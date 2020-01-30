package com.cjrequena.sample.configuration;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.validation.annotation.Validated;

import javax.sql.DataSource;

/**
 * <p>
 * <p>
 *
 * @author cjrequena
 */
@Log4j2
@Configuration
public class DataSourceConfiguration {

  private ConexionType conexionType;

  @Profile("!integration-test")
  @Primary
  @Bean(name = "dataSource", destroyMethod = "")
  @Validated
  @ConfigurationProperties(prefix = "spring.datasource.postgres")
  @ConditionalOnProperty(
    name = {"spring.datasource.postgres.type"},
    havingValue = "com.zaxxer.hikari.HikariDataSource",
    matchIfMissing = true
  )
  @ConditionalOnClass({HikariDataSource.class})
  public HikariDataSource dataSource() {
    conexionType = ConexionType.POSTGRES;
    return new HikariDataSource();
  }

  @Profile("integration-test")
  @Bean(name = "dataSource", destroyMethod = "")
  public DataSource dataSourceIT() {
    conexionType = ConexionType.HSQL;
    return new EmbeddedDatabaseBuilder()
      .setType(EmbeddedDatabaseType.HSQL)
      .build();
  }

  private enum ConexionType {
    POSTGRES,
    HSQL
  }
}
