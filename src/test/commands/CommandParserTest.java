package test.commands;

import main.commands.Command;
import main.commands.CommandParser;
import main.commands.impl.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandParserTest {

    //Method to test place command being parsed
    @Test
    public void testParsePlaceCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("PLACE 1,2,EAST");
        assertNotNull(command);
        assertTrue(command instanceof PlaceCommandImpl);
        assertEquals("1,2,EAST", command.getParams());
    }

    //Method to test move command being parsed
    @Test
    public void testParseMoveCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("MOVE");
        assertNotNull(command);
        assertTrue(command instanceof MoveCommandImpl);
        assertEquals("", command.getParams());
    }

    //Method to test left command being parsed
    @Test
    public void testParseLeftCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("LEFT");
        assertNotNull(command);
        assertTrue(command instanceof LeftCommandImpl);
        assertEquals("", command.getParams());
    }

    //Method to test right command being parsed
    @Test
    public void testParseRightCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("RIGHT");
        assertNotNull(command);
        assertTrue(command instanceof RightCommandImpl);
        assertEquals("", command.getParams());
    }

    //Method to test report command being parsed
    @Test
    public void testParseReportCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("REPORT");
        assertNotNull(command);
        assertTrue(command instanceof ReportCommandImpl);
        assertEquals("", command.getParams());
    }

    //Method to test robot command being parsed
    @Test
    public void testParseRobotCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("ROBOT 1");
        assertNotNull(command);
        assertTrue(command instanceof RobotCommandImpl);
        assertEquals("1", command.getParams());
    }

    //Method to test unknown command being parsed
    @Test
    public void testParseUnknownCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("JUMP");
        assertNull(command);
    }

}
