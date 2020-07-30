# testRJMJ

This project is the test of decoupling RJMJ project. 
I took Character classes from the original RJMJ and modified them slightly.


Some features:
- Room arrangements are changeable
- The location of characters are changeable
- Each class can take care actions such as "talkTo()" or "moveTo()" though interface, Game loop is simplified
- Each class is more easily testable because they are loosely coupled


How it works
Please look at "Client" in "com.test"
1. Specify neighbor rooms with EnumMap<Direction, RoomName> 
  -> Both "Direction" and "RoomName" are Enum
  In this project, I made 2 directions "LEFT" and "RIGHT" to move for testing
2. Store instances of Room into "RoomName" Enum
  When Room classes are instantiated, Character and neighbor rooms are set though the constructor.
3. Instantiate Player with initial room where the player is in when the player starts playing the game

