package racingcar.controller;

import java.util.List;
import racingcar.controller.request.RequestAttemptCountController;
import racingcar.controller.request.RequestCarsController;
import racingcar.dto.TotalResult;
import racingcar.dto.Winners;
import racingcar.model.AttemptCount;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.service.RacingGameService;
import racingcar.util.WinnersNameExtractor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameService = racingGameService;
    }

    public void start() {
        Cars cars = generateCars();
        AttemptCount attemptCount = setAttemptCount();
        playRounds(cars, attemptCount);
        printWinners(cars);
    }

    private Cars generateCars() {
        return new RequestCarsController(inputView).proceed();
    }

    private AttemptCount setAttemptCount() {
        return new RequestAttemptCountController(inputView).proceed();
    }

    private void playRounds(Cars cars, AttemptCount attemptCount) {
        printTotalResult(racingGameService.playRounds(cars, attemptCount));
    }

    private void printTotalResult(TotalResult totalResult) {
        outputView.displayTotalResult(totalResult);
    }

    private void printWinners(Cars cars) {
        outputView.displayFinalWinnerMessage(getWinners(cars));
    }

    private Winners getWinners(Cars cars) {
        return toWinners(cars.findWinningCars());
    }

    private Winners toWinners(List<Car> winnersCar) {
        return WinnersNameExtractor.INSTANCE.extractName(winnersCar);
    }
}