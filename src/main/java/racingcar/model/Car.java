package racingcar.model;

import racingcar.dto.CarResult;

public class Car implements Comparable<Car> {
    private final Name name;
    private final Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(Name name) {
        return new Car(name, Position.create());
    }

    public Name getName() {
        return name;
    }

    public String getNameValue() {
        return name.getName();
    }

    public void attemptForward() {
        position.attemptForward();
    }

    public CarResult getCarState() {
        return new CarResult(name.getName(), position.value());
    }

    public boolean isSamePosition(Car car) {
        return position.equals(car.position);
    }

    @Override
    public int compareTo(Car object) {
        if (position.value() > object.position.value()) {
            return 1;
        }
        if (position == object.position) {
            return 0;
        }
        return -1;
    }
}