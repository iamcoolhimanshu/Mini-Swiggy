package com.codeWithHimanshu.Swiggy;

import com.codeWithHimanshu.Swiggy.entity.User;
import com.codeWithHimanshu.Swiggy.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = "com.codeWithHimanshu.Swiggy")
public class MiniSwiggyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiniSwiggyApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository repo, BCryptPasswordEncoder encoder) {
        return args -> {
            if (repo.count() == 0) {
                User admin = new User();
                admin.setName("Admin");
                admin.setEmail("admin@gmail.com");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRole("ROLE_ADMIN");
                repo.save(admin);

                System.out.println("Admin user created successfully.");
            }
        };
    }
}
