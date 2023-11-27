package racingcar.controller.process;

import java.util.List;
import racingcar.dto.Winners;
import racingcar.model.Cars;

public class FindWinnersController {
    private final Cars cars;

    public FindWinnersController(Cars cars) {
        this.cars = cars;
    }

    public Winners proceed() {
        return toWinners(cars.findWinningCars());
    }

    private Winners toWinners(List<String> winnersCar) {
        return new Winners(winnersCar);
    }
}
