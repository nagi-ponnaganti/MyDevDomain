package com.nagihome.hfdp.ch06;

public class RemoteLoader {

    public static void main(String[] args) {

        RemoteControl remoteControl = new RemoteControl();
        Light livingRoomLight = new Light("Living Room");
        Light kitchenRoomLight = new Light("Kitchen Room");
        GarageDoor garageDoor = new GarageDoor("Garage Door");
        CeilingFan livingRoomFan = new CeilingFan("Living Room");
        Stereo livingRoomStereo = new Stereo("Living Room");

        remoteControl.setCommand(0, livingRoomLight::on, livingRoomLight::off);
        remoteControl.setCommand(1, kitchenRoomLight::on, kitchenRoomLight::off);
        remoteControl.setCommand(2, livingRoomFan::high, livingRoomFan::off);
        Command stereoOnWithCD = () -> {
            livingRoomStereo.on();
            livingRoomStereo.setCD();
            livingRoomStereo.setVolume(11);
        };
        remoteControl.setCommand(3, stereoOnWithCD, livingRoomStereo::off);
        remoteControl.setCommand(4, garageDoor::up, garageDoor::down);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);
        remoteControl.onButtonWasPushed(5);
    }

}
