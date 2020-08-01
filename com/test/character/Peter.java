package com.test.character;

import com.test.Color;

import java.util.Scanner;

public class Peter implements Character, Color {
    private boolean talkedOnce = false;
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() {
        String[] peterInput = {
                ANSI_CYAN,
                "Peter: \"How many possible versions of the vaccine are there if each ingredient is used once?\"",
                "A. 3",
                "B. 27",
                "C. 9",
                "D. 6",
                ANSI_RESET
        };

        System.out.println("\nPeter is standing at the entrance to the Library. " +
                "He will not let you continue unless you correctly answer this math question:\n");

        try {
            for (String peter : peterInput) {
                Thread.sleep(SLEEP_DURATION);
                System.out.println(peter);
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
            if (questionAnswer.toUpperCase().equals("D")) {
                talkedOnce = true;
                result = QAEnum.CORRECT;
            } else {
                System.out.println("Incorrect, please try again.");
                result = QAEnum.INCORRECT;
            }
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

    // Note: This is never actually passed into the players inventory, just for verification purposes.
    // Book of Knowledge sounded a lot better then "Thing" or "Check".
    public String getItem() {
        return "The Book of Knowledge";
    }
}