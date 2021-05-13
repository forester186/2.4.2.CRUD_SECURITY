package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getAllRole() {
        return userDao.getAllRole();
    }

    @Transactional
    @Override
    public void saveRole(Role role) {
        userDao.saveRole(role);
    }

    @Transactional
    @Override
    public void saveUser(User user, String[] roleList) {
        userDao.saveUser(user, roleList);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Transactional(readOnly = true)
    @Override
    public User gerUser(Long id) {
        return userDao.gerUser(id);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User user, String[] roleList) {
        userDao.updateUser(id, user, roleList);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }
}
