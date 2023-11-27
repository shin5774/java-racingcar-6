package racingcar;

import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        RacingGameApplication controller = new RacingGameApplication(new InputView());

        controller.start();
    }
}
