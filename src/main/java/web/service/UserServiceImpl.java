package web.service;

import web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao ud;


    @Override
    public void addUser(User user) {
        ud.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        ud.updateUser(user);
    }

    @Override
    public void removeUser(int id) {
        ud.removeUser(id);
    }

    @Override
    public User getUserById(int id) {
        return ud.getUserById(id);
    }

    @Override
    public List<User> usersList() {
        return ud.usersList();
    }
}
