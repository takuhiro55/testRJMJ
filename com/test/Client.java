package com.test;


import com.test.character.Nelly;
import com.test.character.Tom;
import com.test.character.Zach;
import com.test.layout.DirectionEnum;
import com.test.player.Player;
import com.test.room.Bathroom;
import com.test.room.Kitchen;
import com.test.room.Lab;
import com.test.room.RoomNameEnum;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Scanner;

public class Client {

    public static void main(String[] args){

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
        EnumMap<DirectionEnum, RoomNameEnum> roomNeighbors_Kitchen = new EnumMap<>(DirectionEnum.class);
        roomNeighbors_Kitchen.put(DirectionEnum.RIGHT, RoomNameEnum.LAB);

        // Lab
        EnumMap<DirectionEnum, RoomNameEnum> roomNeighbors_Lab = new EnumMap<>(DirectionEnum.class);
        roomNeighbors_Lab.put(DirectionEnum.RIGHT, RoomNameEnum.BATHROOM);
        roomNeighbors_Lab.put(DirectionEnum.LEFT, RoomNameEnum.KITCHEN);

        // Bathroom
        EnumMap<DirectionEnum, RoomNameEnum> roomNeighbors_Bathroom = new EnumMap<>(DirectionEnum.class);
        roomNeighbors_Bathroom.put(DirectionEnum.LEFT, RoomNameEnum.LAB);



        /**
         * Store instance of Rooms into Enum
         * */
        RoomNameEnum.LAB.setRoomInstance(new Lab(new Nelly(), roomNeighbors_Lab));
        RoomNameEnum.KITCHEN.setRoomInstance(new Kitchen(new Tom(), roomNeighbors_Kitchen));
        RoomNameEnum.BATHROOM.setRoomInstance(new Bathroom(new Zach(), roomNeighbors_Bathroom));



        /**
         * Set Default initial room for a player
         * */
        Player player = new Player(RoomNameEnum.BATHROOM.getRoomInstance());
        Scanner scanner = new Scanner(System.in);

        /**
         * Game loop
         * */
        while(true) {
            player.enter(player, scanner);

        }
    }
}
