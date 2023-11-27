package racingcar;

import camp.nextstep.edu.missionutils.Console;
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

public class RacingGameApplication {
    public void start() {
        Cars cars = requestCars();
        AttemptCount attemptCount = requestAttemptAmount();

        TotalResult totalResult = playGame(cars, attemptCount);
        Winners winners = findWinners(cars);

        displayTotalResult(totalResult);
        displayWinners(winners);
    }

    public void finish() {
        Console.close();
    }

    private Cars requestCars() {
        return new RequestCarsController().proceed();
    }

    private AttemptCount requestAttemptAmount() {
        return new RequestAttemptCountController().proceed();
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