package racingcar.controller.request;

import racingcar.dto.CarsDto;
import racingcar.model.Cars;
import racingcar.util.CarsMapper;
import racingcar.view.InputView;

public class RequestCarsController implements RequestController<Cars> {
    private final InputView inputView;

    public RequestCarsController(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public Cars proceed() {
        CarsDto carsDto = inputView.requestCarsName();
        return new CarsMapper().toDomain(carsDto);
    }
}
