package main;

import main.commands.Command;
import main.commands.CommandParser;
import main.entity.Table;
import main.utils.Constants;

import java.util.Scanner;

public class RobotSimulator {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Table table = new Table();
            System.out.print(Constants.COMMAND_LIST_MESSAGE_LINE_1);
            for (String command : Constants.COMMAND_LIST) {
                System.out.print(command + Constants.SPACE);
            }
            System.out.println(Constants.COMMAND_LIST_MESSAGE_LINE_2);
            CommandParser commandParser = new CommandParser();
            System.out.print(Constants.ENTER_COMMAND_MESSAGE);
            while (scanner.hasNextLine()) {

                Command command = commandParser.parse(scanner.nextLine());
                if (command == null) {
                    System.out.println(Constants.INVALID_COMMAND_MESSAGE);
                    break;
                }
                command.execute(table);
                System.out.print(Constants.ENTER_COMMAND_MESSAGE);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
