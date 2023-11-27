package racingcar.model;

import racingcar.constants.ExceptionMessage;

public class Name {
    private static final int LOW_BOUND = 1;
    private static final int HIGH_BOUND = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String name) {
        validate(name);
        return new Name(name);
    }

    private static void validate(String name) {
        checkNameLength(name);
    }

    private static void checkNameLength(String name) {
        if (isOutOfRange(name.length())) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NAME_RANGE.message());
        }
    }

    private static boolean isOutOfRange(int nameLength) {
        return nameLength > HIGH_BOUND || nameLength < LOW_BOUND;
    }

    public String getName() {
        return name;
    }
}