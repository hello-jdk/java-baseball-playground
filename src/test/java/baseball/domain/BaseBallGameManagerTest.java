package baseball.domain;

import baseball.RandomListGeneratorImpl;
import baseball.view.InputView;
import baseball.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameManagerTest {

    private BaseBallGameManager baseBallGameManager;

    @BeforeEach
    void beforeEach() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberManager numberManager = new NumberManager(new RandomListGeneratorImpl());
        baseBallGameManager = new BaseBallGameManager(inputView, outputView, numberManager);
    }

    @DisplayName("게임 시작")
    @Test
    void startGame() {
        baseBallGameManager.startGame();
    }

    @DisplayName("게임(숫자 입력 - 힌트 출력) 반복")
    @Test
    void playGame() {
        baseBallGameManager.PlayGame();
    }
}