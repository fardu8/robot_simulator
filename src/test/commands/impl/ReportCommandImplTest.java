package test.commands.impl;

import main.commands.Command;
import main.commands.impl.ReportCommandImpl;
import main.entity.Robot;
import main.entity.Table;
import main.utils.Directions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportCommandImplTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    private Table table;
    private Command reportCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
        table = new Table();
        reportCommand = new ReportCommandImpl();
    }

    //Method to test the report command with no robots on the table
    @Test
    public void testExecuteWithNoRobots() {
        reportCommand.execute(table);
        assertEquals("There are no robots on the table.\n", output.toString());
    }

    // Method to test the report command with one robot on the table
    @Test
    public void testExecuteWithOneRobot() {
        Robot robot = new Robot(2, 2, 0, Directions.NORTH);
        table.getRobotsOnTable().add(robot);
        table.setActiveRobotIdentifier(0);
        reportCommand.execute(table);
        assertEquals("There is only one robot on the table.\nRobot 1 is currently active\nRobot 1 position : 2, 2 and direction : NORTH\n", output.toString());
    }

    // Method to test the report command with multiple robots on the table
    @Test
    public void testExecuteWithMultipleRobots() {
        Robot robot1 = new Robot(1, 1, 0, Directions.NORTH);
        Robot robot2 = new Robot(2, 2, 1, Directions.SOUTH);
        table.getRobotsOnTable().add(robot1);
        table.getRobotsOnTable().add(robot2);
        table.setActiveRobotIdentifier(1);
        reportCommand.execute(table);
        assertEquals("There are 2 robots on the table\nRobot 2 is currently active\nRobot 2 position : 2, 2 and direction : SOUTH\n", output.toString());
    }
}
