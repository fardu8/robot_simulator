package test.commands.impl;

import main.commands.impl.PlaceCommandImpl;
import main.entity.Table;
import main.utils.Directions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PlaceCommandImplTest {

    private Table table;
    private PlaceCommandImpl placeCommand;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        table = new Table();
        placeCommand = new PlaceCommandImpl();
        System.setOut(new PrintStream(output));
    }

    //Method to test valid place command
    @Test
    void testExecuteWithValidParams() {
        placeCommand.setParams("1,1,NORTH");
        placeCommand.execute(table);
        assertEquals(1, table.getRobotsOnTable().size());
        assertEquals(0, table.getActiveRobotIdentifier());
        assertEquals(1, table.getActiveRobot().getX());
        assertEquals(1, table.getActiveRobot().getY());
        assertEquals(Directions.NORTH, table.getActiveRobot().getDirection());
    }

    //Method to test invalid place command where we are trying to place a robot out of table bounds
    @Test
    void testExecuteWithInvalidParamsForPosition() {
        placeCommand.setParams("6,6,NORTH");
        placeCommand.execute(table);
        assertEquals("Position is out of bounds for table.\nPlease enter a valid position.\n", output.toString());
        assertEquals(0, table.getRobotsOnTable().size());
        assertEquals(-1, table.getActiveRobotIdentifier());
    }

    //Method to test invalid place command where we are providing an invalid direction
    @Test
    void testExecuteWithInvalidParamsForDirection() {
        placeCommand.setParams("4,4,abc");
        placeCommand.execute(table);
        assertEquals("Invalid direction.\nPlease enter a valid direction.\n", output.toString());
        assertEquals(0, table.getRobotsOnTable().size());
        assertEquals(-1, table.getActiveRobotIdentifier());
    }

    //Method to test invalid place command where we are providing non integers as a parameter
    @Test
    public void testExecuteWhenInvalidNumberFormatInParameter() {
        placeCommand.setParams("a,a,NORTH");
        placeCommand.execute(table);
        assertEquals("Entered position is not a number.\nPlease enter a valid number.\n", output.toString());
    }

}
