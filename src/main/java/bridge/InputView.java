package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    OutputView outputView;

    public InputView() {
        this.outputView = new OutputView();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.printf(Message.GAME_START.getContent(), System.lineSeparator(), System.lineSeparator());
        String bridgeSize;
        while(true) {
            System.out.println(Message.GET_BRIDGE_LENGTH.getContent());
            bridgeSize = readline();
            if(!InputValidator.validBridgeSizeInput(bridgeSize)){
                outputView.invalidBridgeSize();
                continue;
            }
            return Integer.parseInt(bridgeSize);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private String readline(){
        return Console.readLine();
    }
}
