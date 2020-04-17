package cavanaugh.m.sean.aws.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration
public class AwsSpringBootAPIApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AwsSpringBootAPIApplication.class, args);
    }
}
