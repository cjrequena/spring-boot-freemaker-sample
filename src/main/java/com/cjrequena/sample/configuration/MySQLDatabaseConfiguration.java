//package com.cjrequena.sample.configuration;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.validation.annotation.Validated;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
///**
// * <p>
// * <p>
// * <p>
// * <p>
// *
// * @author cjrequena
// */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//  entityManagerFactoryRef = "entityManagerFactoryMySQL",
//  transactionManagerRef = "transactionManagerMySQL",
//  basePackages = {"com.cjrequena.sample.db.repository.mysql"}
//)
//public class MySQLDatabaseConfiguration {
//
//  @Bean(name = "dataSourceMySQL", destroyMethod = "")
//  @Validated
//  @ConfigurationProperties(prefix = "spring.datasource.mysql")
//  @ConditionalOnClass({HikariDataSource.class})
//  public HikariDataSource dataSourceMySQL() {
//    return new HikariDataSource();
//  }
//
//  /**
//   *
//   * @param builder
//   * @param dataSource
//   * @return
//   */
//  @Bean("entityManagerFactoryMySQL")
//  public LocalContainerEntityManagerFactoryBean entityManagerFactoryMySQL(EntityManagerFactoryBuilder builder, @Qualifier("dataSourceMySQL") DataSource dataSource) {
//    return builder
//      .dataSource(dataSource)
//      .packages("com.cjrequena.sample.db.entity.mysql")
//      .persistenceUnit("chinook")
//      .build();
//  }
//
//  /**
//   *
//   * @param entityManagerFactoryMySQL
//   * @return
//   */
//  @Bean("transactionManagerMySQL")
//  public PlatformTransactionManager transactionManagerMySQL(@Qualifier("entityManagerFactoryMySQL") EntityManagerFactory entityManagerFactoryMySQL) {
//    return new JpaTransactionManager(entityManagerFactoryMySQL);
//  }
//}
//
