package com.test.character;

import com.test.Color;

import java.util.Scanner;

public class Tom implements Character, Color {
    private boolean talkedOnce = false;
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() throws InterruptedException {

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

        if (!talkedOnce){
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
        if (!talkedOnce) {
            if (questionAnswer.toUpperCase().equals("B")) {
                talkedOnce = true;
                System.out.println("Correct");
                //result = getItem();
                result = QAEnum.CORRECT.name();
            }
            else {
                System.out.println("Incorrect, please try again.");
                result = QAEnum.INCORRECT.name();
            }
        }
        else{
            // Work around, so that you can take next actions -> result == "" recognizes as incorrect answer
            //result = getItem();
            result = QAEnum.PASS.name();
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
