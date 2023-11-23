package racingcar.controller;

import racingcar.dto.AttemptCountDto;
import racingcar.dto.CarsDto;
import racingcar.dto.TotalResult;
import racingcar.dto.Winners;
import racingcar.service.RacingGameService;
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
        generateCars();
        setAttemptCount();
        playRounds();
        printWinners();
    }

    private void generateCars() {
        racingGameService.generateCars(inputCarsName());
    }

    private CarsDto inputCarsName() {
        return inputView.requestCarsName();
    }

    private void setAttemptCount() {
        racingGameService.setAttemptCount(inputAttemptCount());
    }

    private AttemptCountDto inputAttemptCount() {
        return inputView.requestAttemptCount();
    }

    private void playRounds() {
        printTotalResult(racingGameService.playRounds());
    }

    private void printTotalResult(TotalResult totalResult) {
        outputView.displayTotalResult(totalResult);
    }

    private void printWinners() {
        outputView.displayFinalWinnerMessage(getWinners());
    }

    private Winners getWinners() {
        return racingGameService.getWinners();
    }
}