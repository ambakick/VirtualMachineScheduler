package com.vcenter.vms.service;

import com.vcenter.vms.model.User;
import com.vcenter.vms.repository.UserRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {

        var it = userRepository.findAll();

        var users = new ArrayList<User>();
        it.forEach(e -> users.add(e));

        return users;
    }

    public User findById(Long userID) {

        List<User> users = findAll();

        for(User user : users) {
            if (user.getUserID().equals(userID))
                return user;
        }

        return null;
    }

    public Long count() {

        return userRepository.count();
    }

    public void deleteById(Long userId) {

        userRepository.deleteById(userId);
    }
}
