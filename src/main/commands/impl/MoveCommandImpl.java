package main.commands.impl;

import main.commands.Command;
import main.entity.Robot;
import main.entity.Table;
import main.utils.Constants;
import main.utils.Directions;

public class MoveCommandImpl implements Command {

    private String params;

    @Override
    public String getParams() {
        return params;
    }

    @Override
    public void setParams(String params) {
        this.params = params;
    }

    public MoveCommandImpl() {
        this.params = Constants.EMPTY_STRING;
    }

    public MoveCommandImpl(String params) {
        this.params = params;
    }

    @Override
    public void execute(Table table) {
        try {
            Robot activeRobot = table.getActiveRobot();
            if (activeRobot == null) {
                System.out.println("No active robot to move.");
                return;
            }
            int x = activeRobot.getX();
            int y = activeRobot.getY();
            Directions currentDirection = activeRobot.getDirection();
            switch (currentDirection) {
                case NORTH:
                    y += 1;
                    break;
                case SOUTH:
                    y -= 1;
                    break;
                case EAST:
                    x += 1;
                    break;
                case WEST:
                    x -= 1;
                    break;
            }
            if (table.isValidPosition(x, y)) {
                activeRobot.setX(x);
                activeRobot.setY(y);
            } else {
                System.out.println("Cannot move further, Robot will fall off the table.");
            }
            table.updateActiveRobot(activeRobot);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
