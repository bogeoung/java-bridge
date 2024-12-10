package bridge;

import static bridge.InputValidator.MOVE_DOWN;
import static bridge.InputValidator.MOVE_UP;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void invalidBridgeSize() {
        System.out.println(ErrorMessage.INVALID_BRIDGE_LENGTH.getContent());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Boolean isSuccess, BridgeGame bridgeGame) {
        StringBuffer sbUp = new StringBuffer();
        StringBuffer sbDown = new StringBuffer();

        sbUp.append("[");
        sbDown.append("[");

        for(int i=0; i<bridgeGame.getCurLocation(); i++){
            if(isSuccess){
                printSuccess(i, bridgeGame, sbUp, sbDown);
            }
            if(!isSuccess){
                printFailure(i, bridgeGame, sbUp, sbDown);
            }
            if(i != bridgeGame.getCurLocation() - 1){
                sbUp.append("|");
                sbDown.append("|");
            }
        }
        sbUp.append("]");
        sbDown.append("]");
        System.out.println(sbUp.toString());
        System.out.println(sbDown.toString());
        if(bridgeGame.isEnd()){
            System.out.println("최종 게임 결과");
            System.out.println(sbUp.toString());
            System.out.println(sbDown.toString());
        }

    }

    private void printSuccess(int index, BridgeGame bridgeGame, StringBuffer sbUp, StringBuffer sbDown) {
        if(bridgeGame.getCurLocationBridge(index).equals(MOVE_UP)){
            sbUp.append(" O ");
            sbDown.append(" ".repeat(3));
        }
        if(bridgeGame.getCurLocationBridge(index).equals(MOVE_DOWN)){
            sbUp.append(" ".repeat(3));
            sbDown.append(" O ");
        }
    }

    private void printFailure(int index, BridgeGame bridgeGame, StringBuffer sbUp, StringBuffer sbDown){
        if(bridgeGame.getCurLocationBridge(index).equals(MOVE_DOWN)){
            sbUp.append(" X ");
            sbDown.append(" ".repeat(3));
        }
        if(bridgeGame.getCurLocationBridge(index).equals(MOVE_UP)){
            sbUp.append(" ".repeat(3));
            sbDown.append(" X ");
        }

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, int count) {
        if(isSuccess) {
            System.out.println("게임 성공 여부: 성공");
        }
        if(!isSuccess) {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + count);

    }

    public void invalidMove() {
        System.out.println(ErrorMessage.INVALID_MOVE_REQUEST.getContent());
    }

    public void invalidRetryRequest() {
        System.out.println(ErrorMessage.INVALID_RETRY_REQUEST.getContent());
    }
}
