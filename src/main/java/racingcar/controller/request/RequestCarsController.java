package racingcar.controller.request;

import racingcar.dto.CarsDto;
import racingcar.model.Cars;
import racingcar.util.CarsMapper;
import racingcar.view.request.CarsView;

public class RequestCarsController implements RequestController<Cars> {
    @Override
    public Cars proceed() {
        CarsDto carsDto = new CarsView().request();
        return new CarsMapper().toDomain(carsDto);
    }
}
