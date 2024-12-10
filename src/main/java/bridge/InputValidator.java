package bridge;

import java.awt.desktop.OpenURIEvent;

public class InputValidator {

    public static final int MINIMUM_BRIDGE_SIZE = 3;
    public static final int MAXIMUM_BRIDGE_SIZE = 20;

    public static boolean validBridgeSizeInput(String input){
        return validBridgeformat(input) && validBridgeSize(input);
    }
    public static boolean validBridgeformat(String input){
        try{
           Integer.parseInt(input);

        } catch (NumberFormatException e) {
            return false;
        }
       return true;
    }

    public static boolean validBridgeSize(String input){
        int inputSize = Integer.parseInt(input);
        return inputSize >= MINIMUM_BRIDGE_SIZE && inputSize <= MAXIMUM_BRIDGE_SIZE;
    }
}
