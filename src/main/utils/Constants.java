package main.utils;

public class Constants {
    public static final int TABLE_LENGTH = 5;
    public static final int TABLE_WIDTH = 5;
    public static final int SOUTH_WEST_MOST_CORNER_X = 0;
    public static final int SOUTH_WEST_MOST_CORNER_Y = 0;
    public static final int NUMBER_OF_PARAMETERS_FOR_PLACE_COMMAND = 3;
    public static final int NUMBER_OF_PARAMETERS_FOR_ROBOT_COMMAND = 1;
    public static final String SPACE = " ";
    public static final String COMMA = ",";
    public static final String EMPTY_STRING = "";
    public static final String COMMAND_PLACE = "PLACE";
    public static final String COMMAND_MOVE = "MOVE";
    public static final String COMMAND_LEFT = "LEFT";
    public static final String COMMAND_RIGHT = "RIGHT";
    public static final String COMMAND_REPORT = "REPORT";
    public static final String COMMAND_ROBOT = "ROBOT";
    public static final String[] COMMAND_LIST = {COMMAND_PLACE, COMMAND_MOVE, COMMAND_LEFT, COMMAND_RIGHT, COMMAND_REPORT, COMMAND_ROBOT};
    public static final String INVALID_COMMAND_MESSAGE = "Command entered is not in the list of valid commands.\nExiting the program.";
    public static final String COMMAND_LIST_MESSAGE_LINE_1 = "Here are the list of valid commands: ";
    public static final String COMMAND_LIST_MESSAGE_LINE_2 = "\nFor usage please refer to Readme.md file.\nEnter any other text to exit.";
    public static final String ENTER_COMMAND_MESSAGE = "Please enter a command: ";
}
