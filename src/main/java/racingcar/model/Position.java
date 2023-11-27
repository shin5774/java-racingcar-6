package racingcar.model;

import java.util.Objects;
import racingcar.util.ForwardDecider;

public class Position {
    private static final int START_POSITION_VALUE = 0;
    private int position;

    private Position(int position) {
        this.position = position;
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
        position++;
    }

    public int position() {
        return position;
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
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}