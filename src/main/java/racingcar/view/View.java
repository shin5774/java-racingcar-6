package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.constants.Message;
import racingcar.dto.CarState;
import racingcar.dto.CarsState;
import racingcar.model.Winners;

public class View {
    public View() {

    }

    public String inputConsole() {
        return readLine();
    }

    public void printCurrentCarsState(CarsState carsState) {
        carsState.carsState().forEach(this::printCurrentCarResult);
        System.out.println();
    }

    public void printCurrentCarResult(CarState carResult) {
        System.out.println(carResult.name() + " : " + carResult.forwardState());
    }

    public void printNameInputMessage() {
        System.out.println(Message.NAME_INPUT.message());
    }

    public void printAttemptCountInputMessage() {
        System.out.println(Message.ATTEMPT_COUNT_INPUT.message());
    }

    public void printAttemptResultMessage() {
        System.out.println();
        System.out.println(Message.ROUNDS_RESULT.message());
    }

    public void printFinalWinnerMessage(Winners winnersResult) {
        System.out.println();
        System.out.print(Message.WINNERS.message() + winnersResult.getWinners());
    }
}
