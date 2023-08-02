package web.dao;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDaoImp implements CarDao{

    private List<Car> cars;
    private static int CARS_COUNT;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++CARS_COUNT,"BMW", "5"));
        cars.add(new Car(++CARS_COUNT,"Mazda", "6"));
        cars.add(new Car(++CARS_COUNT,"Volvo", "XC 60"));
        cars.add(new Car(++CARS_COUNT,"Toyota", "LC 300"));
        cars.add(new Car(++CARS_COUNT,"Mercedes", "GL 450"));

    }

    @Override
    public List<Car> listCars(int count) {
        return count < CARS_COUNT ? cars.subList(0,count) : cars;
    }

    public static int getCarsCount() {
        return CARS_COUNT;
    }

    public List<Car> getCars() {
        return cars;
    }
}
