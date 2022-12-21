package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", defaultValue = "5") int allCars, Model model) {
        CarService cs = new CarService();
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ferrari","540", 100));
        cars.add(new Car("Ferrari","540", 100));
        cars.add(new Car("Ferrari","540", 100));
        cars.add(new Car("Ferrari","540", 100));
        cars.add(new Car("Ferrari","540", 100));
        cars = cs.getCountOfCars(cars, allCars);
        model.addAttribute("cars", cars);
        return "cars";
    }

}
