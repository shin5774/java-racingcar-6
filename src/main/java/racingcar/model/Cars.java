package racingcar.model;

import java.util.Comparator;
import java.util.List;
import racingcar.dto.CarState;
import racingcar.dto.CarsState;
import racingcar.dto.ResultMessage;
import racingcar.validator.CarsValidator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String inputCars) {
        CarsValidator validator = CarsValidator.INSTANCE;
        List<String> names = validator.validate(inputCars);

        cars = toCars(names);
    }

    private List<Car> toCars(List<String> names) {
        return names.stream()
                .map(Name::new)
                .map(this::createCar)
                .toList();
    }

    private Car createCar(Name name) {
        return new Car(name, createPosition());
    }

    private Position createPosition() {
        return new Position();
    }

    public void attemptForward() {
        cars.forEach(Car::attemptForward);
    }

    public CarsState getCurrentCarsResult() {
        List<CarState> carsState = cars.stream()
                .map(Car::createCurrentResult)
                .toList();

        return new CarsState(carsState);
    }

    public ResultMessage findWinners() {
        return new ResultMessage(findWinningCars());
    }

    public List<Car> findWinningCars() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .stream().toList();
    }
}
