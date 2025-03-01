package baseball.view;

import baseball.utils.Validator;
import java.util.Scanner;

public class InputView {
    private Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public String readNumber() {
        String number = sc.next();
        validateNumber(number);
        return number;
    }

    private static void validateNumber(String number) {
        Validator.checkIsNumber(number);
        Validator.checkSize(number);
        Validator.checkBoundary(number);
        Validator.checkDuplicate(number);
    }

    public String readRestart() {
        String number = sc.next();
        validateRestart(number);
        return number;
    }

    private void validateRestart(String number) {
        Validator.checkIsNumber(number);
        Validator.checkIsOneOrTwo(number);
    }
}
