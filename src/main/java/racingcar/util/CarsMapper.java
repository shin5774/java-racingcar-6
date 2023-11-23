package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.constants.Constants;
import racingcar.dto.CarsDto;
import racingcar.model.Cars;

public class CarsMapper implements Mapper<CarsDto, Cars> {
    private static final String DELIMITER = ",";
    private static final String EMPTY = "";

    @Override
    public CarsDto toDto(String request) {
        List<String> requestCars = Arrays.stream(request.split(DELIMITER))
                .map(this::removeWhiteSpace)
                .toList();

        return new CarsDto(requestCars);
    }

    private String removeWhiteSpace(String name) {
        return name.replace(Constants.WHITESPACE, EMPTY);
    }

    @Override
    public Cars toDomain(CarsDto dto) {
        return Cars.of(dto.cars());
    }
}
