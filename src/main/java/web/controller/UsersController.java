package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/people")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAll(ModelMap modelMap){
        modelMap.addAttribute("people", userService.getAllUser());
        return "people/allUser";
    }

    @GetMapping("/new")
    public String newUser(ModelMap modelMap){
        modelMap.addAttribute("person", new User());
        modelMap.addAttribute("roleList", userService.getAllRole());
        return "people/new";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("person") User user) {
        userService.saveUser(user);
        return "redirect:/people";
    }


    @GetMapping("/{id}/update")
    public String getUpdate(ModelMap modelMap, @PathVariable("id") Long id){
        modelMap.addAttribute("person", userService.gerUser(id));
        return "people/update";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") User user, @PathVariable("id") Long id){
        userService.updateUser(id,user);
        return "redirect:/people";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/people";
    }

}
