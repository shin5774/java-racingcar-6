package racingcar.controller.display;

import racingcar.dto.TotalResult;
import racingcar.view.display.TotalResultView;

public class DisplayTotalResultController implements DisplayController<TotalResult> {
    @Override
    public void proceed(TotalResult result) {
        new TotalResultView().display(result);
    }
}
