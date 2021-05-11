package web.dao;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface RoleDao {
    void saveRole(Role role);

    List<Role> getAllRole();

    Role getRole(Long id);

    void deleteRole(Long id);

    void updateRole(Long id, Role role);

    Role getRoleByName(String name);
}
