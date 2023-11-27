package racingcar.view.request;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.dto.AttemptCountDto;
import racingcar.util.AttemptCountMapper;

public class AttemptCountView extends InputView<AttemptCountDto> {
    private static final String MESSAGE = "시도할 회수는 몇회인가요?";

    void displayRequestMessage() {
        System.out.println(MESSAGE);
    }

    AttemptCountDto requestFromUser() {
        return new AttemptCountMapper().toDto(readLine());
    }
}
