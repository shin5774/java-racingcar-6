package racingcar.model;

import java.util.List;
import racingcar.dto.RoundResult;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> requestCars) {
        List<Car> cars = requestCars.stream()
                .map(Cars::generateCar)
                .toList();

        return new Cars(cars);
    }

    private static Car generateCar(String name) {
        return new Car(new Name(name), new Position());
    }


    public void attemptForward() {
        cars.forEach(Car::attemptForward);
    }

    public RoundResult getRoundResult() {
        return new RoundResult(cars.stream()
                .map(Car::getCarResult)
                .toList());
    }

    public List<Car> findWinningCars() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(cars -> cars.getPosition() == maxPosition)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();
    }
}