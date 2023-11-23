package racingcar.controller.display;

import racingcar.dto.TotalResult;
import racingcar.view.OutputView;

public class DisplayTotalResultController implements DisplayController<TotalResult> {
    private final OutputView outputView;

    public DisplayTotalResultController(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    public void proceed(TotalResult result) {
        outputView.displayTotalResult(result);
    }
}
