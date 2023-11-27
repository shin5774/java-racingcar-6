package racingcar.controller.process;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.dto.RoundResult;
import racingcar.dto.TotalResult;
import racingcar.model.AttemptCount;
import racingcar.model.Cars;

public class ProceedGameController {
    private final Cars cars;
    private final AttemptCount attemptCount;

    public ProceedGameController(Cars cars, AttemptCount attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public TotalResult proceed() {
        List<RoundResult> totalResult = IntStream.range(0, attemptCount.count())
                .mapToObj(attempt -> playRound(cars))
                .toList();

        return new TotalResult(totalResult);
    }

    private RoundResult playRound(Cars cars) {
        cars.attemptForward();
        return cars.getRoundResult();
    }
}
