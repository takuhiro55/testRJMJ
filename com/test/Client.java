package com.test;


import com.test.game.Game;
import com.test.player.Player;

import java.util.Scanner;

public class Client {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        Game.configure();
        Game.execute(scanner);
    }
}
