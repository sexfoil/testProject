package com.epam.producing.testProject.configuration;

import com.epam.producing.testProject.model.Employee;
import com.epam.producing.testProject.repository.EmployeeRepository;
import org.slf4j.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDataBase (EmployeeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Slava", "developer")));
            log.info("Preloading " + repository.save(new Employee("Anton", "student")));
        };
    }
}
