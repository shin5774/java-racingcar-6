package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.RacingGame;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        RacingGame racingGame = new RacingGame();
        RacingGameService racingGameService = new RacingGameService(racingGame);
        RacingGameController controller = new RacingGameController(new InputView(), new OutputView(),
                racingGameService);

        controller.start();
    }
}
