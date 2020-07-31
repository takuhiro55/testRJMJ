package com.test.room;

import com.test.character.Character;
import com.test.layout.Direction;

import java.io.IOException;

public interface Room {

    /**
     * Entry point of the room
     * Under this method, each story in the room is written
     * */
    public void enter();

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
