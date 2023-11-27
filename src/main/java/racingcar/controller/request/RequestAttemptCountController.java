package racingcar.controller.request;

import racingcar.dto.AttemptCountDto;
import racingcar.model.AttemptCount;
import racingcar.util.AttemptCountMapper;
import racingcar.view.request.AttemptCountView;

public class RequestAttemptCountController implements RequestController<AttemptCount> {
    @Override
    public AttemptCount proceed() {
        AttemptCountDto attemptCountDto = new AttemptCountView().request();
        return new AttemptCountMapper().toDomain(attemptCountDto);
    }
}
