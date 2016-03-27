package scripts.SPXAIOMiner.api.framework;

import scripts.SPXAIOMiner.data.Variables;

public abstract class Task {

    protected Variables vars;

    public Task(Variables v) {
        vars = v;
    }

    public abstract void execute();

    public abstract String toString();

    public abstract boolean validate();

}

