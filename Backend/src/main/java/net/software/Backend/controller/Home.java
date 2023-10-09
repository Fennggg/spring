package net.software.Backend.controller;

import net.software.Backend.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @RequestMapping("/")
    public String home(){
        return "Home";
    }

    //访问user操作
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User user(){
        User user = new User();
        user.setId("3100");
        user.setName("software");
        user.setEmail("info@software.net");
        return user;
    }
}
