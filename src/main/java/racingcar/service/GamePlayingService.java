package racingcar.service;

import java.util.List;
import racingcar.dto.AttemptCount;
import racingcar.dto.CarsState;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.validator.AttemptCountValidator;

public class GamePlayingService {
    public Cars generateCars(String inputNames) {
        return new Cars(inputNames);
    }

    public AttemptCount createAttemptCount(String input) {
        AttemptCountValidator.INSTANCE.validate(input);

        return new AttemptCount(toInt(input));
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    public CarsState tryForward(Cars cars) {
        cars.attemptForward();
        return getCarsState(cars);
    }

    private CarsState getCarsState(Cars cars) {
        return cars.getCarsState();
    }

    public Winners getWinners(Cars cars) {
        return createWinners(cars.findWinningCars());
    }

    private Winners createWinners(List<Car> winnersCar) {
        return new Winners(winnersCar);
    }
}
