package racingcar.controller.display;

import racingcar.dto.Winners;
import racingcar.view.OutputView;

public class DisplayWinnerController implements DisplayController<Winners> {
    private final OutputView outputView;

    public DisplayWinnerController(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    public void proceed(Winners result) {
        outputView.displayFinalWinnerMessage(result);
    }
}
