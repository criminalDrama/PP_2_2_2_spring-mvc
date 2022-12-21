package web.controller;

import org.springframework.validation.BindingResult;
import web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

   final
   UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String userList(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.usersList());
        return "users";
    }


    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }
//
    @PutMapping ("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return  "redirect:/users";

    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }


}
