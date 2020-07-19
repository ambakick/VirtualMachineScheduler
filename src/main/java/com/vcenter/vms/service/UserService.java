package com.vcenter.vms.service;

import com.vcenter.vms.model.User;
import com.vcenter.vms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {

        return (List<User>) userRepository.findAll();
    }

    public User findById(Integer userID) {

        List<User> users = findAll();

        for(User user : users) {
            if (user.getUserID() == userID)
                return user;
        }

        return null;
    }

    public void deleteById(Integer userId) {

        userRepository.deleteById(userId);
    }
}
