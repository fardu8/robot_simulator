package test.commands.impl;

import main.commands.Command;
import main.commands.impl.LeftCommandImpl;
import main.entity.Robot;
import main.entity.Table;
import main.utils.Directions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeftCommandImplTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    //method to test left command when there is an active robots on the table
    @Test
    public void testExecute() {
        Robot robot = new Robot(2, 2, 0, Directions.NORTH);
        Table table = new Table();
        table.setActiveRobotIdentifier(0);
        table.getRobotsOnTable().add(robot);

        Command leftCommand = new LeftCommandImpl();

        leftCommand.execute(table);
        assertEquals(Directions.WEST, table.getActiveRobot().getDirection());

        leftCommand.execute(table);
        assertEquals(Directions.SOUTH, table.getActiveRobot().getDirection());

        leftCommand.execute(table);
        assertEquals(Directions.EAST, table.getActiveRobot().getDirection());
        leftCommand.execute(table);
        assertEquals(Directions.NORTH, table.getActiveRobot().getDirection());

        assertEquals(2, table.getActiveRobot().getX());
        assertEquals(2, table.getActiveRobot().getY());
    }

    // method to test left command when there is no robot on the table.
    @Test
    public void testExecuteWithNoActiveRobot() {
        Table table = new Table();
        Command leftCommand = new LeftCommandImpl();
        System.setOut(new PrintStream(output));
        leftCommand.execute(table);
        assertEquals("No active robot to turn left.\n", output.toString());
    }
}
