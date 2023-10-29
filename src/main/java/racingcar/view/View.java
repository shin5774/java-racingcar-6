package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.Message;
import racingcar.dto.CurrentResult;
import racingcar.dto.ResultMessage;

public class View {
    public View() {

    }

    public String inputConsole() {
        return readLine();
    }

    public void printCurrentCarsResult(List<CurrentResult> currentResult) {
        currentResult.forEach(this::printCurrentCarResult);
        System.out.println();
    }

    public void printCurrentCarResult(CurrentResult carResult) {
        System.out.println(carResult.getName() + " : " + carResult.getForwardStatus());
    }

    public void printNameInputMessage() {
        System.out.println(Message.NAMEINPUT.message());
    }

    public void printAttemptCountInputMessage() {
        System.out.println(Message.ATTEMPTCOUNTINPUT.message());
    }

    public void printAttemptResultMessage() {
        System.out.println();
        System.out.println(Message.ATTEMPTRESULT.message());
    }

    public void printFinalWinnerMessage(ResultMessage result) {
        System.out.println();
        System.out.print(Message.WINNERS.message() + result.getResultMessage());
    }
}