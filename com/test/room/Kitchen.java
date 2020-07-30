package com.test.room;

import com.test.character.Character;
import com.test.layout.Direction;

import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;

public class Kitchen implements Room{

    public final String ROOM_ASCII_ART = RoomAsciiArt.kitchenDisplay();
    public final RoomName ROOM_NAME = RoomName.KITCHEN;
    private Character character;
    private EnumMap<Direction, RoomName> roomNeighbors = new EnumMap<>(Direction.class);

    /**
     * Constructor:
     * - Set instructor who is in the room
     * - Set neighbour rooms
     * */
    public Kitchen(Character character, EnumMap<Direction, RoomName> roomNeighbors){
        this.character = character;
        this.roomNeighbors = roomNeighbors;
    }

    /**
     * Method is used to talk to the instructor in the room
     * */
    @Override
    public String talkToCharacter() throws IOException, InterruptedException {

        String response;
        String item;
        while (true) {
            response = character.askTheQuestionAndCollectInput();
            item = getCharacter().processQuestionAnswer(response);
            if (!item.equals("")){
                //System.out.println(item);
                break;
            }
        }
        return item;
    }

    /**
     * Move to a neighboring room
     * */
    @Override
    public Room leaveRoomTo(Direction direction) {
        return roomNeighbors.get(direction).getRoomInstance();
    }

    @Override
    public void displayRoomAsciiArt() {
        System.out.println(ROOM_ASCII_ART);
    }

    public String toString(){
        return ROOM_NAME.name();
    }

    @Override
    public Character getCharacter() {
        return character;
    }

}
