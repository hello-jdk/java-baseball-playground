package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintManagerTest {
    private HintManager hintManager;

    @BeforeEach
    void beforeEeach() {
        hintManager = new HintManager();
    }

    @DisplayName("힌트매니저는 Map의 값에 대해 equals와 hashCode가 오버라이드 되어있다.")
    @Test
    void equalsAndHashCode() {
        HintManager newManager = new HintManager();
        assertThat(hintManager).isEqualTo(newManager);
    }

    @DisplayName("출력용 Literal 스트라이크")
    @Test
    void 스트라이크() {
        hintManager.updateStrike();
        assertThat(hintManager.getLiteralForOutput()).isEqualTo("1스트라이크");
        hintManager.updateStrike();
        assertThat(hintManager.getLiteralForOutput()).isEqualTo("2스트라이크");
        hintManager.updateStrike();
        assertThat(hintManager.getLiteralForOutput()).isEqualTo("3스트라이크");
    }

    @DisplayName("출력용 Literal 볼")
    @Test
    void 볼() {
        hintManager.updateBall();
        assertThat(hintManager.getLiteralForOutput()).isEqualTo("1볼");
        hintManager.updateBall();
        assertThat(hintManager.getLiteralForOutput()).isEqualTo("2볼");
        hintManager.updateBall();
        assertThat(hintManager.getLiteralForOutput()).isEqualTo("3볼");
    }

    @DisplayName("정답일 시")
    @Test
    void 정답() {
        hintManager.updateStrike();
        hintManager.updateStrike();
        hintManager.updateStrike();
        assertThat(hintManager.checkCorrect()).isFalse();
    }
}