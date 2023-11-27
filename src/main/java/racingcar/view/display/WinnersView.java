package racingcar.view.display;

import java.util.List;
import java.util.StringJoiner;
import racingcar.dto.Winners;

public class WinnersView extends OutputView<Winners> {
    private static final String TITLE = "최종 우승자 : ";
    private static final String DELIMITER = ", ";

    @Override
    void displayTitle() {
        System.out.print(TITLE);
    }

    @Override
    void displayResult(Winners result) {
        System.out.println(getWinners(result.names()));
    }

    private String getWinners(List<String> names) {
        StringJoiner winners = new StringJoiner(DELIMITER);

        names.forEach(winners::add);

        return winners.toString();
    }
}
