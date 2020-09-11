package br.com.unbox;

import br.com.unbox.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class UnboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnboxApplication.class, args);
    }

}
