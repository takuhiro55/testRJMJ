package com.test.room;

import com.test.character.Character;
import com.test.layout.Direction;
import com.test.player.Player;

import java.io.IOException;
import java.util.Scanner;

public interface Room {

    /**
     * Entry point of the room
     * Under this method, each story in the room is written
     * */
    public void enter(Player player, Scanner scanner) throws IOException, InterruptedException;

    /**
     * Method is used to talk to the instructor in the room
     * */
    public String talkToCharacter() throws IOException, InterruptedException;

    /**
     * Move to a neighboring room
     * */
    public Room leaveRoomTo(Direction direction);

    public void displayRoomAsciiArt();

    public Character getCharacter();

}
