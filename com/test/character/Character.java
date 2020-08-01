package com.test.character;

import java.io.IOException;
import java.util.Scanner;

public interface Character {
    final int SLEEP_DURATION = 650;


    // This will warn you that the return value is never used, but it is in the characters.
    String askTheQuestionAndCollectInput();

    QAEnum processQuestionAnswer(String questionAnswer);

    public default void somethingWentWrong(Exception e){
        System.out.println("****** Something went wrong ******");
        System.out.println("Place: " + getClass().getName());
        System.out.println("Exception message : "+ e.getMessage());
    }

    String getItem();
}
