package racingcar.constants;

public enum ExceptionMessage {
    OUT_OF_RANGE_NAME_RANGE("이름의 길이가 범위를 벗어났습니다."),
    NON_NATURAL_NUMBER("0이상의 숫자를 입력해야합니다."),
    DUPLICATED_NAME("중복된 이름이 존재합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return PREFIX + message;
    }
}