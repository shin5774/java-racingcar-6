package racingcar.service;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.constants.ExceptionMessage;
import racingcar.dto.AttemptCountDto;
import racingcar.dto.CarsDto;
import racingcar.dto.RoundResult;
import racingcar.dto.TotalResult;
import racingcar.dto.Winners;
import racingcar.model.AttemptCount;
import racingcar.model.RacingGame;
import racingcar.util.AttemptCountMapper;

public class RacingGameService {
    private final RacingGame racingGame;
    private AttemptCount attemptCount;

    public RacingGameService(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void generateCars(CarsDto inputNames) {
        racingGame.generateCars(inputNames);
    }

    public void setAttemptCount(AttemptCountDto inputCount) {
        attemptCount = new AttemptCountMapper().toDomain(inputCount);
    }

    public TotalResult playRounds() {
        if (isNotInputAttemptCount()) {
            throw new NullPointerException(ExceptionMessage.NULL_ATTEMPT_COUNT.message());
        }

        List<RoundResult> totalResult = IntStream.range(0, attemptCount.count())
                .mapToObj(attempt -> racingGame.playRound())
                .toList();

        return new TotalResult(totalResult);
    }

    private boolean isNotInputAttemptCount() {
        return attemptCount == null;
    }

    public Winners getWinners() {
        return racingGame.getWinners();
    }
}