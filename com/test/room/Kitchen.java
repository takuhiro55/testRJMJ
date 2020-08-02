package com.test.room;

import com.test.character.Character;
import com.test.character.QAEnum;
import com.test.layout.DirectionEnum;
import com.test.player.Player;

import java.io.IOException;
import java.util.*;

public class Kitchen implements Room{

    public final String ROOM_ASCII_ART = RoomAsciiArt.kitchenDisplay();
    public final RoomNameEnum ROOM_NAME = RoomNameEnum.KITCHEN;
    private Character character;
    private EnumMap<DirectionEnum, RoomNameEnum> roomNeighbors = new EnumMap<>(DirectionEnum.class);
    private Player player;
    private Scanner scanner;

    /**
     * Constructor:
     * - Set instructor who is in the room
     * - Set neighbour rooms
     * */
    public Kitchen(Character character, EnumMap<DirectionEnum, RoomNameEnum> roomNeighbors){
        this.character = character;
        this.roomNeighbors = roomNeighbors;
    }

    /**
     * Entry point of the room
     * Player access to the story of the room through "enter()"
     * */
    @Override
    public void enter(Player player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;

        // This if- statement is for preventing the message and ASCII Art popping out after player select direction which does not have room
        if (player.isMovedToNewRoomSuccessful()) {
            System.out.println("Welcome to " + ROOM_NAME);
            displayRoomAsciiArt();
        }

        // Temporary
        Question1();
    }

    private void Question1() {
        System.out.println("What would you like to do?");
        String type = scanner.nextLine();
        if (type.equalsIgnoreCase("talk")){
            QAEnum ans = player.talkTo();
            if ((ans.equals(QAEnum.CORRECT))){
                String item = player.getCurrentRoom().getCharacter().getItem();
                player.registerItem(item);
            }
            Question1();
        }
        else if(type.equalsIgnoreCase("listup")){
            Set<String> items = new HashSet<>();
            items = player.getListItems();
            System.out.println("\n----- This is the list of items -----");
            for(String item : items){
                System.out.println(item);
            }
            System.out.println("---------------------------------------");
            Question1();
        }
        else if(type.equalsIgnoreCase("left")) {
            player.moveTo(DirectionEnum.LEFT);
        }
        else if(type.equalsIgnoreCase("right")){
            player.moveTo(DirectionEnum.RIGHT);
        }
        else if(type.equalsIgnoreCase("quit")){
            System.exit(0);
        }
        else{
            System.out.println("Try again");
        }
    }

    /**
     * Method is used to talk to the instructor in the room
     * */
    @Override
    public QAEnum talkToCharacter() {
        String response = character.askTheQuestionAndCollectInput();
        return getCharacter().processQuestionAnswer(response);
    }

    /**
     * Move to a neighboring room
     * */
    @Override
    public Room leaveRoomTo(DirectionEnum directionEnum) {
        return roomNeighbors.get(directionEnum).getRoomInstance();
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
