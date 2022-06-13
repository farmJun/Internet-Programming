package com.example.demo.controller;

//package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/")
    public String index(){
        return "redirect:/list"; 
    }
    @RequestMapping("/list")
    public String lsit(Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("users",users);
        return "user/list"; 
    }
    @RequestMapping("/toAdd")
    public String toadd(User user){
        return "user/userAdd";
    }
    @RequestMapping("/add")
    public String add(User user){
        userService.save(user);
        return "redirect:/list";
    }
    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "user/userEdit"; 
    }
    @RequestMapping("/edit")
    public String edit(User user){
        userService.edit(user);
        return "redirect:/list";
    }
    @RequestMapping("/delete")
    public String edit(Long id){
        userService.delete(id);
        return "redirect:/list";
    }
}