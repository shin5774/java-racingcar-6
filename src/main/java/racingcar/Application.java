package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameApplication controller = new RacingGameApplication(new InputView(), new OutputView());

        controller.start();
    }
}
