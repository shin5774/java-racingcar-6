package racingcar.controller.display;

import racingcar.dto.Winners;
import racingcar.view.WinnersView;

public class DisplayWinnerController implements DisplayController<Winners> {
    @Override
    public void proceed(Winners result) {
        new WinnersView().display(result);
    }
}
