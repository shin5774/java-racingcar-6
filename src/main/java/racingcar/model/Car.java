package racingcar.model;

import racingcar.dto.CarResult;

public class Car implements Comparable<Car> {
    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getNameValue() {
        return name.getName();
    }

    public void attemptForward() {
        position.attemptForward();
    }

    public CarResult getCarResult() {
        return new CarResult(getNameValue(), getPosition().position());
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car object) {
        if (position.position() > object.position.position()) {
            return 1;
        }

        if (position == object.position) {
            return 0;
        }

        return -1;
    }
}