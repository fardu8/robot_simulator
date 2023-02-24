package main.commands.impl;

import main.commands.Command;
import main.entity.Robot;
import main.entity.Table;
import main.utils.Constants;
import main.utils.Directions;

public class PlaceCommandImpl implements Command {

    private String params;

    @Override
    public String getParams() {
        return params;
    }

    @Override
    public void setParams(String params) {
        this.params = params;
    }

    public PlaceCommandImpl(String params) {
        this.params = params;
    }

    public PlaceCommandImpl() {
        this.params = Constants.EMPTY_STRING;
    }

    @Override
    public void execute(Table table) {
        try {
            String[] parameters = this.params.split(Constants.COMMA);
            if (params.equalsIgnoreCase(Constants.EMPTY_STRING) ||
                    parameters.length != Constants.NUMBER_OF_PARAMETERS_FOR_PLACE_COMMAND) {
                int numberOfParameters = params.equalsIgnoreCase(Constants.EMPTY_STRING) ? 0 : parameters.length;
                System.out.println("Invalid number of parameters. Expected 3, got " + numberOfParameters);
                return;
            }
            int x = Integer.parseInt(parameters[0].trim());
            int y = Integer.parseInt(parameters[1].trim());
            String facing = parameters[2].trim();
            if (table.isValidPosition(x, y) && table.isValidDirection(facing)) {
                int robotIdentifier = table.getRobotsOnTable().size() == 0 ? 0 : table.getRobotsOnTable().size();
                Robot robot = new Robot(x, y, robotIdentifier, Directions.valueOf(facing.toUpperCase()));
                table.getRobotsOnTable().add(robot);
                if (table.getActiveRobotIdentifier() < 0) {
                    table.setActiveRobotIdentifier(robotIdentifier);
                }
            } else {
                if (!table.isValidPosition(x, y)) {
                    System.out.println("Position is out of bounds for table.\nPlease enter a valid position.");
                } else {
                    System.out.println("Invalid direction.\nPlease enter a valid direction.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Entered position is not a number.\nPlease enter a valid number.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
