package main.entity;

import main.utils.Directions;

public class Robot {

    private int x;
    private int y;
    private int robotIdentifier;
    private Directions direction;

    public Robot(int x, int y, int robotIdentifier, Directions direction) {
        this.x = x;
        this.y = y;
        this.robotIdentifier = robotIdentifier;
        this.direction = direction;
    }

    public Robot() {
        this.x = -1;
        this.y = -1;
        this.robotIdentifier = -1;
        this.direction = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRobotIdentifier() {
        return robotIdentifier;
    }

    public void setRobotIdentifier(int robotIdentifier) {
        this.robotIdentifier = robotIdentifier;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return String.format("Robot %d position : %d, %d and direction : %s", robotIdentifier + 1, x, y, direction.toString());
    }
}
