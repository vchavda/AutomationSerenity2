package config;

// This class will get initiated fiers as we have defined annotation
//@ContextConfiguration(classes = {Appconfig.class}) in the restassuredStep class
// This will then load the propeties from the propeties files
// The @PostConstruct annotation tells spring this methos need invoking after beans have been initated and loaded

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import restAssuredUtils.ResponseMap;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan(basePackages = {"utils.**","restAssuredUtils.**"}) // double asterix in recursive in the package
@PropertySource(value = "classpath:application.properties")
public class Appconfig {

    @Value("${user}")
    private String user;

    @PostConstruct
    public void configureRestAssured() {
        System.out.println("XXXuser is " + user);

    }


}
