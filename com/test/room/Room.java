package com.test.room;

import com.test.character.Character;
import com.test.character.QAEnum;
import com.test.layout.DirectionEnum;
import com.test.player.Player;

import java.io.IOException;
import java.util.Scanner;

public interface Room {

    /**
     * Entry point of the room
     * Under this method, each story in the room is written
     * */
    public void enter(Player player, Scanner scanner);

    /**
     * Method is used to talk to the instructor in the room
     * */
    public QAEnum talkToCharacter();

    /**
     * Move to a neighboring room
     * */
    public Room leaveRoomTo(DirectionEnum directionEnum);

    public void displayRoomAsciiArt();

    public Character getCharacter();

}
