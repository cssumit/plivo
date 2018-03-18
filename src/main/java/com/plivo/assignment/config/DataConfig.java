package com.plivo.assignment.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(ignoreResourceNotFound = true, value = "classpath:db.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.plivo.assignment.repositories" })
public class DataConfig {


}