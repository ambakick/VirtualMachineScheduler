package com.vcenter.vms.controller;

import com.vcenter.vms.model.User;
import com.vcenter.vms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/user/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String roleType, @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setUsername(name);
        n.setRoleType(roleType);
        n.setPassword(password);
        return "Saved";
    }

    @GetMapping(path = "/user/{userID}")
    public @ResponseBody
    User userById (@PathVariable Long userID) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return userService.findById(userID);
    }
}
