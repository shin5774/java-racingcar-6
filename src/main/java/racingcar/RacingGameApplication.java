package racingcar;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.controller.display.DisplayTotalResultController;
import racingcar.controller.display.DisplayWinnerController;
import racingcar.controller.request.RequestAttemptCountController;
import racingcar.controller.request.RequestCarsController;
import racingcar.dto.RoundResult;
import racingcar.dto.TotalResult;
import racingcar.dto.Winners;
import racingcar.model.AttemptCount;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.WinnersNameExtractor;
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
        Winners winners = getWinners(cars);

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
        List<RoundResult> totalResult = IntStream.range(0, attemptCount.count())
                .mapToObj(attempt -> playRound(cars))
                .toList();

        return new TotalResult(totalResult);
    }

    private RoundResult playRound(Cars cars) {
        cars.attemptForward();
        return cars.getRoundResult();
    }

    private Winners getWinners(Cars cars) {
        return toWinners(cars.findWinningCars());
    }

    private Winners toWinners(List<Car> winnersCar) {
        return WinnersNameExtractor.INSTANCE.extractName(winnersCar);
    }

    private void displayTotalResult(TotalResult totalResult) {
        new DisplayTotalResultController(outputView).proceed(totalResult);
    }

    private void displayWinners(Winners winners) {
        new DisplayWinnerController(outputView).proceed(winners);
    }
}