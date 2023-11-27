package racingcar;

import racingcar.controller.display.DisplayTotalResultController;
import racingcar.controller.display.DisplayWinnerController;
import racingcar.controller.process.FindWinnersController;
import racingcar.controller.process.ProceedGameController;
import racingcar.controller.request.RequestAttemptCountController;
import racingcar.controller.request.RequestCarsController;
import racingcar.dto.TotalResult;
import racingcar.dto.Winners;
import racingcar.model.AttemptCount;
import racingcar.model.Cars;
import racingcar.view.InputView;

public class RacingGameApplication {

    private final InputView inputView;


    public RacingGameApplication(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        Cars cars = requestCars();
        AttemptCount attemptCount = requestAttemptAmount();

        TotalResult totalResult = playGame(cars, attemptCount);
        Winners winners = findWinners(cars);

        displayTotalResult(totalResult);
        displayWinners(winners);
    }

    private Cars requestCars() {
        return new RequestCarsController(inputView).proceed();
    }

    private AttemptCount requestAttemptAmount() {
        return new RequestAttemptCountController(inputView).proceed();
    }

    private TotalResult playGame(Cars cars, AttemptCount attemptCount) {
        return new ProceedGameController(cars, attemptCount).proceed();
    }

    private Winners findWinners(Cars cars) {
        return new FindWinnersController(cars).proceed();
    }

    private void displayTotalResult(TotalResult totalResult) {
        new DisplayTotalResultController().proceed(totalResult);
    }

    private void displayWinners(Winners winners) {
        new DisplayWinnerController().proceed(winners);
    }
}