package com.test;


import com.test.character.Nelly;
import com.test.character.Tom;
import com.test.character.Zach;
import com.test.layout.Direction;
import com.test.player.Player;
import com.test.room.Bathroom;
import com.test.room.Kitchen;
import com.test.room.Lab;
import com.test.room.RoomName;

import java.io.IOException;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {

        /**
         * This program can be put into other than psvm
         * This allows us dynamically configure
         * - Layout of rooms
         * - Instructor in the room
         * -> Everything is not tightly coupled
         * */


        /**
         * Define neighbor rooms
         * - Kitchen [RIGHT : LAB, LEFT : null]
         * - Lab [RIGHT : BATHROOM, LEFT : KITCHEN]
         * - Bathroom [Right : null, LEFT : LAB]
         * */
        // Kitchen
        EnumMap<Direction, RoomName> roomNeighbors_Kitchen = new EnumMap<>(Direction.class);
        roomNeighbors_Kitchen.put(Direction.RIGHT, RoomName.LAB);

        // Lab
        EnumMap<Direction, RoomName> roomNeighbors_Lab = new EnumMap<>(Direction.class);
        roomNeighbors_Lab.put(Direction.RIGHT, RoomName.BATHROOM);
        roomNeighbors_Lab.put(Direction.LEFT, RoomName.KITCHEN);

        // Bathroom
        EnumMap<Direction, RoomName> roomNeighbors_Bathroom = new EnumMap<>(Direction.class);
        roomNeighbors_Bathroom.put(Direction.LEFT, RoomName.LAB);

        /**
         * Store instance of Rooms into Enum
         * */
        RoomName.LAB.setRoomInstance(new Lab(new Nelly(), roomNeighbors_Lab));
        RoomName.KITCHEN.setRoomInstance(new Kitchen(new Tom(), roomNeighbors_Kitchen));
        RoomName.BATHROOM.setRoomInstance(new Bathroom(new Zach(), roomNeighbors_Bathroom));

        /**
         * Set Default initial room for a player
         * */
        Player player = new Player(RoomName.BATHROOM.getRoomInstance());
        Scanner scanner = new Scanner(System.in);

        /**
         * Game loop
         * */
        //System.out.println(player.getCurrentRoom());
        while(true) {
            player.enter(player, scanner);

        }
    }
}
