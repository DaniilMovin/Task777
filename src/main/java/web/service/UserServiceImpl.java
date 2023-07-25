package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Override
    @Transactional
    public User getUser(Long id) {
        return userDao.getUser(id);
    }


}
