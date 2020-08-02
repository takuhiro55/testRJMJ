package com.test.room;

public enum RoomNameEnum {
    KITCHEN(null),
    LAB(null),
    BATHROOM(null);


    /***************** DO NOT TOUCH BELOW *****************/
    private Room roomInstance;

    // Constructor
    RoomNameEnum(Room roomInstance){
        this.roomInstance = roomInstance;
    }

    /**
     * Get instance of room stored in the instance of enum
     * */
    public Room getRoomInstance(){
        return roomInstance;
    }

    /**
     * Set instance of room to the enum instance
     * */
    public void setRoomInstance(Room roomInstance) {
        this.roomInstance = roomInstance;
    }
}
