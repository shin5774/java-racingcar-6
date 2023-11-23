package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameController controller = new RacingGameController(new InputView(), new OutputView(),
                new RacingGameService());

        controller.start();
    }
}
