package com.inti.formation.metier;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inti.formation.dao.UserDao;
import com.inti.formation.entities.User;

@Service

public class UserService {

    @Autowired
    UserDao userDao;
    
    public List<User> getAllUsers() {
        return this.userDao.findAll();
    }

    public User addUser(User user) {
        return this.userDao.addUser(user);
    }

    public int getUserNbrHalf(List<User> users) {
        System.out.println("*******************" + users.size() / 2);
        return users.size() / 2;
    }

    public User getUserById(Integer userId) {
        return this.userDao.findById(userId);
    }

    // other methods omitted for brevity
    public void updateUser(User utilisateur) {
        this.userDao.updateUser(utilisateur);
    }

    public void deleteUser(User utilisateur) {
        this.userDao.deleteUser(utilisateur);
    }

}