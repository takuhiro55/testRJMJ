package com.test.room;

import com.test.character.Character;
import com.test.character.QAEnum;
import com.test.layout.Direction;
import com.test.player.Player;

import java.io.IOException;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bathroom implements Room{

    public final String ROOM_ASCII_ART = RoomAsciiArt.bathroomDisplay();
    public final RoomName ROOM_NAME = RoomName.BATHROOM;
    private Character character;
    private EnumMap<Direction, RoomName> roomNeighbors = new EnumMap<>(Direction.class);
    Player player;
    Scanner scanner;

    /**
     * Constructor:
     * - Set instructor who is in the room
     * - Set neighbour rooms
     * */
    public Bathroom(Character character, EnumMap<Direction, RoomName> roomNeighbors){
        this.character = character;
        this.roomNeighbors = roomNeighbors;
    }

    @Override
    public void enter(Player player, Scanner scanner) throws IOException, InterruptedException {
        this.player = player;
        this.scanner = scanner;
        System.out.println("Welcome to Bathroom!");
        displayRoomAsciiArt();
        Question1();
    }

    private void Question1() throws IOException, InterruptedException {
        System.out.println("What would you like to do?");
        String type = scanner.nextLine();
        if (type.equalsIgnoreCase("talk")){
            String ans = player.talkTo();
            if ((ans.equals(QAEnum.CORRECT.name()))){
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
            player.moveTo(Direction.LEFT);
        }
        else if(type.equalsIgnoreCase("right")){
            player.moveTo(Direction.RIGHT);
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
    public String talkToCharacter() throws IOException, InterruptedException {

        String response;
        String questionAnswer;
        response = character.askTheQuestionAndCollectInput();
        questionAnswer = getCharacter().processQuestionAnswer(response);
        return questionAnswer;
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
