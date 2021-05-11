package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> getAllRole() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getRole(Long id) {
        TypedQuery<Role> typedQuery = entityManager.createQuery("select r from Role r where r.id = :id", Role.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void deleteRole(Long id) {
        Role role = getRole(id);
        entityManager.remove(role);
    }

    @Override
    public void updateRole(Long id, Role role) {
        Role role1 = getRole(id);
        role1 = role;
        entityManager.merge(role1);

    }

    @Override
    public Role getRoleByName(String name) {
        TypedQuery<Role> typedQuery = entityManager.createQuery("select r from Role r where r.role = :role", Role.class);
        typedQuery.setParameter("role", name);
        return typedQuery.getSingleResult();
    }
}
