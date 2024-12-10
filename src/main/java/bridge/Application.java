package bridge;

import static bridge.InputValidator.QUIT_COMMAND;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);
        int gameCount = 1;
        boolean isSuccess = true;
        while(true){
            if(!bridgeGame.move(inputView.readMoving())){
                if(!getRetry(bridgeGame)){
                    isSuccess = false;
                    break;
                }
                gameCount++;
            }
            outputView.printMap(isSuccess, bridgeGame);
            if(bridgeGame.isEnd()){
                break;
            }
        }
        outputView.printResult(isSuccess, gameCount);

    }

    private static boolean getRetry(BridgeGame bridgeGame){
        if(QUIT_COMMAND.equals(bridgeGame.retry())){
            return false;
        }
        return true;
    }
}
