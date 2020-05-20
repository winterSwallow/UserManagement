package com.winterswallow.thymeleaf.controller;

import com.winterswallow.thymeleaf.service.UserService;
import com.winterswallow.thymeleaf.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list","userModel", model);
    }

    @GetMapping("/search")
    public ModelAndView view(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("userList", userService.findAllByNameContains(keyword));
        model.addAttribute("title", "查询用户");
        return new ModelAndView("users/list","userModel", model);
    }

    @GetMapping("/form")
    public ModelAndView creatForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user) {
        userService.save(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Integer id,Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form","userModel",model);
    }

}
