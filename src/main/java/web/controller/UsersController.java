package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/people")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String getAll(ModelMap modelMap){
        modelMap.addAttribute("people", userService.getAllUser());
        return "people/allUser";
    }

    @GetMapping("/new")
    public String newUser(ModelMap modelMap){
        modelMap.addAttribute("person", new User());
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

    @PatchMapping("/{id}")
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
