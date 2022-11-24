11/24 14:15

# 기능 요구 사항

- 개요

숫자 야구 게임 구현

- 요구사항

1. 사용자가 서로다른 1부터 9까지 숫자 3개를 입력
2. 컴퓨터의 숫자에 따라 힌트를 출력
    1. 같은 숫자 같은 자리 - 스트라이크
    2. 같은 숫자 다른 자리 - 볼
    3. 다른 숫자 다른 자리 - 낫싱
3. 3개의 숫자를 모두 맞힐 시 게임종료
4. 게임 종료후 게임을 다시 시작하거나 완전히 종료할 수 있다.

# 주체 정하기

랜덤 숫자를 만드는 자 -> 컴퓨터 (RandomListGenerator)
컴퓨터 숫자를 관리하고 유저의 숫자를 비교 (생성은 랜덤 숫자를 만드는 자에게 받음)
힌트를 관리하는 자
콘솔의 입출력을 관리하는 자 (View -> InputView, OutputView)
게임 전체의 흐름을 관리하는 자 (게임 종료 후 게임을 다시시작 or 완전히 종료)

# 구현

- 랜덤 숫자를 만드는 자
    - RandomListGeneratorImpl (구현체)
        - [x] 1 부터 9 까지 생성
        - [x] 3 개 생성

- 정답 숫자를 관리하는 자
    - ComputerNumbers
        - [x] 생성은 RandomListGenerator를 통해 생성자 주입을 받는다.
        - [x] 해당 리스트와 비교하여 HintManger를 발행한다.

- Hint를 담고있는 자 (DTO)
    - HintManager
        - [x] 스트라이크 증가
        - [x] 볼 증가
        - [x] 스트라이크 갯수
        - [x] 볼 갯수

- 입출력 View
    - 유저 숫자 읽기
        - [x] 숫자인가
        - [x] 3자리 숫자인가
        - [x] 1부터 9까지의 숫자로만 이루어져있는가
        - [x] 중복된 숫자가 없는가

--------------------------

- 저장할 필요가 없는 데이터에 대해서는 객체를 만들지 않아야 한다.