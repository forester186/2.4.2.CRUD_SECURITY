package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImp implements CarService{
    private List<Car> cars = new ArrayList<>();

    public CarServiceImp() {
        cars.add(new Car("AUDI", 200, "BLACK"));
        cars.add(new Car("VOLKSWAGEN", 180, "WHITE"));
        cars.add(new Car("PORSCHE",250, "YELLOW"));
        cars.add((new Car("BMW", 230, "BLUE")));
        cars.add(new Car("LAMBORGHINI", 300, "GREEN"));
    }

    @Override
    public List<Car> getAllCar() {
        return cars ;
    }
}
