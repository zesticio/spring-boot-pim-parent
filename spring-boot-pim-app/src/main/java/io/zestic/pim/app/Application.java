package io.zestic.pim.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import io.zestic.pim.data.annotation.EnableData;

@EnableData
@SpringBootApplication
@PropertySource("classpath:mongodb.properties")
public class Application {

  private static final Logger logger = LoggerFactory.getLogger(Application.class.getSimpleName());
  private static ApplicationContext applicationContext;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
