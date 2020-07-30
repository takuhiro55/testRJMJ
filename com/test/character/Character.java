package com.test.character;

import java.io.IOException;

public interface Character {
//    String ANSI_RESET = "\u001B[0m";
//    String ANSI_CYAN = "\u001B[36m";
//    String ANSI_RED = "\u001B[31m";
//    String ANSI_BLUE = "\u001B[34m";
    int sleep = 650;


    // This will warn you that the return value is never used, but it is in the characters.
    String askTheQuestionAndCollectInput() throws IOException, InterruptedException;

    String processQuestionAnswer(String questionAnswer) throws IOException, InterruptedException;
}
