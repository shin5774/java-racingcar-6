package racingcar.view;

import racingcar.dto.CarResult;
import racingcar.dto.RoundResult;
import racingcar.dto.TotalResult;

public class TotalResultView extends OutputView<TotalResult> {
    private static final String TITLE = "실행 결과";
    private static final String RESULT_FORMAT = "%s : %s";
    private static final String FORWARD_STATE_MARKER = "-";

    @Override
    void displayTitle() {
        System.out.println();
        System.out.println(TITLE);
    }

    @Override
    void displayResult(TotalResult result) {
        result.totalResult().forEach(this::displayRoundResult);
    }

    private void displayRoundResult(RoundResult roundResult) {
        roundResult.roundResult().forEach(this::displayCarResult);
        System.out.println();
    }

    private void displayCarResult(CarResult carResult) {
        System.out.println(String.format(RESULT_FORMAT, carResult.name(), getForwardState(carResult.position())));
    }

    private String getForwardState(int forwardState) {
        return FORWARD_STATE_MARKER.repeat(forwardState);
    }
}