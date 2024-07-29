package az.edu.turing.managementappjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManagementAppJpaApplication {

    private static final Logger logger = LoggerFactory.getLogger(ManagementAppJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ManagementAppJpaApplication.class, args);

        logger.info("Application started successfully!");
    }
}
