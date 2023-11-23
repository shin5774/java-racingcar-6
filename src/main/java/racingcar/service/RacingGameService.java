package racingcar.service;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.dto.RoundResult;
import racingcar.dto.TotalResult;
import racingcar.model.AttemptCount;
import racingcar.model.Cars;

public class RacingGameService {
    public TotalResult playRounds(Cars cars, AttemptCount attemptCount) {
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