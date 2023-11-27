package racingcar.model;

public class AttemptCount {
    private static final int MINIMUM_VALUE = 0;
    private final int count;

    private AttemptCount(int count) {
        this.count = count;
    }

    public static AttemptCount of(int count) {
        validate(count);
        return new AttemptCount(count);
    }

    private static void validate(int count) {
        if (count < MINIMUM_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    public int count() {
        return count;
    }
}
