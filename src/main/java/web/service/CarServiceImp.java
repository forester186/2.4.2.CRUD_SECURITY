package web.service;

import web.model.User;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImp implements CarService{
    private List<User> users = new ArrayList<>();

    public CarServiceImp() {
        users.add(new User("AUDI", 200, "BLACK"));
        users.add(new User("VOLKSWAGEN", 180, "WHITE"));
        users.add(new User("PORSCHE",250, "YELLOW"));
        users.add((new User("BMW", 230, "BLUE")));
        users.add(new User("LAMBORGHINI", 300, "GREEN"));
    }

    @Override
    public List<User> getAllCar() {
        return users;
    }
}
