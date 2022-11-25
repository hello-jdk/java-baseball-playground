package baseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HintManager {
    Map<Hint, Integer> hintData;

    public HintManager() {
        this.hintData = new HashMap<>();
        hintData.put(Hint.BALL, 0);
        hintData.put(Hint.STRIKE, 0);
    }

    public void updateStrike() {
        Integer before = hintData.get(Hint.STRIKE);
        hintData.put(Hint.STRIKE, before + 1);
    }

    public void updateBall() {
        Integer before = hintData.get(Hint.BALL);
        hintData.put(Hint.BALL, before + 1);
    }

    public String getLiteralForOutput() {
        Integer ballCount = hintData.get(Hint.BALL);
        Integer strikeCount = hintData.get(Hint.STRIKE);
        return makeLiteral(ballCount, strikeCount);
    }

    public boolean isCorrect() {
        final int EXACT_CORRECT = 3;
        Integer strikeCount = hintData.get(Hint.STRIKE);
        return strikeCount == EXACT_CORRECT;
    }

    private String makeLiteral(Integer ballCount, Integer strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }
        if (ballCount == 0) {
            return strikeCount + "스트라이크";
        }
        if (strikeCount == 0) {
            return ballCount + "볼";
        }
        return ballCount + "볼 " + strikeCount + "스트라이크";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HintManager)) {
            return false;
        }
        HintManager that = (HintManager) o;
        return Objects.equals(hintData, that.hintData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hintData);
    }

}
