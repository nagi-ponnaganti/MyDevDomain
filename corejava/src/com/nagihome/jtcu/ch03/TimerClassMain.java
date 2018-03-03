package com.nagihome.jtcu.ch03;

import java.util.Timer;
import java.util.TimerTask;

public class TimerClassMain {

    public static void main(String[] args) {

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("This is a Timer Task");
                System.exit(0);
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 2000);

    }

}
