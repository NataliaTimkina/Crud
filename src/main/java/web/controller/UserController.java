package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping("/users/new")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.createOrUpdateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/user/editUser")
    public String editUser(){
        return "editUser";
    }

    @PutMapping("/user/edit")
    public String updateUser(@RequestBody User user) {
        userService.createOrUpdateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete")
    public String deleteUser() {
        return "deleteUser";
    }


    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
