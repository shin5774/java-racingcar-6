package racingcar.model;

import java.util.Objects;
import racingcar.util.ForwardDecider;

public class Position {
    private int position;

    public Position() {
        position = 0;
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