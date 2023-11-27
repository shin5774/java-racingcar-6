package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
    @DisplayName("이름 정상 저장 확인.")
    @Test
    void createTest_생성_테스트() {
        String input = "tName";
        Name name = Name.from(input);

        assertThat(name.getName()).isEqualTo(input);
    }

    @DisplayName("이름의 적합성을 판단하는 기능")
    @ParameterizedTest
    @ValueSource(strings = {"eleven", "abcdef", "qwerdf", "111234", "1q2w3e4r", ""})
    void validateName_이름의_적합성_판단(String name) {
        assertThatThrownBy(() -> Name.from(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
