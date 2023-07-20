package io.zestic.pim.data.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Order(1)
@ComponentScan
@Configuration
@EnableMongoRepositories(basePackages = {"io.zestic.pim.data"})
public class DataAutoConfiguration {
}
