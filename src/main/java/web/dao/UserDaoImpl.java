package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;
//ABSOLUTELY NOT
    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void removeUser(int id) {
        User user = em.find(User.class, id);
        if(user != null){
            em.remove(user);
        }
    }

    @Override
    public User getUserById(int id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public List<User> usersList() {
        List<User> userList = em.createQuery("from user", User.class).getResultList();
        return userList;

    }
}
