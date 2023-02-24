package main.commands.impl;

import main.commands.Command;
import main.entity.Robot;
import main.entity.Table;
import main.utils.Constants;

public class ReportCommandImpl implements Command {

    private String params;

    @Override
    public String getParams() {
        return params;
    }

    @Override
    public void setParams(String params) {
        this.params = params;
    }

    public ReportCommandImpl(String params) {
        this.params = params;
    }

    public ReportCommandImpl() {
        this.params = Constants.EMPTY_STRING;
    }

    @Override
    public void execute(Table table) {
        try {
            if (table.getActiveRobotIdentifier() >= 0) {
                Robot activeRobot = table.getActiveRobot();
                if (table.getRobotsOnTable().size() == 1) {
                    System.out.println("There is only one robot on the table.");
                } else {
                    System.out.printf("There are %d robots on the table\n", table.getRobotsOnTable().size());
                }
                System.out.printf("Robot %d is currently active\n", table.getActiveRobotIdentifier() + 1);
                System.out.println(activeRobot);
            } else {
                System.out.println("There are no robots on the table.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
