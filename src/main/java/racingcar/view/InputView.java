package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.constants.Message;

public class InputView {
    public String requestCarsName() {
        System.out.println(Message.NAME_INPUT.message());
        return readLine();
    }

    public String requestAttemptCount() {
        System.out.println(Message.ATTEMPT_COUNT_INPUT.message());
        return readLine();
    }
}
