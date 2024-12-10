package bridge;

import java.awt.desktop.OpenURIEvent;

public class InputValidator {

    public static final int MINIMUM_BRIDGE_SIZE = 3;
    public static final int MAXIMUM_BRIDGE_SIZE = 20;
    public static final String MOVE_UP = "U";
    public static final String MOVE_DOWN = "D";
    public static final String RETRY_COMMAND = "R";
    public static final String QUIT_COMMAND = "Q";

    public static boolean validBridgeSizeInput(String input){
        return validBridgeFormat(input) && validBridgeSize(input);
    }
    
    private static boolean validBridgeFormat(String input){
        try{
           Integer.parseInt(input);

        } catch (NumberFormatException e) {
            return false;
        }
       return true;
    }
    
    private static boolean validBridgeSize(String input){
        int inputSize = Integer.parseInt(input);
        return inputSize >= MINIMUM_BRIDGE_SIZE && inputSize <= MAXIMUM_BRIDGE_SIZE;
    }
    
    public static boolean validMoveFormat(String input){
        return input.equals(MOVE_UP) || input.equals(MOVE_DOWN);
    }

    public static boolean validGameCommand(String input){
        return input.equals(RETRY_COMMAND) || input.equals(QUIT_COMMAND);
    }
}
