package org.nicolas.nicolasv2;

import org.nicolas.nicolasv2.dao.UserDAO;
import org.nicolas.nicolasv2.entity.User;
import org.nicolas.nicolasv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabase implements ApplicationRunner {
    private UserDAO userRepository;

    @Autowired
    public LoadDatabase(UserDAO userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user1 = new User();
        user1.setName("Utilisateur 1");
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("Utilisateur 2");
        userRepository.save(user2);
    }
}
