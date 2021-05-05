package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUser() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User gerUser(Long id) {
       TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u where u.id = :id", User.class);
       typedQuery.setParameter("id", id);
       return typedQuery.getSingleResult();
    }

    @Override
    public void deleteUser(Long id) {
        User user = gerUser(id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(Long id, User update) {
        User user = gerUser(id);
        user = update;
        entityManager.merge(user);
    }
}
