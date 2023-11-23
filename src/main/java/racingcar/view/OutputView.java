package racingcar.view;

import racingcar.constants.Message;
import racingcar.dto.CarResult;
import racingcar.dto.RoundResult;
import racingcar.dto.TotalResult;
import racingcar.dto.Winners;

public class OutputView {
    private final String FORWARD_STATE_MARKER = "-";

    public void displayTotalResult(TotalResult totalResult) {
        blankLine();
        System.out.println(Message.ROUNDS_RESULT.message());

        totalResult.totalResult().forEach(this::displayRoundResult);
    }

    private void displayRoundResult(RoundResult roundResult) {
        roundResult.roundResult().forEach(this::displayCarResult);
        blankLine();
    }

    private void displayCarResult(CarResult carResult) {
        System.out.println(carResult.name() + " : " + getForwardState(carResult.position()));
    }

    private String getForwardState(int forwardState) {
        return FORWARD_STATE_MARKER.repeat(forwardState);
    }

    public void displayFinalWinnerMessage(Winners winners) {
        System.out.print(Message.WINNERS.message() + winners.name());
    }

    private void blankLine() {
        System.out.println();
    }
}
