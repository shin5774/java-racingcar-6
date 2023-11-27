package racingcar.view.request;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.dto.CarsDto;
import racingcar.util.CarsMapper;

public class CarsView extends InputView<CarsDto> {
    private static final String MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    void displayRequestMessage() {
        System.out.println(MESSAGE);
    }

    CarsDto requestFromUser() {
        return new CarsMapper().toDto(readLine());
    }
}
