package web.dao;

import web.model.Role;
import web.model.User;
import java.util.List;

public interface UserDao {

    List<Role> getAllRole();

    void saveRole(Role role);

    void saveUser(User user);

    List<User> getAllUser();

    User gerUser(Long id);

    void deleteUser(Long id);

    void updateUser(Long id, User user);

    User getUserByName(String name);

}
