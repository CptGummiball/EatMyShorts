package org.cptgummiball.eatmyShorts;

public class CommandShortcut {
    private String execute;
    private String command;
    private boolean useArgs;

    public CommandShortcut(String execute, String command, boolean useArgs) {
        this.execute = execute;
        this.command = command;
        this.useArgs = useArgs;
    }

    public String getExecute() {
        return execute;
    }

    public String getCommand() {
        return command;
    }

    public boolean isUseArgs() {
        return useArgs;
    }
}
