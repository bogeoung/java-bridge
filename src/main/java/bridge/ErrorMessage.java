package bridge;

public enum ErrorMessage {
    INVALID_BRIDGE_LENGTH("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_MOVE_REQUEST("이동에는 위: U, 아래: D 만 입력가능합니다.");

    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String content;

    ErrorMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return ERROR_MESSAGE_PREFIX + content;
    }

}
