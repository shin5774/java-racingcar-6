package racingcar.model;

import java.util.Objects;
import racingcar.util.ForwardDecider;

public class Position {
    private static final int START_POSITION_VALUE = 0;
    private int value;

    private Position(int value) {
        this.value = value;
    }

    public static Position create() {
        return new Position(START_POSITION_VALUE);
    }

    public void attemptForward() {
        if (ForwardDecider.INSTANCE.isForwardPossible()) {
            moveForward();
        }
    }

    private void moveForward() {
        value++;
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}