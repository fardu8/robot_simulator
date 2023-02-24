package test.commands.impl;

import main.commands.Command;
import main.commands.impl.MoveCommandImpl;
import main.entity.Robot;
import main.entity.Table;
import main.utils.Directions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveCommandImplTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Method to test valid move command
    @Test
    public void testExecuteValidMove() {
        Table table = new Table();
        Robot robot = new Robot(1, 2, 0, Directions.NORTH);
        table.setActiveRobotIdentifier(0);
        table.getRobotsOnTable().add(robot);

        Command moveCommand = new MoveCommandImpl();
        moveCommand.execute(table);

        assertEquals(1, robot.getX());
        assertEquals(3, robot.getY());
    }

    /* Method to test invalid move command where the active robot is at the edge of the table and the move command will
     make the robot fall */
    @Test
    public void testExecuteInvalidMove() {
        Table table = new Table();
        Robot robot = new Robot(0, 0, 0, Directions.SOUTH);
        table.setActiveRobotIdentifier(0);
        table.getRobotsOnTable().add(robot);

        Command moveCommand = new MoveCommandImpl();
        moveCommand.execute(table);

        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
    }

    // Method to test move command when there is no active robot
    @Test
    public void testExecuteNoActiveRobot() {
        Table table = new Table();
        System.setOut(new PrintStream(output));

        Command moveCommand = new MoveCommandImpl();
        moveCommand.execute(table);
        assertEquals("No active robot to move.\n", output.toString());
    }

}