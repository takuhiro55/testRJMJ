package com.test.character;

import com.test.Color;

import java.util.Scanner;

public class Tom implements Character, Color {
    private int numCountTalked = 0;
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() throws InterruptedException {
        numCountTalked++;
        String[] tomInput = null;
        String[] tomInput1 = {
                ANSI_CYAN,
                "Tom: \"What Online video game did Tom perform a wedding?\"",
                "A. Dungeons and Dragons",
                "B. World of Warcraft",
                "C. Diablo II",
                "D. Elder Scrolls",
                ANSI_RESET
        };

        String[] tomInput2 = {
                ANSI_CYAN,
                "Tom: \"Are you playing World of Warcraft?",
                ANSI_RESET
        };

        if (numCountTalked == 1){
            tomInput = tomInput1;
        }
        else{
            tomInput = tomInput2;
        }

        for (String tom : tomInput) {
            Thread.sleep(sleep);
            System.out.println(tom);
        }

        Scanner sc = new Scanner(System.in);
        setQuestionAnswer(sc.next());
        return getQuestionAnswer();
    }

    @Override
    public String processQuestionAnswer(String questionAnswer) {
        String result = "";
        if (numCountTalked == 1) {
            if (questionAnswer.toUpperCase().equals("B")) {
                System.out.println("Correct");
                result = getItem();
            } else {
                System.out.println("Incorrect, please try again.");
            }
        }
        return result;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getItem() {
        return ANSI_BLUE + "Blue Liquid" + ANSI_CYAN;
    }
}
