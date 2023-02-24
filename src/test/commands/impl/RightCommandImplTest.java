package test.commands.impl;

import main.commands.Command;
import main.commands.impl.RightCommandImpl;
import main.entity.Robot;
import main.entity.Table;
import main.utils.Directions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RightCommandImplTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Method to test the right command when there is an active robots on the table
    @Test
    public void testExecute() {
        Robot robot = new Robot(2, 2, 0, Directions.NORTH);
        Table table = new Table();
        table.setActiveRobotIdentifier(0);
        table.getRobotsOnTable().add(robot);

        Command rightCommand = new RightCommandImpl();

        rightCommand.execute(table);
        assertEquals(Directions.EAST, table.getActiveRobot().getDirection());

        rightCommand.execute(table);
        assertEquals(Directions.SOUTH, table.getActiveRobot().getDirection());

        rightCommand.execute(table);
        assertEquals(Directions.WEST, table.getActiveRobot().getDirection());
        rightCommand.execute(table);
        assertEquals(Directions.NORTH, table.getActiveRobot().getDirection());

        assertEquals(2, table.getActiveRobot().getX());
        assertEquals(2, table.getActiveRobot().getY());
    }

    // Method to test the right command when there are no robots on the table
    @Test
    public void testExecuteWithNoActiveRobot() {
        Table table = new Table();
        Command rightCommand = new RightCommandImpl();
        System.setOut(new PrintStream(output));
        rightCommand.execute(table);
        assertEquals("No active robot to turn right.\n", output.toString());
    }
}
