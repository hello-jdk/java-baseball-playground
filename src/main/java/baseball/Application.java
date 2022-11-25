package baseball;

import baseball.domain.BaseBallGameManager;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseBallGameManager baseBallGameManager =
                new BaseBallGameManager(new InputView(), new OutputView());
        baseBallGameManager.startGame();
        do {
            baseBallGameManager.playGame();
            baseBallGameManager.afterGame();
        } while (baseBallGameManager.isRestart());
    }
}
