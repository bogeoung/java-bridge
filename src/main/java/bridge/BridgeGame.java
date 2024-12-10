package bridge;

import static bridge.InputValidator.MOVE_DOWN;
import static bridge.InputValidator.MOVE_UP;

import java.util.List;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int curLocation;

    List<String> bridge;
    public BridgeGame(List<String> bridge) {
        this.curLocation = 0;
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input) {
        if(bridge.get(curLocation).equals(input)){
            curLocation++;
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String retry() {
        InputView inputView = new InputView();
        return inputView.readGameCommand();
    }

    public boolean isEnd(){
        return curLocation == bridge.size();
    }

    public int getCurLocation() {
        return curLocation;
    }

    public String getCurLocationBridge(int index){
        return bridge.get(index);
    }

    public int getBridgeLength(){
        return bridge.size();
    }
}
