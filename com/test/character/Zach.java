package com.test.character;

import com.test.Color;

import java.util.Scanner;

public class Zach implements Character, Color {
    private boolean talkedOnce = false;
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() {
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

        zachInput = !talkedOnce ? zachInput1 : zachInput2;

        try {
            for (String zach : zachInput) {
                Thread.sleep(SLEEP_DURATION);
                System.out.println(zach);
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
            if (questionAnswer.toUpperCase().equals("A")) {
                talkedOnce = true;
                result = QAEnum.CORRECT;
            } else {
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
        return "Recipe";
    }
}
