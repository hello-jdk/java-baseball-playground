package baseball.domain;

import baseball.RandomListGeneratorImpl;
import baseball.utils.Generator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameManager {
    private final InputView inputView;
    private final OutputView outputView;
    private NumberManager numberManager;
    private HintManager hintManager;

    private boolean restart = false;

    public BaseBallGameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberManager = new NumberManager(new RandomListGeneratorImpl());
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
        } while (hintManager.checkCorrect());
    }

    public void afterGame() {
        numberManager = new NumberManager(new RandomListGeneratorImpl());
        outputView.endGameComment();
        outputView.printRestart();
        updateRestart(inputView.readRestart());
    }

    private void updateRestart(String readRestart) {
        if (readRestart.equals("1")) {
            this.restart = true;
        }
        if (readRestart.equals("2")) {
            this.restart = false;
        }
    }

    public boolean isRestart() {
        return restart;
    }
}
