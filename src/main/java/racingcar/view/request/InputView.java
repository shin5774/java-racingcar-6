package racingcar.view.request;

public abstract class InputView<T> {

    public T request() {
        displayRequestMessage();
        return requestFromUser();
    }

    abstract void displayRequestMessage();

    abstract T requestFromUser();

}
