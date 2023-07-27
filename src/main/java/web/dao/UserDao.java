package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void removeUser(Long id);
    void saveUser(User user);
    void updateUser(User user);
    List<User> getAllUsers();
    User getUser(Long id);




}