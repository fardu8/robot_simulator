package main.entity;

import main.utils.Constants;
import main.utils.Directions;

import java.util.ArrayList;

public class Table {

    private int tableLength;
    private int tableWidth;
    private ArrayList<Robot> robotsOnTable;
    private int activeRobotIdentifier;

    public Table() {
        this.tableLength = Constants.TABLE_LENGTH;
        this.tableWidth = Constants.TABLE_WIDTH;
        this.robotsOnTable = new ArrayList<>();
        this.activeRobotIdentifier = -1;
    }

    public int getTableLength() {
        return tableLength;
    }

    public void setTableLength(int tableLength) {
        this.tableLength = tableLength;
    }

    public int getTableWidth() {
        return tableWidth;
    }

    public void setTableWidth(int tableWidth) {
        this.tableWidth = tableWidth;
    }

    public ArrayList<Robot> getRobotsOnTable() {
        return robotsOnTable;
    }

    public void setRobotsOnTable(ArrayList<Robot> robotsOnTable) {
        this.robotsOnTable = robotsOnTable;
    }

    public int getActiveRobotIdentifier() {
        return activeRobotIdentifier;
    }

    public void setActiveRobotIdentifier(int activeRobotIdentifier) {
        this.activeRobotIdentifier = activeRobotIdentifier;
    }

    public boolean isValidPosition(int x, int y) {
        return x >= Constants.SOUTH_WEST_MOST_CORNER_X && x <= Constants.TABLE_LENGTH && y >= Constants.SOUTH_WEST_MOST_CORNER_Y && y <= Constants.TABLE_WIDTH;
    }

    public boolean isValidDirection(String facing) {
        for (Directions direction : Directions.values()) {
            if (direction.toString().equals(facing.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public Robot getActiveRobot() {
        return activeRobotIdentifier>=0 ?robotsOnTable.get(activeRobotIdentifier) : null;
    }

    public void updateActiveRobot(Robot activeRobot) {
        this.robotsOnTable.set(activeRobotIdentifier, activeRobot);
    }

    public boolean isRobotAvailableOnTable(int robotIdentifier) {
        return 0 <= robotIdentifier && robotIdentifier < robotsOnTable.size();
    }
}
