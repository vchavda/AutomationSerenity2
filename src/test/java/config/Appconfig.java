package config;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan({"utils.**"})
@PropertySource(value = "classpath:application.properties")
public class Appconfig {

    @Value("${user}")
    private String user;

    @PostConstruct
    public void configureRestAssured() {
        System.out.println("XXXuser is " + user);

    }


}
