package racingcar;

import racingcar.controller.display.DisplayTotalResultController;
import racingcar.controller.display.DisplayWinnerController;
import racingcar.controller.process.CalculateTotalResultController;
import racingcar.controller.process.findWinnersController;
import racingcar.controller.request.RequestAttemptCountController;
import racingcar.controller.request.RequestCarsController;
import racingcar.dto.TotalResult;
import racingcar.dto.Winners;
import racingcar.model.AttemptCount;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameApplication {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameApplication(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Cars cars = generateCars();
        AttemptCount attemptCount = setAttemptCount();

        TotalResult totalResult = playGame(cars, attemptCount);
        Winners winners = findWinners(cars);

        displayTotalResult(totalResult);
        displayWinners(winners);
    }

    private Cars generateCars() {
        return new RequestCarsController(inputView).proceed();
    }

    private AttemptCount setAttemptCount() {
        return new RequestAttemptCountController(inputView).proceed();
    }

    private TotalResult playGame(Cars cars, AttemptCount attemptCount) {
        return new CalculateTotalResultController(cars, attemptCount).proceed();
    }

    private Winners findWinners(Cars cars) {
        return new findWinnersController(cars).proceed();
    }

    private void displayTotalResult(TotalResult totalResult) {
        new DisplayTotalResultController(outputView).proceed(totalResult);
    }

    private void displayWinners(Winners winners) {
        new DisplayWinnerController(outputView).proceed(winners);
    }
}