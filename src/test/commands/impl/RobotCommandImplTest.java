package test.commands.impl;

import main.commands.impl.RobotCommandImpl;
import main.entity.Robot;
import main.entity.Table;
import main.utils.Directions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotCommandImplTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    Table table;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
        table = new Table();
        Robot robot1 = new Robot(1, 2, 0, Directions.NORTH);
        Robot robot2 = new Robot(3, 4, 1, Directions.SOUTH);
        table.getRobotsOnTable().add(robot1);
        table.getRobotsOnTable().add(robot2);
        table.setActiveRobotIdentifier(0);
    }

    //Method to test valid robot command
    @Test
    public void testExecuteWhenRobotAvailableOnTable() {
        RobotCommandImpl robotCommand = new RobotCommandImpl("2");
        robotCommand.execute(table);
        assertEquals(1, table.getActiveRobotIdentifier());
    }

    //Method to test invalid robot command where the specified robot is not available on the table
    @Test
    public void testExecuteWhenRobotNotAvailableOnTable() {
        RobotCommandImpl robotCommand = new RobotCommandImpl("3");
        robotCommand.execute(table);
        assertEquals("The robot is not available on the table.\nRobots on the table: 1 2 \n", output.toString());
    }

    //Method to test invalid robot command where the invalid number of parameters are passed in the command
    @Test
    public void testExecuteWhenInvalidNumberOfParameters() {
        RobotCommandImpl robotCommand = new RobotCommandImpl("1 2");
        robotCommand.execute(table);
        assertEquals("Invalid number of parameters. Expected 1, got 2\n", output.toString());
    }

    //Method to test invalid robot command where the parameter has a non integer
    @Test
    public void testExecuteWhenInvalidNumberFormatInParameter() {
        RobotCommandImpl robotCommand = new RobotCommandImpl("1a");
        robotCommand.execute(table);
        assertEquals("Invalid number format in parameter. Please enter a valid number.\n", output.toString());
    }
}
