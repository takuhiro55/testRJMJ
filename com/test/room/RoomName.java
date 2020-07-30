package com.test.room;

public enum RoomName {
    KITCHEN(null),
    LAB(null),
    BATHROOM(null);


    /***************** DO NOT TOUCH BELOW *****************/
    private Room roomInstance;

    // Constructor
    RoomName(Room roomInstance){
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
