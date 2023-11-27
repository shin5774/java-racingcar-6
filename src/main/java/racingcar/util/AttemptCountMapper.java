package racingcar.util;

import static racingcar.constants.ExceptionMessage.NON_NATURAL_NUMBER;

import java.util.regex.Pattern;
import racingcar.dto.AttemptCountDto;
import racingcar.model.AttemptCount;

public class AttemptCountMapper implements Mapper<AttemptCountDto, AttemptCount> {
    private static final Pattern NUMERIC = Pattern.compile("[0-9]+");

    @Override
    public AttemptCountDto toDto(String request) {
        validate(request);
        return new AttemptCountDto(toInt(request));
    }

    private void validate(String request) {
        if (!NUMERIC.matcher(request).matches()) {
            throw new IllegalArgumentException(NON_NATURAL_NUMBER.message());
        }
    }

    private int toInt(String request) {
        return Integer.parseInt(request);
    }

    @Override
    public AttemptCount toDomain(AttemptCountDto dto) {
        return AttemptCount.of(dto.count());
    }
}
