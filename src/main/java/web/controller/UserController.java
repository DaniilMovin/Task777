package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getAllUsers(ModelMap model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }


    @GetMapping("/create")
    public String showUserCreationPage(ModelMap map) {
        final User user = new User();
        map.addAttribute("user", user);
        return "new";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user, ModelMap map) {
        userService.saveUser(user);
        final String message = "User was added";
        map.addAttribute("user", new User());
        map.addAttribute("message", message);
        return "new";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id, HttpSession session) {
        userService.removeUser(id);
        session.setAttribute("message", "User was deleted");
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showUpdatePage(@RequestParam("id") Long id, ModelMap map) {
        map.addAttribute("user", userService.getUser(id));
        return "update";
    }


    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user, HttpSession session) {
        userService.updateUser(user);
        session.setAttribute("message", "User was updated");
        return "redirect:/";
    }}