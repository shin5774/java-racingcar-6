package racingcar.controller.request;

import racingcar.dto.AttemptCountDto;
import racingcar.model.AttemptCount;
import racingcar.util.AttemptCountMapper;
import racingcar.view.InputView;

public class RequestAttemptCountController implements RequestController<AttemptCount> {
    private final InputView inputView;

    public RequestAttemptCountController(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public AttemptCount proceed() {
        AttemptCountDto attemptCountDto = inputView.requestAttemptCount();
        return new AttemptCountMapper().toDomain(attemptCountDto);
    }
}
