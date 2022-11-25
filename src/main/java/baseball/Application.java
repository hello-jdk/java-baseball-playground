package baseball;

import baseball.domain.BaseBallGameManager;
import baseball.domain.NumberManager;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberManager numberManager = new NumberManager(new RandomListGeneratorImpl());

        BaseBallGameManager baseBallGameManager = new BaseBallGameManager(inputView, outputView, numberManager);
        baseBallGameManager.startGame();
        baseBallGameManager.playGame();
        baseBallGameManager.afterGame();
    }
}
