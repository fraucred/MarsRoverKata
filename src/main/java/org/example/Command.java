package org.example;

public enum Command {
    F(false),
    B(false),
    L(true),
    R(true);

    private boolean isTurnAction;

    Command(boolean isTurnAction) {
        this.isTurnAction = isTurnAction;
    }

    public boolean isTurnAction() {
        return isTurnAction;
    }
}
