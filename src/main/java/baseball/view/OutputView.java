package baseball.view;

public class OutputView {
    public static void printHint(String hintLiteral) {
        System.out.println(hintLiteral);
    }

    public void startGameComment() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void readNumberComment() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void endGameComment() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }
}
