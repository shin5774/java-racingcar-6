package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.constants.Message;
import racingcar.dto.AttemptCountDto;
import racingcar.dto.CarsDto;
import racingcar.util.AttemptCountMapper;
import racingcar.util.CarsMapper;

public class InputView {
    public CarsDto requestCarsName() {
        System.out.println(Message.NAME_INPUT.message());
        return new CarsMapper().toDto(readLine());
    }

    public AttemptCountDto requestAttemptCount() {
        System.out.println(Message.ATTEMPT_COUNT_INPUT.message());
        return new AttemptCountMapper().toDto(readLine());
    }
}
