package main.commands.impl;

import main.commands.Command;
import main.entity.Robot;
import main.entity.Table;
import main.utils.Constants;
import main.utils.Directions;

public class RightCommandImpl implements Command {

    private String params;

    @Override
    public String getParams() {
        return params;
    }

    @Override
    public void setParams(String params) {
        this.params = params;
    }

    public RightCommandImpl(String params) {
        this.params = params;
    }

    public RightCommandImpl() {
        this.params = Constants.EMPTY_STRING;
    }

    @Override
    public void execute(Table table) {
        try {
            if (table.getActiveRobotIdentifier() >= 0) {
                Robot activeRobot = table.getActiveRobot();
                if (activeRobot != null) {
                    Directions currentDirection = activeRobot.getDirection();
                    switch (currentDirection) {
                        case NORTH:
                            activeRobot.setDirection(Directions.EAST);
                            break;
                        case EAST:
                            activeRobot.setDirection(Directions.SOUTH);
                            break;
                        case SOUTH:
                            activeRobot.setDirection(Directions.WEST);
                            break;
                        case WEST:
                            activeRobot.setDirection(Directions.NORTH);
                            break;
                        default:
                            break;
                    }
                }
                table.updateActiveRobot(activeRobot);
            } else {
                System.out.println("No active robot to turn right.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
