package racingcar.view;


public abstract class OutputView<T> {
    public void display(T result) {
        displayTitle();
        displayResult(result);
    }

    abstract void displayTitle();

    abstract void displayResult(T result);
}
