package moe.shan.anonymous.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("moe.shan.anonymous")
public class AppConfig {

}
