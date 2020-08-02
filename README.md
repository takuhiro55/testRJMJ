# testRJMJ

This is a project for testing concept of mechanics of a game.

The original project was from https://github.com/Capstone-RJMJ/capstone.
In the training, we were given a task to refactor the original project and add more features.
I wanted to try the concepts of "loose coupling" and "Open for expansion and closed for modification", and I made this project to see the concepts. 
Character classes and AsciiArt were from the original project, and I modified them.


Main mechanics of the original game:
- When you go into the room, you have options of things you can do in the room : "Move", "Look around", "Talk", "Take items", "Map", "Exit"
    - "Look around" : when you type "Look around", it will list up what items, who you can find and what doors you see in what directions (e.g. "a door to the Dining Room to the LEFT")
    - "Move" : when you type "Move", they will ask you what direction you want to go. Then you can move to the room
    - "Talk" : when you type "talk", character in the room starts talking or giving you a quiz. When you get the right answer of the quiz, the character will give you an item.
    - "Take items" : when you type "take items" : you can get an item in the room
    - "Map" : When you type "Map", it will display the general map
- If you have enough items, you have an option to mix materials

Things modified from the original:
    -> In the original project, relationship between rooms, characters, neighbor rooms, items were defined in a Map called "ROOMS" in a class "Rooms"

        How I modified: 
        - To define the "neighboring" rooms, I created a EnumMap<DirectionEnum, RoomNameEnum> for each room and define a room for each direction
        - To define the relationship between a room and a character, I passed the instance of the character when I instantiate the room
        - To create a link between EnumMap<DirectionEnum, RoomNameEnum> and each room, pass the name of the EnumMap when I instantiate the room along with the instance of a character
        - The room instances are stored in "RoomNameEnum" so that we can establish the clear relationship between the name of the room and the instance. 
            -> Above 4 things are done in "configure()" in "Game" class
        - Creating class file for each room. These files are implemented with Interface "Room" 
     
        Benefits of the change:    
        - Room arrangements are more easily changeable
        - The relationship between rooms and characters are easily changeable
        - Since the interface "Room" defines actions the player can do in the room such as "talkToCharacter" and "leaveRoomTo", the Game loop can be simplified
        - Freely add characters and rooms without affecting other parts of the program
            -> only things need to be changed are 
                1. adding the name of the new room in "RoomNameEnum" 
                2. adding or modifying the code in "configure()" in "Game" Class defining the relationship between rooms and characters
        - Each room can uniquely define the experience of the player within the room
        - Give more flexibility to developers how they setup the Game environment with multi-players
            - Developers can choose if they want to use one instance for each room or character
                -> For example, some of the rooms are setup only 1 instance for the whole game, so that if one player takes an item in the room, the item is not available for the other player to take  


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