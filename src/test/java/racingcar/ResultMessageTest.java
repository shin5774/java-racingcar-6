package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultMessageTest {
    @DisplayName("차들의 이름을 출력하는 기능.")
    @Test
    void printCarName() {
        //given
        List<Car> cars = Arrays.asList(new Car(new Name("pobi"), new Position()),
                new Car(new Name("jun"), new Position()));
        String expected = "pobi, jun";

        //when
        ResultMessage result = new ResultMessage(cars);

        //then
        assertThat(result.getResultMessage()).isEqualTo(expected);

    }
}
