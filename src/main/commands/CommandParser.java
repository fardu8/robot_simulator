package main.commands;

import main.commands.impl.*;
import main.utils.Constants;

public class CommandParser {
    private PlaceCommandImpl placeCommand;
    private MoveCommandImpl moveCommand;
    private LeftCommandImpl leftCommand;
    private RightCommandImpl rightCommand;
    private ReportCommandImpl reportCommand;
    private RobotCommandImpl robotCommand;

    public CommandParser() {
        placeCommand = null;
        moveCommand = null;
        leftCommand = null;
        rightCommand = null;
        reportCommand = null;
        robotCommand = null;
    }

    public Command parse(String inputCommand) {
        try {
            String commandName = inputCommand.split(Constants.SPACE)[0].toUpperCase();
            String parameters = inputCommand.substring(commandName.length()).trim();

            switch (commandName) {

                case Constants.COMMAND_PLACE:
                    if (placeCommand == null) {
                        placeCommand = new PlaceCommandImpl(parameters);
                    } else {
                        placeCommand.setParams(parameters);
                    }
                    return placeCommand;

                case Constants.COMMAND_MOVE:
                    if (moveCommand == null) {
                        moveCommand = new MoveCommandImpl(parameters);
                    } else {
                        moveCommand.setParams(parameters);
                    }
                    return moveCommand;

                case Constants.COMMAND_LEFT:
                    if (leftCommand == null) {
                        leftCommand = new LeftCommandImpl(parameters);
                    } else {
                        leftCommand.setParams(parameters);
                    }
                    return leftCommand;

                case Constants.COMMAND_RIGHT:
                    if (rightCommand == null) {
                        rightCommand = new RightCommandImpl(parameters);
                    } else {
                        rightCommand.setParams(parameters);
                    }
                    return rightCommand;

                case Constants.COMMAND_REPORT:
                    if (reportCommand == null) {
                        reportCommand = new ReportCommandImpl(parameters);
                    } else {
                        reportCommand.setParams(parameters);
                    }
                    return reportCommand;

                case Constants.COMMAND_ROBOT:
                    if (robotCommand == null) {
                        robotCommand = new RobotCommandImpl(parameters);
                    } else {
                        robotCommand.setParams(parameters);
                    }
                    return robotCommand;
                default:
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
