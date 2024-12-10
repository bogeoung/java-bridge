package bridge;

public enum Message {
    GAME_START("다리 건너기 게임을 시작합니다.%s%s"),
    GET_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    GET_MOVE_REQUEST("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GET_RETRY_REQUEST("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String content;

    Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
