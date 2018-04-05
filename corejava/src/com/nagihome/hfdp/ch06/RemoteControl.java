package com.nagihome.hfdp.ch06;

import java.util.stream.IntStream;

public class RemoteControl {

    private final int remoteBtnSize = 7;
    private Command[] onCommands = new Command[remoteBtnSize];
    private Command[] offCommands = new Command[remoteBtnSize];

    public RemoteControl() {
        IntStream.range(0, remoteBtnSize).forEach(
                i -> {
                    onCommands[i] = () -> {
                    };
                    offCommands[i] = () -> {
                    };
                }
        );
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                    + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuff.toString();
    }
}
