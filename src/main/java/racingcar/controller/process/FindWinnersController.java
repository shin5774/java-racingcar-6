package racingcar.controller.process;

import java.util.List;
import racingcar.dto.Winners;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.WinnersNameExtractor;

public class FindWinnersController {
    private final Cars cars;

    public FindWinnersController(Cars cars) {
        this.cars = cars;
    }

    public Winners proceed() {
        return toWinners(cars.findWinningCars());
    }

    private Winners toWinners(List<Car> winnersCar) {
        return WinnersNameExtractor.INSTANCE.extractName(winnersCar);
    }
}
