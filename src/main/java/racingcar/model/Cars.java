package racingcar.model;

import java.util.List;
import racingcar.dto.RoundResult;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        validate(cars);

        return new Cars(cars);
    }

    private static void validate(List<Car> cars) {
        if (hasDuplicated(cars)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasDuplicated(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .distinct()
                .count() != cars.size();
    }

    public void attemptForward() {
        cars.forEach(Car::attemptForward);
    }

    public RoundResult getRoundResult() {
        return new RoundResult(cars.stream()
                .map(Car::getCarState)
                .toList());
    }

    public List<Car> findWinningCars() {
        Car winningCar = findWinningCar();

        return cars.stream()
                .filter(car -> car.isSamePosition(winningCar))
                .toList();
    }

    private Car findWinningCar() {
        return cars.stream()
                .max(Car::compareTo)
                .get();
    }
}