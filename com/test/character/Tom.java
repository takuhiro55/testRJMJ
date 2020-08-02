package com.test.character;

import com.test.game.Color;

import java.util.Scanner;

public class Tom implements Character, Color {
    private boolean talkedOnce = false;
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput(){

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

        tomInput = !talkedOnce ? tomInput1:tomInput2;

        try {
            for (String tom : tomInput) {
                Thread.sleep(SLEEP_DURATION);
                System.out.println(tom);
            }
        }
        catch(Exception e){
            somethingWentWrong(e);
            System.out.println("Look for \"Thread.sleep(sleep);\"");
        }
        Scanner sc = new Scanner(System.in);
        setQuestionAnswer(sc.next());
        return getQuestionAnswer();
    }

    @Override
    public QAEnum processQuestionAnswer(String questionAnswer) {
        QAEnum result = null;
        if (!talkedOnce) {
            if (questionAnswer.toUpperCase().equals("B")) {
                talkedOnce = true;
                result = QAEnum.CORRECT;
            }
            else {
                result = QAEnum.INCORRECT;
            }
            System.out.println(result.name());
        }
        else{
            result = QAEnum.PASS;
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
