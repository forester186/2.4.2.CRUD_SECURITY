package web.dao;

import web.model.Role;
import web.model.User;
import java.util.List;

public interface UserDao {

    Role getRoleByName(String role);

    List<Role> getAllRole();

    void saveRole(Role role);


    void saveUser(User user, String[] roleList);

    List<User> getAllUser();

    User gerUser(Long id);

    void deleteUser(Long id);

    void updateUser(Long id, User user, String[] roleList);

    User getUserByName(String name);

}
