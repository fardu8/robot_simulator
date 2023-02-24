package main.commands;

import main.entity.Table;

public interface Command {
    void setParams(String params);

    String getParams();

    void execute(Table table);
}
