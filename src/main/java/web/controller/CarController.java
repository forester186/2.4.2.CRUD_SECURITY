package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.CarServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {
    private CarServiceImp carServiceImp = new CarServiceImp();
    private List<User> userList = new ArrayList<>();

    @GetMapping(value = "/cars")
    public String getCar(ModelMap modelMap, @RequestParam(value = "count", required = false) Integer count){
        if(count == null){
            userList = carServiceImp.getAllCar();
        } else {
            userList = carServiceImp.getAllCar().stream().limit(count).collect(Collectors.toList());
        }
        modelMap.addAttribute("cars", userList);
        return "car";
    }


}
