package com.test.player;

import com.test.character.QAEnum;
import com.test.layout.Direction;
import com.test.room.Room;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Player {

    private Set<String> items = new HashSet<>();
    private Room currentRoom;
    private boolean movedToNewRoomSuccessful = false;


    /**
     * Constructor
     * Set where the player is when the game start
     * */
    public Player(Room initialRoom){
        currentRoom = initialRoom;
    }

    public void enter(Player player, Scanner scanner) throws IOException, InterruptedException {
        currentRoom.enter(player, scanner);
    }

    /**
     *  Method used for talking to an instructor in the room
     * */
    public String talkTo() throws IOException, InterruptedException {
        return currentRoom.talkToCharacter();
    }

    public void registerItem(String item){
        items.add(item);
    }

    /**
     * Method used for moving from one room to the other
     * -> Store next room in 'currentRoom'
     * -> set variable "movedToNewRoomSuccessful" TRUE
     * -> If no room available, it will generate "NullPointerException", so catch it
     *  and client needs to ask the player one more time
     * */
    public void moveTo(Direction direction){
        try {
            currentRoom = currentRoom.leaveRoomTo(direction);
            //currentRoom.displayRoomAsciiArt();
            System.out.println("Direction :" + direction);

            System.out.println("Now you moved to " + currentRoom);
            movedToNewRoomSuccessful = true;
        }
        catch(NullPointerException e){
            System.out.println("No room");
        }
    }

    /**
     * Method to return a variable for "movedToNewRoomSuccessful"
     * Client needs to use this variable and see if the player moves to a different room successfully
     *
     * @return
     * true : successfully moved to a different room
     * false : not successfully moved to a different room
     * */
    public boolean isMovedToNewRoomSuccessful() {
        boolean _movedToNewRoomSuccessful = movedToNewRoomSuccessful;
        movedToNewRoomSuccessful = false;
        return _movedToNewRoomSuccessful;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Set<String> getListItems() {
        return items;
    }
}
