package ru.tenilin.authorizationservice.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tenilin.authorizationservice.repository.UserRepository;
import ru.tenilin.authorizationservice.service.AuthorizationService;

@Configuration
public class JavaConfig {

    @Bean
    public AuthorizationService authorizationService() {
        return new AuthorizationService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

}
