package racingcar.util;

import racingcar.dto.AttemptCountDto;
import racingcar.model.AttemptCount;

public class AttemptCountMapper implements Mapper<AttemptCountDto, AttemptCount> {
    @Override
    public AttemptCountDto toDto(String request) {
        return new AttemptCountDto(toInt(request));
    }

    private int toInt(String request) {
        return Integer.parseInt(request);
    }

    @Override
    public AttemptCount toDomain(AttemptCountDto dto) {
        return AttemptCount.of(dto.count());
    }
}
