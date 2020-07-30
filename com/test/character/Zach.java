package com.test.character;

import com.test.Color;

import java.util.Scanner;

public class Zach implements Character, Color {
    private int numCountTalked = 0;
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() throws InterruptedException {
        numCountTalked++;
        String[] zachInput = null;
        String[] zachInput1 = {
                ANSI_CYAN,
                "Zach: \"What did the crew name the Dragon DEMO 2 capsule?\"",
                "A. Endeavor",
                "B. Atlantis",
                "C. Dragon",
                "D. Enterprise",
                ANSI_RESET
        };
        String[] zachInput2 = {
                ANSI_CYAN,
                "Zach: \" I just bought a ticket for traveling with Dragon2. Would you like to come with me?",
                ANSI_RESET
        };
        if (numCountTalked == 1){
            zachInput = zachInput1;
        }
        else{
            zachInput = zachInput2;
        }

        for (String zach : zachInput) {
            Thread.sleep(sleep);
            System.out.println(zach);
        }

        Scanner sc = new Scanner(System.in);
        setQuestionAnswer(sc.next());
        return getQuestionAnswer();
    }

    @Override
    public String processQuestionAnswer(String questionAnswer) {
        String result = "";
        if (numCountTalked == 1) {
            if (questionAnswer.toUpperCase().equals("A")) {
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
        return "Recipe";
    }
}
