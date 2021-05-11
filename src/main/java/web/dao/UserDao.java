package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    void saveUser(User user);

    List<User> getAllUser();

    User gerUser(Long id);

    void deleteUser(Long id);

    void updateUser(Long id, User user);

    User getUserByName(String name);

}
