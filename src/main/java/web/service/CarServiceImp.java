package web.service;

import org.springframework.stereotype.Component;
import web.dao.CarDaoImp;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImp implements CarService{
    private CarDaoImp carDaoImp = new CarDaoImp();


    @Override
    public List<Car> listCars(int count) {
        return carDaoImp.listCars(count);
    }
    @Override
    public List<Car> getCars() {
        return carDaoImp.getCars();
    }

}
