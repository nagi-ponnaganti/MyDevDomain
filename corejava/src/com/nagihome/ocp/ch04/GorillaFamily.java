package com.nagihome.ocp.ch04;

public class GorillaFamily {

    private final String walk = "walk";

    public void everyonePlay(final boolean baby) {
        String approach = "amble";
        play(() -> walk);
        play(() -> baby ? "Yes" : "No");
        play(() -> approach);
    }

    public void play(Gorilla g) {
        System.out.println(g.move());
    }

    public static void main(String[] args) {
        new GorillaFamily().everyonePlay(true);
    }

}
