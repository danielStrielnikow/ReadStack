package pl.danielstrielnikow.domain.api;

import pl.danielstrielnikow.user.User;
import pl.danielstrielnikow.user.UserDao;

import java.time.LocalDateTime;

public class UserService {
    private UserDao userDao = new UserDao();

    public void register(UserRegistration userRegistration) {
        User userToSava = UserMapper.map(userRegistration);
        userDao.save(userToSava);
    }

    private static class UserMapper {
        static User map(UserRegistration userRegistration) {
            return new User(
                    userRegistration.getUsername(),
                    userRegistration.getEmail(),
                    userRegistration.getPassword(),
                    LocalDateTime.now()
            );
        }
    }
}

