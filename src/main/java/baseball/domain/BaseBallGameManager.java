package baseball.domain;

import baseball.utils.Generator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberManager numberManager;
    private HintManager hintManager;

    public BaseBallGameManager(InputView inputView, OutputView outputView, NumberManager numberManager) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberManager = numberManager;
        this.hintManager = new HintManager();
    }


    public void startGame() {
        outputView.startGameComment();
    }

    public void playGame() {
        do {
            outputView.readNumberComment();
            String rawNumber = inputView.readNumber();
            hintManager = numberManager.calculateHint(Generator.makeUserNumber(rawNumber));
            OutputView.printHint(hintManager.getLiteralForOutput());
        } while (hintManager.isCorrect());
        outputView.endGameComment();
    }

    public void afterGame() {

    }
}
