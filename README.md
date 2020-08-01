# testRJMJ

This project is the test of decoupling RJMJ project. 
I took Character classes and AsciiArt from the original RJMJ and modified them slightly.


Some features:
- Room arrangement is more easily changeable
- The locations of characters are changeable
- Since each room class can take care actions such as "talkToCharacter" or "leaveRoomTo" though interface, Game loop is simplified
- Each class is more easily testable because they are loosely coupled
- If you talk to the same character more than one time, the message is changed


How it works:
1. Specify neighbor rooms with EnumMap<DirectionEnum, RoomNameEnum> 
  -> Both "DirectionEnum" and "RoomNameEnum" are Enum
  In this project, I made 2 directions "LEFT" and "RIGHT" to move for testing
2. Store instances of Room into "RoomNameEnum"
  When Room classes are instantiated, Character and neighbor rooms are set though the constructor.
3. Instantiate Player with initial room where the player starts game


How to play:
You can execute this program from "Client" in "com.test".
When you go into each room, the program ask you "What would you like to do?".
Choose one word from below and type:
- "talk" : talk to a character in the room
- "listup" : listup items the player has
- "left" : move to a room connected to left
- "right" : move to a room connected to right
- "quit" : quit the game


Room arrangement in this project:
	Kitchen / Lab / Bathroom