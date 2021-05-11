package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void saveUser(User user);

    List<User> getAllUser();

    List<Role> getAllRole();

    User gerUser(Long id);

    void deleteUser(Long id);

    void updateUser(Long id, User user);
}
