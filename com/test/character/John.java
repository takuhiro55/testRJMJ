package com.test.character;

//import com.rjmj.capstone.engines.MovementEngine;

import com.test.game.Color;

import java.util.Scanner;

public class John implements Character, Color {
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() {
        String[] johnInput = {
                ANSI_CYAN,
                "John: \"What is AWS' DNS Service?\"",
                "A. S3",
                "B. EC2",
                "C. Route 53",
                "D. Lambda",
                ANSI_RESET
        };

        try {
            for (String john : johnInput) {
                Thread.sleep(SLEEP_DURATION);
                System.out.println(john);
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
//        MovementEngine movementEngine = new MovementEngine();
        QAEnum result = null;
//        if (questionAnswer.toUpperCase().equals("C")) {
//            movementEngine.clearScreen();
//            System.out.println("Correct");
//            result = getItem();
//        } else {
//            movementEngine.clearScreen();
//            System.out.println("Incorrect, please try again.");
//        }
        return result;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getItem() {
        return "Key";
    }
}
