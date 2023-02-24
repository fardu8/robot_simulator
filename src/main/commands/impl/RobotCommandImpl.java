package main.commands.impl;

import main.commands.Command;
import main.entity.Table;
import main.utils.Constants;

public class RobotCommandImpl implements Command {

    private String params;

    @Override
    public String getParams() {
        return params;
    }

    @Override
    public void setParams(String params) {
        this.params = params;
    }

    public RobotCommandImpl(String params) {
        this.params = params;
    }

    public RobotCommandImpl() {
        this.params = Constants.EMPTY_STRING;
    }

    @Override
    public void execute(Table table) {
        try {
            if (params.equalsIgnoreCase(Constants.EMPTY_STRING) ||
                    params.split(Constants.SPACE).length != Constants.NUMBER_OF_PARAMETERS_FOR_ROBOT_COMMAND) {
                int numberOfParameters = params.equalsIgnoreCase(Constants.EMPTY_STRING) ? 0 : params.split(Constants.SPACE).length;
                System.out.println("Invalid number of parameters. Expected 1, got " + numberOfParameters);
                return;
            }
            int activeRobotIdentifier = Integer.parseInt(params.split(Constants.SPACE)[0].trim());
            if (table.isRobotAvailableOnTable(activeRobotIdentifier - 1)) {
                table.setActiveRobotIdentifier(activeRobotIdentifier - 1);
            } else {
                if (table.getActiveRobotIdentifier() >= 0) {
                    System.out.println("The robot is not available on the table.");
                    System.out.print("Robots on the table: ");
                    for (int i = 0; i < table.getRobotsOnTable().size(); i++) {
                        System.out.print(i + 1 + Constants.SPACE);
                    }
                    System.out.println();
                } else {
                    System.out.println("No robot is available on the table.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in parameter. Please enter a valid number.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
